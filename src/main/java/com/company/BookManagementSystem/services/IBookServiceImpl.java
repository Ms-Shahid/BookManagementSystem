package com.company.BookManagementSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.company.BookManagementSystem.entity.Book;
import com.company.BookManagementSystem.repositories.BookRepository;

public abstract class IBookServiceImpl implements IBookService{

	@Autowired
	BookRepository bookRepository;
	
	@Override
	public Book savedBook(Book book) {
		Book savedBook = bookRepository.save(book);
		return savedBook;
	}
	
	@Override 
	public List<Book> getAllBooks(){
		List<Book> books = bookRepository.findAll();
		return books;
	}
	
	
	@Override
	public void deleteBookById(Integer bookId) {
		bookRepository.deleteById(bookId);
	}
	
	@Override
	public Book getBookById(Integer bookId) {
		Optional<Book> opt = bookRepository.findById(bookId);
		Book book = opt.get();
		return book;
	}
	
	@Override
	public Book updateBookById(Integer bookId, Book book) {
		Optional<Book> opt = bookRepository.findById(bookId);
		if(opt.isPresent()) {
			Book book1 = opt.get();
			book1.setBookName(book.getBookName());
			book1.setBookPrice(book.getBookPrice());
			book1.setBookAuthor(book.getBookAuthor());
			return bookRepository.save(book1);
		}else {
			return bookRepository.save(book);
		}
	}
	
	
	public List<Book> getBooksByAuthorName(String bookAuthor){
		return bookRepository.findDistinctByAuthor(bookAuthor);
	}
	
	public List<Book> getBooksByBookName(String bookName){
		return bookRepository.findByBookName(bookName);
	}
}
