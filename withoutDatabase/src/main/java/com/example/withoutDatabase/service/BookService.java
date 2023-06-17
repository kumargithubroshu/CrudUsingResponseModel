package com.example.withoutDatabase.service;

import com.example.withoutDatabase.model.Book;
import com.example.withoutDatabase.responseModel.ResponseModel;

import java.util.List;

public interface BookService {

    public ResponseModel<List<Book>> getDetails();

    public ResponseModel<Book> createDetails(Book book);

    public ResponseModel<Book> getDetailsById(Integer id);

    public ResponseModel deleteById(Integer id);

    public ResponseModel updateDetailsById(Integer id, Book book);
}
