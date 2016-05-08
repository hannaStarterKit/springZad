package pl.spring.demo.dao.impl;

import pl.spring.demo.annotation.NullableId;
import pl.spring.demo.common.Sequence;
import pl.spring.demo.dao.BookDao;
import pl.spring.demo.to.AuthorTo;
import pl.spring.demo.to.BookEntity;
import pl.spring.demo.to.BookEntity;
import pl.spring.demo.mapper.Mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

public class BookDaoImpl implements BookDao {

	private final Set<BookEntity> ALL_BOOKS = new HashSet<>();

	private Sequence sequence;

	public BookDaoImpl() {
		addTestBooks();
	}

	@Override
	public List<BookEntity> findAll() {
		return new ArrayList<>(ALL_BOOKS);
	}

	@Override
	public List<BookEntity> findBookByTitle(String title) {
		List<BookEntity> listOfFoundBooks = new ArrayList<BookEntity>();
		String searchTitle = changeToLowerCase(title);
		for (BookEntity book : ALL_BOOKS) {
			String existingTitle = changeToLowerCase(book.getTitle());
			if (existingTitle.contains(searchTitle)) {
				listOfFoundBooks.add(book);
			}
		}
		return listOfFoundBooks;
	}

	private String changeToLowerCase(String stringToChange) {
		if (stringToChange != null) {
			return stringToChange.toLowerCase();
		}
		return "";
	}

	@Override
	public List<BookEntity> findBooksByAuthor(String author) {
		List<BookEntity> listOfFoundBooks = new ArrayList<BookEntity>();
		String[] searchNames = changeToLowerCase(author).split(" ");
		for (BookEntity book : ALL_BOOKS) {
			if(checkAuthors(book.getAuthors(), searchNames)){
				listOfFoundBooks.add(book);
			}
		}
		return listOfFoundBooks;
	}

	private boolean checkAuthors(List<AuthorTo> authors, String[] searchNames) {
		boolean authorExists = false;
		for (AuthorTo author : authors) {
			authorExists = checkFirstAndLastName(author, searchNames);
		}
		return authorExists;
	}

	private boolean checkFirstAndLastName(AuthorTo author, String[] searchNames) {
		boolean firstOrLastNameExists = false;
		String existingFirstName = changeToLowerCase(author.getFirstName());
		String existingLastName = changeToLowerCase(author.getLastName());
		for (String name : searchNames) {
			if(existingFirstName.contains(name)){
				firstOrLastNameExists = true;
			}
			if(existingLastName.contains(name)){
				firstOrLastNameExists = true;
			}
		}
		return firstOrLastNameExists;
	}

	@Override
	@NullableId
	public BookEntity save(BookEntity book) { // zad. 2 przeniesc do aspektu
		// if (book.getId() == null) {
		// book.setId(sequence.nextValue(ALL_BOOKS));
		// }
		ALL_BOOKS.add(book);
		return book;
	}

	@Autowired
	public void setSequence(Sequence sequence) {
		this.sequence = sequence;
	}

	private void addTestBooks() {
		ALL_BOOKS.add(new BookEntity(1L, "Romeo i Julia", new AuthorTo(1L, "Wiliam", "Szekspir")));
		ALL_BOOKS.add(new BookEntity(2L, "Opium w rosole", new AuthorTo(2L, "Hanna", "Ożogowska")));
		ALL_BOOKS.add(new BookEntity(3L, "Przygody Odyseusza", new AuthorTo(3L, "Jan", "Parandowski")));
		ALL_BOOKS.add(new BookEntity(4L, "Awantura w Niekłaju", new AuthorTo(4L, "Edmund", "Niziurski")));
		ALL_BOOKS.add(new BookEntity(5L, "Pan Samochodzik i Fantomas", new AuthorTo(5L, "Zbigniew", "Nienacki")));
		ALL_BOOKS.add(new BookEntity(6L, "Zemsta", new AuthorTo(6L, "Aleksander", "Fredro")));
	}
}
