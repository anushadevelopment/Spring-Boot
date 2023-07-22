package com.cancodelah.books.vo;

import com.cancodelah.books.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {

private Author author;
private Book book;
}
