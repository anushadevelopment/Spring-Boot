package com.cancodelah.books.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {
    private String bookName;
    private String bookGenre;
    private String authorFirstName;
    private String authorLastName;
}
