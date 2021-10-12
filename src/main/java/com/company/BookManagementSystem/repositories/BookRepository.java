package com.company.BookManagementSystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.BookManagementSystem.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

	public List<Book> findDistinctByAuthor(String bookAuthor);
	public List<Book> findByBookName(String bookName);
}
