package com.intellier.service.impl;

import com.intellier.dto.BookCommentDto;
import com.intellier.exception.ResourceNotFoundException;
import com.intellier.model.Book;
import com.intellier.respository.BookRepository;
import com.intellier.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {


    @Autowired
    private BookRepository bookRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public BookServiceImpl( ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseEntity<?> getBookById(Long id) {
        // model mapper by Book to bookCommentDto
        Optional<Book> book = bookRepository.findById(id);
        // mapping book to bookCommentDto
        if(book.isPresent()){
            BookCommentDto bookCommentDto = modelMapper.map(book.get(), BookCommentDto.class);
            return ResponseEntity.ok(bookCommentDto);
        }else{
            return ResponseEntity.ok("Book not found");
        }


    }
}
