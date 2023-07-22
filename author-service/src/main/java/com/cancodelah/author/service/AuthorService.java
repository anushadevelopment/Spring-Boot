package com.cancodelah.author.service;

import com.cancodelah.author.VO.*;
import com.cancodelah.author.entity.Author;
import com.cancodelah.author.repository.AuthorRepository;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;


@Service
@Builder
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private RestTemplate restTemplate;
    private List<Author> authors;

    public Author saveAuthor(Author author) {

        return authorRepository.save(author);
    }

    public Author findAuthorById(Long authorId) {

        return authorRepository.findByAuthorId(authorId);
    }

    public ResponseTemplateVO getBooksWithAuthorId(Long authorId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Author author = authorRepository.findByAuthorId(authorId);

        //BookList booksResponse =
        //      restTemplate.getForObject
        //            ("http://localhost:9004/books/author/"+author.getAuthorId(), BookList.class);

        ResponseEntity<List<Book>> booksResponse =
                restTemplate.exchange("http://BOOK-SERVICE/books/author/" + author.getAuthorId(),
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Book>>() {
                        });
        List<Book> books = booksResponse.getBody();
        vo.setAuthor(author);
        vo.setBooks(books);
        return vo;

    }

    /*public ResponseTemplateVO getBooksByAuthorFirstName(String authorFirstName) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        List<Author> authors = authorRepository.findByAuthorFirstName(authorFirstName);
        Iterator author_itr = authors.iterator();
        Map<String, String> author_dict = new HashMap<String, String>();
        while (author_itr.hasNext()) {
            Author author = (Author) author_itr.next();
            *//*System.out.println(author.getAuthorFirstName());
            System.out.println(author.getAuthorLastName());
            System.out.println(author.getAuthorId());*//*

            author_dict.put("authorFirstName", String.valueOf(author.getAuthorFirstName()));
            author_dict.put("authorLastName", String.valueOf(author.getAuthorLastName()));
            ResponseEntity<List<Book>> booksResponse =
                    restTemplate.exchange("http://BOOK-SERVICE/books/author/" + author.getAuthorId(),
                            HttpMethod.GET, null, new ParameterizedTypeReference<List<Book>>() {
                            });
            List<Book> books = booksResponse.getBody();

            author_dict.put("books", books.toString());*/

           // System.out.println(author_dict);

/*

        }
        return vo;*/
    //
    //}

    public List<BooksByAuthorNameResponse> getBooksByAuthorFirstName(String authorFirstName){
        List<Author> authors = authorRepository.findByAuthorFirstName(authorFirstName);

        Iterator author_itr = authors.iterator();
        //Map<String, String> author_dict = new HashMap<String, String>();
        List<BooksByAuthorNameResponse> booksByAuthorNameResponseList = new ArrayList<>();
        while (author_itr.hasNext()) {
            Author author = (Author) author_itr.next();
            ResponseEntity<List<Book>> books_res =
                    restTemplate.exchange("http://BOOK-SERVICE/books/author/" + author.getAuthorId(),
                            HttpMethod.GET, null, new ParameterizedTypeReference<List<Book>>() {
                            });
            List<Book> books = books_res.getBody();

            List<BookResponse> bookResponseList = books.stream()
                    .map(book -> new BookResponse(book.getBookName(), book.getBookGenre()))
                    .collect(Collectors.toList());

            BooksByAuthorNameResponse booksByAuthorNameResponse = BooksByAuthorNameResponse.builder()
                    .authorFirstName(author.getAuthorFirstName())
                    .authorLastName(author.getAuthorLastName())
                    .bookResponseList(bookResponseList)
                    .build();
            booksByAuthorNameResponseList.add(booksByAuthorNameResponse);
        }
        return booksByAuthorNameResponseList;
    }


    public List<BooksByAuthorNameResponse> getBooksByAuthorFirstnameOrLastname(String name) {

        List<Author> authors = authorRepository.findByAuthorFirstNameOrLastName(name);
        List<BooksByAuthorNameResponse> booksByAuthorNameResponseList = new ArrayList<>();
        Iterator author_itr = authors.iterator();

        while (author_itr.hasNext()){
            Author author = (Author) author_itr.next();

            ResponseEntity<List<Book>> books_res =
                    restTemplate.exchange("http://BOOK-SERVICE/books/author/" + author.getAuthorId(),
                            HttpMethod.GET, null, new ParameterizedTypeReference<List<Book>>() {
                            });
            List<Book> books = books_res.getBody();
            List<BookResponse> bookResponseList = books.stream()
                    .map(book-> new BookResponse(book.getBookName(), book.getBookGenre()))
                    .collect(Collectors.toList());
            BooksByAuthorNameResponse booksByAuthorNameResponse = BooksByAuthorNameResponse.builder()
                    .authorFirstName(author.getAuthorFirstName())
                    .authorLastName(author.getAuthorLastName())
                    .bookResponseList(bookResponseList)
                    .build();
            booksByAuthorNameResponseList.add(booksByAuthorNameResponse);
        }
        return booksByAuthorNameResponseList;

    }
}








