package com.example.withoutDatabase.service.Impl;

import com.example.withoutDatabase.model.Book;
import com.example.withoutDatabase.responseModel.ResponseModel;
import com.example.withoutDatabase.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    List<Book> lst=new ArrayList<>();
    @Override
    public ResponseModel<List<Book>> getDetails() {
        if(lst.isEmpty())
        {
            return new ResponseModel<>(HttpStatus.NO_CONTENT.value(), "data not present", null);
        }
        else {
            return new ResponseModel<>(HttpStatus.OK.value(), "success", lst);
        }
    }

    @Override
    public ResponseModel<Book> createDetails(Book book) {
        if(book.getBookId() == null ||  book.getBookId().toString().isEmpty())
        {
            return new ResponseModel<Book>(HttpStatus.NO_CONTENT.value(), "Data not present",null);
        }
        book.setBookId(book.getBookId());
        lst.add(book);
        return new ResponseModel<Book>(HttpStatus.CREATED.value(),"created",book);
    }

    @Override
    public ResponseModel<Book> getDetailsById(Integer id) {
        if(id == null ||  id.toString().isEmpty())
        {
            return new ResponseModel<>(HttpStatus.NO_CONTENT.value(), "Id not present",null);
        }
        else {
            Book book = lst.get(id);
            if (book == null) {
                return new ResponseModel<>(HttpStatus.NOT_FOUND.value(), "Book not found", null);
            } else {
                return new ResponseModel<Book>(HttpStatus.OK.value(), "Book details", book);
            }
        }
    }

    @Override
    public ResponseModel deleteById(Integer id) {
        if(id == null ||  id.toString().isEmpty())
        {
            return new ResponseModel<>(HttpStatus.NO_CONTENT.value(), "Id not present",null);
        }
        else {
            Book book = lst.get(id);
            lst.remove(book);
                return new ResponseModel<>(HttpStatus.GONE.value(), "Data deleted successfully with id : " +id ,book);
        }
    }

    @Override
    public ResponseModel updateDetailsById(Integer id, Book book) {
        Book book1 = lst.get(id);
        if(book1 != null)
        {
            book1.setBookName(book.getBookName());
            book1.setBookAuthor(book.getBookAuthor());
            book1.setBookPrice(book.getBookPrice());
            book1.setTotalNumberOfBook(book.getTotalNumberOfBook());
            return new ResponseModel(HttpStatus.ACCEPTED.value(), "your data has been updated", book1);
        }
        else
        {
            return new ResponseModel(HttpStatus.NOT_MODIFIED.value(), "you data id not present with id : "+id, null);
        }
    }


}
