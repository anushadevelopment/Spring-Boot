package com.cancodelah.books.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDetailsByPartialNameResponse {
    private String authorFirstName;
    private String authorLastName;
    private String bookName;
    private String bookGenre;
    }

