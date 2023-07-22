package com.cancodelah.author.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name="author")
@Builder
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long authorId;
    private String authorTitle;
    private String authorFirstName;
    private String authorLastName;
    private String address;
}
