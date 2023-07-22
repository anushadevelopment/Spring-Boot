package com.cancodelah.author.VO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BooksByAuthorNameResponse {
    private String authorFirstName;
    private String authorLastName;
    private List<BookResponse> bookResponseList;

}
