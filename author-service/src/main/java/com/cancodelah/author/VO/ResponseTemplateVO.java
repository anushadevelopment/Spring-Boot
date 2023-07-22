package com.cancodelah.author.VO;

import com.cancodelah.author.entity.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTemplateVO {
    private List<Book> books;
    private Author author;
    private List<Author> authors;
}
