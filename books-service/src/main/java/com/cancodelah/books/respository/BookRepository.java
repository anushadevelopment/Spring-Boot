package com.cancodelah.books.respository;

import com.cancodelah.books.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository <Book, Long>{
    Book findByBookId(Long bookId);

    List<Book> findByAuthorId(Long authorId);

    List<Book> findByBookName(String bookName);

    @Query("select b from Book b where (b.bookName like %:partial_name%)")
    List<Book> findBookDetailsByPartialName(String partial_name);

}

