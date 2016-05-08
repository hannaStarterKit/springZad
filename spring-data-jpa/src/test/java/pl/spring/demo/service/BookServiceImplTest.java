package pl.spring.demo.service;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.spring.demo.exception.BookNotNullIdException;
import pl.spring.demo.to.BookTo;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonServiceTest-context.xml")
public class BookServiceImplTest {

	@Autowired
	private BookService bookService;
	@Autowired
	private CacheManager cacheManager;

	@Before
	public void setUp() {
		cacheManager.getCache("booksCache").clear();
	}

	@Test
	public void testShouldFindAllBooks() {
		// when
		List<BookTo> allBooks = bookService.findAllBooks();
		// then
		assertNotNull(allBooks);
		assertFalse(allBooks.isEmpty());
		assertEquals(7, allBooks.size());
	}

	@Test
	public void testShouldFindAllBooksByTitle() {
		// given
		final String title = "i Julia";
		// when
		List<BookTo> booksByTitle = bookService.findBooksByTitle(title);
		// then
		assertNotNull(booksByTitle);
		assertFalse(booksByTitle.isEmpty());
		assertEquals("Romeo i Julia", booksByTitle.get(0).getTitle());
	}

	@Test
	public void testShouldFindAllBooksByAuthor() {
		// given
		final String author = "hanna";
		// when
		List<BookTo> booksByAuthor = bookService.findBooksByAuthor(author);
		// then
		assertNotNull(booksByAuthor);
		assertFalse(booksByAuthor.isEmpty());
		assertEquals("Hanna Ożogowska", booksByAuthor.get(0).getAuthors());
	}
	
	@Test//(expected = IllegalArgumentException.class)
	public void testShouldThrowIllegalArgumentExceptionForTitle() {
		// given
		final String title = "";
		List<BookTo> booksByTitle = new ArrayList<BookTo>();
		try {
			// when
			booksByTitle = bookService.findBooksByTitle(title);
		} catch (IllegalArgumentException e) {
			// then
			assertTrue(booksByTitle.isEmpty());
		}
	}
	
	@Test//(expected = IllegalArgumentException.class)
	public void testShouldThrowIllegalArgumentExceptionForAuthor() {
		// given
		final String author = "";
		List<BookTo> booksByAuthor = new ArrayList<BookTo>();
		try {
			// when
			booksByAuthor = bookService.findBooksByTitle(author);
		} catch (IllegalArgumentException e) {
			// then
			assertTrue(booksByAuthor.isEmpty());
		}
	}

	@Test(expected = BookNotNullIdException.class)
	public void testShouldThrowBookNotNullIdException() {
		// given
		final BookTo bookToSave = new BookTo(null, "title", "author");
		// when
		bookService.saveBook(bookToSave);
		// then
		fail("test should throw BookNotNullIdException");
	}
}
