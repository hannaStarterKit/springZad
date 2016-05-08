package pl.spring.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import pl.spring.demo.dao.BookDao;
import pl.spring.demo.mapper.Mapper;
import pl.spring.demo.service.BookService;
import pl.spring.demo.to.BookEntity;
import pl.spring.demo.to.BookTo;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

	private BookDao bookDao;

	//private Mapper mapper;

	@Override
	@Cacheable("booksCache")
	public List<BookTo> findAllBooks() {
		return Mapper.entity2To(bookDao.findAll());
	}

	@Override
	public List<BookTo> findBooksByTitle(String title) {
		if(title.isEmpty()){
			throw new IllegalArgumentException("Field - title is empty or is null");
		}
		return Mapper.entity2To(bookDao.findBookByTitle(title));
	}

	@Override
	public List<BookTo> findBooksByAuthor(String author) {
		if(author.isEmpty()){
			throw new IllegalArgumentException("Field - author is empty or is null");			
		}
		return Mapper.entity2To(bookDao.findBooksByAuthor(author));
	}

	@Override
	public BookTo saveBook(BookTo book) {
		BookEntity bookEntity = Mapper.bookTo2BookEntity(book);
		BookEntity savedBookEntity = bookDao.save(bookEntity);
		BookTo savedBookTo = Mapper.bookEntity2BookTo(savedBookEntity);
		return savedBookTo;
	}

	@Autowired
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

//	@Autowired
//	public void setMapper(Mapper mapper) {
//		this.mapper = mapper;
//	}
}
