package com.bookapp.testcases;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
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
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.IBookService;
import com.bookapp.service.OrderDetails;


@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class OrderDetailsTest {

	@Mock //create  proxy
	IBookService bookService; //mock IBookService
	
	@InjectMocks
	OrderDetails details;
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
        
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	void testShowMessage() {
		
		//using the mock object call the method of bookservice
		Mockito.when(bookService.greetMessage()).thenReturn("Great Day");
		
		//this is the method to be tested
		String actual = details.showMessage("priya");  //....called First
		assertEquals("Great Day priya", actual);
		
		String nactual = details.showMessage("prachi");  //....called First
		assertEquals("Great Day prachi", nactual);
	}
	@Test
	void testAnShowMessage() {
		
		//using the mock object call the method of bookservice
		Mockito.when(bookService.greetMessage()).thenReturn("Great Day");
		
		//this is the method to be tested
		String actual = details.showMessage("Raj");  //....called First
		assertEquals("Wrong username", actual);
		
		String nactual = details.showMessage("Halen");  //....called First
		assertEquals("Wrong username", nactual);
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
	@Test
	void testGetByAuthor() throws BookNotFoundException{
		
		String author = "Rhonde";
		Mockito.when(bookService.getAll()).thenReturn(booksList);
		List<Book> actualBooks = details.findByAuthor(author);
		List<Book> exceptedBooks = Arrays.asList(book4,book2);
		assertEquals(exceptedBooks, actualBooks);
		
	}
	@Test @DisplayName("Testing by author - throw exception")
	void testGetByAuthorException() throws BookNotFoundException {
		
		String author= "priya";
		Mockito.when(bookService.getAll()).thenThrow(new BookNotFoundException());
		assertThrows(BookNotFoundException.class,()->{
			details.findByAuthor(author);
		});
		
	}
	@Test @DisplayName("Testing by author - empty list")
	void testGetByAuthorEmpty() throws BookNotFoundException {
		
		String author= "priya";
		List<Book> emptylist = new ArrayList<Book>();
		Mockito.when(bookService.getAll()).thenReturn(emptylist);
		assertThrows(BookNotFoundException.class,()->{
			details.findByAuthor(author);
		});
		
	}
	@Test @DisplayName("Testing by author - null")
	void testAnShowException() throws BookNotFoundException {
		
		String author= "priya";
		Mockito.when(bookService.getAll()).thenReturn(null);
		List<Book> actualbooks = details.findByAuthor(author);
		assertNull(actualbooks);
		
		
	}
	
	@AfterEach
	void tearDown() throws Exception {
		booksList = null;
	}

	
}
