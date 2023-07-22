package com.cancodelah.author.controller;

import com.cancodelah.author.VO.BooksByAuthorNameResponse;
import com.cancodelah.author.VO.ResponseTemplateVO;
import com.cancodelah.author.entity.Author;
import com.cancodelah.author.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Dictionary;
import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/")
    public Author saveAuthor(@RequestBody Author author){
        return authorService.saveAuthor(author);
    }

    @GetMapping("/{authorId}")
    public Author findAuthorById(@PathVariable("authorId") Long authorId){
        return authorService.findAuthorById(authorId);
    }

    @GetMapping("/authorandbooks/{authorId}")
    public ResponseTemplateVO getBooksWithAuthorId(@PathVariable("authorId") Long authorId){
        return authorService.getBooksWithAuthorId(authorId);

    }
    @GetMapping("/booksbyauthorfirstname/{authorFirstName}")
    public List<BooksByAuthorNameResponse> getBooksByAuthorFirstName(@PathVariable("authorFirstName") String authorFirstName){
        return authorService.getBooksByAuthorFirstName(authorFirstName);
    }

    @GetMapping("booksbyauthorfirstnameorlastname/{name}")
    public List<BooksByAuthorNameResponse> getBooksByAuthorFirstnameOrLastname(@PathVariable("name")String name){
        return authorService.getBooksByAuthorFirstnameOrLastname(name);
    }





}
