package com.company.BookManagementSystem.services;

import java.util.List;

import com.company.BookManagementSystem.entity.Book;

public interface IBookService {

	Book savedBook(Book book);

	List<Book> getAllBooks();

	void deleteBookById(Integer bookId);

	Book getBookById(Integer bookId);

	Book updateBookById(Integer bookId, Book book);

	Book getBookByAuthor(String bookAuthor);

	Book getBookByName(String bookName);

	public List<Book> getBooksByAuthor(String bookAuthor);

	public List<Book> getBooksByName(String bookName);
}
