package com.intellier.controller;

import com.intellier.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin("*")
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //get book by id
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> getBookById(@PathVariable("id") Long id, HttpServletResponse httpServletResponse) {
       return  bookService.getBookById(id);
    }

}
