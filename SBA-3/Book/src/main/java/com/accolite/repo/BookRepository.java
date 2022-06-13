package com.accolite.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accolite.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
	
	public Book findByBookName(String bookName);

}
