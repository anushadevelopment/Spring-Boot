package com.cancodelah.books.vo;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    private long authorId;
    private String authorTitle;
    private String authorFirstName;
    private String authorLastName;
    private String address;
}
