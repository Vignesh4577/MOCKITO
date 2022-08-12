package com.bookapp.testcases;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.IBookService;
import com.bookapp.service.OrderDetails;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)

class OrderTest {

	@Mock
	IBookService bookService;
	
	@InjectMocks
	OrderDetails details;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	Book book1;
	Book book2;
	Book book3;
	Book book4;
	List<Book> booksList;
	@BeforeEach
	void setUp() throws Exception {
		book1 = new Book(1,"java","kathy",800);
		book2 = new Book(2,"Secret","Rhonde",800);
		book3 = new Book(3,"Spring","kathy",800);
		book4 = new Book(4,"Leadership","Rhonde",800);
		booksList = Arrays.asList(book1,book2,book3,book4);
	}
	@Test@DisplayName("Testing Book - returns one book instance")
	void testBookById() throws BookNotFoundException {
		
		doReturn(book1).when(bookService).getById(1);
		String actual = details.orderBook(1);
		assertEquals("Book Ordered", actual);
		
	}
	@Test@DisplayName("Testing Book - returns null")
	void testBookByIdNull() throws BookNotFoundException {
		
		doReturn(null).when(bookService).getById(10);
		String actual = details.orderBook(10);
		assertEquals("out of stock", actual);
		
	}
	@Test@DisplayName("Testing Book - throws exception")
	void testBookByIdException() throws BookNotFoundException {
		
	doReturn(new BookNotFoundException("Invalid Id")).when(bookService).getById(20);
	
		String actual = details.orderBook(20);
		assertEquals("Technical issues", actual);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		booksList=null;
		book1=null;
	}

	

	@Test@DisplayName("Testing add Book  -Null ")
	void testAddBookNull() throws BookNotFoundException {
		
	 
		String actual = details.addBook(null);
		assertEquals("book not added", actual);
		
	}
	@Test@DisplayName("Testing add Book ")
	void testAddBook() throws BookNotFoundException {
		
	    doNothing().when(bookService).addBook(book1);
	
		String actual = details.addBook(book1);
		assertEquals("book added", actual);
		
	}
	

}
