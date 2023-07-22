package com.cancodelah.author.VO;

import java.util.ArrayList;
import java.util.List;

public class BookList {
    private List<Book> books;
    public BookList(){
        books = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> _books) {
        books=_books;
    }
}
