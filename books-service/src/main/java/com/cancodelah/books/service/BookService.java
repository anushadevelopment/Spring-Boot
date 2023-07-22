package com.cancodelah.books.service;

import com.cancodelah.books.entity.Book;
import com.cancodelah.books.respository.BookRepository;
import com.cancodelah.books.vo.*;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Builder
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Book findBookById(Long bookId) {
        return bookRepository.findByBookId(bookId);
    }

    public List<Book> findBookByAuthorId(Long authorId) {
        return bookRepository.findByAuthorId(authorId);
    }

    public ResponseTemplateVO getAuthorWithBookId(Long bookId) {

        Book book = bookRepository.findByBookId(bookId);
        ResponseTemplateVO vo = new ResponseTemplateVO();

        Author author =
                restTemplate.getForObject("http://AUTHOR-SERVICE/author/" + book.getAuthorId(), Author.class);

        vo.setBook(book);
        vo.setAuthor(author);
        return vo;
    }

    public List<AuthorByBookNameResponse> getAuthorByBookName(String bookName) {
        List<Book> books = bookRepository.findByBookName(bookName);
        List<AuthorByBookNameResponse> authorByBookNameResponseList = new ArrayList<>();
        Iterator books_itr = books.iterator();
        while (books_itr.hasNext()) {

            Book book = (Book) books_itr.next();
//            System.out.println(book.getBookName());
//            System.out.println(book.getBookGenre());
            Author author = restTemplate.getForObject("http://AUTHOR-SERVICE/author/" + book.getAuthorId(), Author.class);
            AuthorByBookNameResponse authorByBookNameResponse = AuthorByBookNameResponse.builder()
                    .authorFirstName(author.getAuthorFirstName())
                    .authorLastName(author.getAuthorLastName())
                    .bookName(book.getBookName())
                    .bookGenre(book.getBookGenre())
                    .build();
            authorByBookNameResponseList.add(authorByBookNameResponse);
        }
        return authorByBookNameResponseList;

    }
    public List<BookDetailsByPartialNameResponse> getBookDetailsByPartialName(String partial_name) {
        List<BookDetailsByPartialNameResponse> bookDetailsByPartialNameResponseList = new ArrayList<>();

        List<Book> books = bookRepository.findBookDetailsByPartialName(partial_name);
        Iterator books_itr = books.iterator();
        while (books_itr.hasNext()) {
            Book book = (Book) books_itr.next();
            Author author = restTemplate.getForObject("http://AUTHOR-SERVICE/author/" + book.getAuthorId(), Author.class);
            BookDetailsByPartialNameResponse bookDetailsByPartialNameResponse = BookDetailsByPartialNameResponse.builder()
                    .authorFirstName(author.getAuthorFirstName())
                    .authorLastName(author.getAuthorLastName())
                    .bookName(book.getBookName())
                    .bookGenre(book.getBookGenre())
                    .build();

            bookDetailsByPartialNameResponseList.add(bookDetailsByPartialNameResponse);
        }
        return bookDetailsByPartialNameResponseList;

    }
}