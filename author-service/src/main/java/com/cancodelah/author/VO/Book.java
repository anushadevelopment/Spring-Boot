package com.cancodelah.author.VO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data

public class Book {
    private long bookId;
    private String bookName;
    private String bookGenre;
    private Long authorId;
}