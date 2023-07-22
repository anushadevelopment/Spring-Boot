package com.cancodelah.books.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookId;
    private String bookName;
    private String bookGenre;
    private Long authorId;
}
