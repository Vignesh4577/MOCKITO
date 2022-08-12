package com.bookapp.testcases;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookapp.service.CourseDetails;
@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class CourseTest {

	@Spy
	CourseDetails course;  //create an instance of course
	
	@Mock
	CourseDetails mcourse; //create an proxy of course
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
	}
	
	@Test
	void testShowCourses() {
		
		//the original method is called
		List<String> courses = course.showCourses();
		System.out.println(courses);
	}
	
	@Test
	void testShowCoursesMock() {
		
		//call the proxy method using mock object and return some data
		when(mcourse.showCourses()).thenReturn(Arrays.asList("java"));
		
		//the mock object calls the proxy method.original method is not called
		//use when()thenReturn() to call the proxy method ans return some data
		List<String> courses = mcourse.showCourses();
		System.out.println(courses);
	}
	
	@BeforeEach
	void setUp() throws Exception {
		course = new  CourseDetails();
	}

	@AfterEach
	void tearDown() throws Exception {
		course=null;
	}


}
