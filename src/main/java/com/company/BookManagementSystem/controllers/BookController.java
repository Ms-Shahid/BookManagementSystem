package com.company.BookManagementSystem.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.BookManagementSystem.entity.Book;
import com.company.BookManagementSystem.services.IBookService;


@RestController
@RequestMapping(value="/book")
public class BookController {

	@Autowired
	private IBookService bookService;
	
	@PostMapping(value="/book/save")
	public ResponseEntity<Book> savedBook(@Valid @RequestBody Book book){
		Book saveBook = bookService.savedBook(book);
		return new ResponseEntity<Book>(book,HttpStatus.CREATED);
	}
	
	@GetMapping(value="/allBooks")
	public ResponseEntity<List<Book>> getAllBooks(){
		List<Book> allBooks = bookService.getAllBooks();
		return new ResponseEntity<List<Book>>(allBooks,HttpStatus.OK);
	}
	
	@GetMapping(value = "/{bookId}")
	public ResponseEntity<Book> getBookById(@PathVariable Integer bookId){
		Book book = bookService.getBookById(bookId);
		return new ResponseEntity<Book>(book,HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{bookId}")
	public ResponseEntity<String> deleteBookById(@PathVariable Integer bookId){
		bookService.deleteBookById(bookId);
		String msg = "product with " +bookId + "deleted successfully";
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@PutMapping(value = "/{bookId}")
	public ResponseEntity<Book> updateBookById(@PathVariable Integer bookId, Book book){
		Book updatedBook = bookService.updateBookById(bookId, book);
		return new ResponseEntity<Book>(updatedBook,HttpStatus.CREATED);
	}
	
	@GetMapping(value="/{bookauthor}")
	public ResponseEntity<List<Book>> getByAuthor(@PathVariable String bookAuthor){
		List<Book> allBooks = bookService.getBooksByAuthor(bookAuthor);
		return new ResponseEntity<List<Book>>(allBooks,HttpStatus.OK);
	}
	
	@GetMapping(value="/{bookName}")
	public ResponseEntity<List<Book>> getByBookName(@PathVariable String bookName){
		List<Book> allBooks = bookService.getBooksByName(bookName);
		return new ResponseEntity<List<Book>>(allBooks,HttpStatus.OK);
	}
	
	
}
