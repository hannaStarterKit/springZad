package pl.spring.demo.mock;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.dao.BookDao;
import pl.spring.demo.mapper.Mapper;
import pl.spring.demo.service.BookService;
import pl.spring.demo.service.impl.BookServiceImpl;
import pl.spring.demo.to.AuthorTo;
import pl.spring.demo.to.BookEntity;
import pl.spring.demo.to.BookTo;

import static org.junit.Assert.assertEquals;


public class BookServiceImplTest {

	@InjectMocks
	private BookServiceImpl bookService;
	@Mock
	private BookDao bookDao;

	@Before
	public void setUp() {
	MockitoAnnotations.initMocks(this);
	}


	@Test
	public void testShouldSaveBook() {
		// given
		BookTo bookTo = new BookTo(null, "title", "author");
		BookEntity bookEntityToSave = new BookEntity(null, "title", new AuthorTo(null, "author", ""));
		Mockito.when(bookDao.save(Mockito.any(BookEntity.class))).thenReturn(new BookEntity(1L, "title", new AuthorTo(null, "author", "")));
		// when
		BookTo result = bookService.saveBook(bookTo);
		// then
		Mockito.verify(bookDao).save(Mockito.eq(bookEntityToSave));
		assertEquals(1L, result.getId().longValue());
	}
}
