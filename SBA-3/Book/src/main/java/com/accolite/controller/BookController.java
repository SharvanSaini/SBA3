package com.accolite.controller;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Validator;
import com.accolite.exception.ValidationException;
import com.accolite.model.Book;
import com.accolite.repo.BookRepository;

@RestController

public class BookController {
	
	private static final Logger log = LoggerFactory.getLogger(BookController.class);
	@Autowired
	private BookRepository bookRepo;
	
	@Autowired
	private Validator getvalidator;
	
	
	
	@GetMapping("bookService/getBookCost/bookname/{bookname}")
	public ResponseEntity<Book> getBookByName(@PathVariable String bookname) {
		if(bookname.isEmpty()) {
			log.error(bookname+" book name is empty, pass the book name");
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}
		Book book=bookRepo.findByBookName(bookname);
		log.info(book.toString()+" found with details");
		return new ResponseEntity<Book>(book,HttpStatus.OK);
	}
	


}
