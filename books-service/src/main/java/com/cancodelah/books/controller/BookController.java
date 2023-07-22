package com.cancodelah.books.controller;

import com.cancodelah.books.entity.Book;
import com.cancodelah.books.service.BookService;
import com.cancodelah.books.vo.AuthorByBookNameResponse;
import com.cancodelah.books.vo.BookDetailsByPartialNameResponse;
import com.cancodelah.books.vo.ResponseTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/")
    public Book saveBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }


    @GetMapping("/{book_id}")
    public Book findBookById(@PathVariable("book_id") Long bookId){
        return bookService.findBookById(bookId);
    }
    @GetMapping("/author/{authorId}")
    public List<Book> findBookByAuthorId(@PathVariable("authorId") Long authorId) {
        return bookService.findBookByAuthorId(authorId);
    }

    @GetMapping("/bookandauthor/{bookId}")
    public ResponseTemplateVO getAuthorWithBookId(@PathVariable("bookId") Long bookId){
        return bookService.getAuthorWithBookId(bookId);
    }

    @GetMapping("/bookandauthorbybookname/{book_name}")
    public List<AuthorByBookNameResponse> authorByBookNameResponse(@PathVariable("book_name") String book_name){
        return bookService.getAuthorByBookName(book_name);
    }
    @GetMapping("/bookdetailsbypartialname/{partial_name}")
    public List<BookDetailsByPartialNameResponse> bookDetailsByPartialNameResponses(@PathVariable("partial_name") String partial_name){
        return bookService.getBookDetailsByPartialName(partial_name);
    }



}
