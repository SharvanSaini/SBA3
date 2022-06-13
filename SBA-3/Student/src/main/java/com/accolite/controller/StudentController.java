package com.accolite.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.Proxy.BookProxy;
import com.accolite.model.BookDTO;

@RestController
@RequestMapping("/studentService")
public class StudentController {

	@Autowired
	private BookProxy proxy;

	private static final Logger log = LoggerFactory.getLogger(StudentController.class);

	@GetMapping("/findCost/bookname/{bookname}/quantity/{quantity}")
	public ResponseEntity<BookDTO> findCostByBookDetails(@PathVariable String bookname,
			@PathVariable Integer quantity) {
 
		String d=proxy.getBookByName(bookname).getBookName();
		if (bookname.isEmpty() ) {
			
			log.error(bookname + " book name is empty, pass the book name");
			return new ResponseEntity("book name is empty",HttpStatus.NOT_FOUND);
		}
		if (d == null) {
            log.info("Book with name " + bookname + " is not found");
            return new ResponseEntity(
                    "No Book is present with name -" + bookname + ". Please enter the correct name and try again!",
                    HttpStatus.NOT_FOUND);
        }
		BookDTO book = proxy.getBookByName(bookname);

		BookDTO b = new BookDTO(book.getBookId(), book.getBookName(), book.getBookCost(), quantity,
				(book.getBookCost() * quantity));

		log.info(b.toString() + " found with details");

		return new ResponseEntity<BookDTO>(b, HttpStatus.FOUND);

	}
}
