package pl.spring.demo.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import pl.spring.demo.to.AuthorTo;
import pl.spring.demo.to.BookEntity;
import pl.spring.demo.to.BookTo;

//@Component
public class Mapper {

	public static BookTo bookEntity2BookTo(BookEntity bookEntity) {
		if (bookEntity != null) {
			String authors = authorTo2AuthorString(bookEntity.getAuthors());
			Long id = bookEntity.getId();
			String title = bookEntity.getTitle();
			return new BookTo(id, title, authors);
		}
		return null;
	}

	private static String authorTo2AuthorString(List<AuthorTo> authors) {
		if (authors != null) {
			return authors.stream().map(authorTo -> appendFirstAndLastName(authorTo)).collect(Collectors.joining(", "));
		}
		return null;
	}

	private static String appendFirstAndLastName(AuthorTo authorTo) {
		String result = authorTo.getFirstName();
		String lastName = authorTo.getLastName();
		if (!lastName.isEmpty()) {
			return result + " " + lastName;
		}
		return result;
	}

	public static BookEntity bookTo2BookEntity(BookTo bookTo) {
		if (bookTo != null) {
			List<AuthorTo> authors = authorString2AuthorTo(bookTo.getAuthors());
			Long id = bookTo.getId();
			String title = bookTo.getTitle();
			return new BookEntity(id, title, authors);
		}
		return null;
	}

	public static List<BookTo> entity2To(List<BookEntity> listEntity) {
		if (listEntity != null) {
			List<BookTo> listTo = new ArrayList<BookTo>();
			for (BookEntity bookEntity : listEntity) {
				listTo.add(bookEntity2BookTo(bookEntity));
			}
			return listTo;
		}
		return null;
	}

	public static List<BookEntity> to2Entity(List<BookTo> listTo) {
		if (listTo != null) {
			List<BookEntity> listEntity = new ArrayList<BookEntity>();
			for (BookTo bookTo : listTo) {
				listEntity.add(bookTo2BookEntity(bookTo));
			}
			return listEntity;
		}
		return null;
	}

	public static List<AuthorTo> authorString2AuthorTo(String author) {
		if (author != null) {
			List<AuthorTo> listAuthorTo = new ArrayList<AuthorTo>();
			String[] authors = author.split(",");
			for (int i = 0; i < authors.length; i++) {
				String[] names = authors[i].split(" ");
				AuthorTo authorTo = new AuthorTo(null, null, "");
				if (names.length > 1) {
					authorTo.setLastName(names[names.length - 1]);
				}
				authorTo.setFirstName(names[0]);
				listAuthorTo.add(authorTo);
			}
			return listAuthorTo;
		}
		return null;
	}
}
