package com.bookapp.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;

public class OrderDetails {

	IBookService bookService;
	
	public void setBookService(IBookService bookService) {
		this.bookService=bookService;
		
	}
	
	public String showMessage(String name) {
		
		
		String result = bookService.greetMessage();//"welcome priya"
		if(name.startsWith("p")) {
			return result.concat(" ").concat(name);
		}
		return "Wrong username";
	}
	
	public List<Book> findByAuthor(String author) throws BookNotFoundException{
		
		List<Book> book = bookService.getAll();
		if(book==null)
			return null;
		if(book.isEmpty())
			throw new BookNotFoundException(); 
		return book.stream()
				   .filter(books->books.getAuthor().equals(author))
				   .sorted((b1,b2)->b1.getTitle().compareTo(b2.getTitle()))
				   .limit(2)
				   .collect(Collectors.toList());
	}
	
	public String orderBook(int bookId) {
	 try {
		Book book = bookService.getById(bookId);
		if(book==null)
			return "out of stock";
		return "Book Ordered";
		 
	} catch (Exception e) {
		e.printStackTrace();
	}
	return "Technical Issues";
	}
	
	public String addBook(Book book) {
		
		if(book==null)
			return "book not added";
		bookService.addBook(book);
		return "book added";
		
	}
}
