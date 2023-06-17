package com.example.withoutDatabase.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Book {
    private Integer bookId;
    private String bookName;
    private String bookAuthor;
    private Integer bookPrice;
    private Integer totalNumberOfBook;
}
