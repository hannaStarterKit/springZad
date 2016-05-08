package pl.spring.demo.to;

import java.util.ArrayList;
import java.util.List;

public class BookEntity implements IdAware {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authors == null) ? 0 : authors.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookEntity other = (BookEntity) obj;
		if (authors == null) {
			if (other.authors != null)
				return false;
		} else if (!authors.equals(other.authors))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	private Long id;
	private String title;
	private List<AuthorTo> authors;

	public BookEntity() {
	}

	public BookEntity(Long id, String title, AuthorTo authorTo) {
		this.id = id;
		this.title = title;
		authors = new ArrayList<AuthorTo>();
		addAuthor(authorTo);
	}
	
	public BookEntity(Long id, String title, List<AuthorTo> authorsTo) {
		this.id = id;
		this.title = title;
		authors = new ArrayList<AuthorTo>();
		setAuthors(authorsTo);;
	}

	public void setAuthors(List<AuthorTo> authors) {
		this.authors = authors;
	}

	private void addAuthor(AuthorTo authorTo) {
		authors.add(authorTo);
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	 public List<AuthorTo> getAuthors() {
		 return authors;
	 }
	//
	// public void setAuthors(String authors) {
	// this.authors = authors;
	// }
}
