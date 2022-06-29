package com.intellier.service;


import org.springframework.http.ResponseEntity;

public interface BookService {
    ResponseEntity<?> getBookById(Long id);
}
