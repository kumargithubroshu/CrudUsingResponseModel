package com.example.withoutDatabase.controller;

import com.example.withoutDatabase.model.Book;
import com.example.withoutDatabase.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/get")
    public ResponseEntity<?> getData()
    {
        return new ResponseEntity<>(bookService.getDetails(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createData(@RequestBody Book book)
    {
        return new ResponseEntity<>(bookService.createDetails(book), HttpStatus.OK);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getDataById(@PathVariable Integer id)
    {
        return new ResponseEntity<>(bookService.getDetailsById(id), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id)
    {
        return new ResponseEntity<>(bookService.deleteById(id), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateData(@PathVariable Integer id, @RequestBody Book book)
    {
        return new ResponseEntity<>(bookService.updateDetailsById(id,book),HttpStatus.OK);
    }
}
