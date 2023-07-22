package com.cancodelah.books.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorByBookNameResponse {
    private String authorFirstName;
    private String authorLastName;
    private String bookName;
    private String bookGenre;
}
