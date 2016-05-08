/**
 * 
 */
package pl.spring.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.spring.demo.dao.AuthorDao;
import pl.spring.demo.service.AuthorService;
import pl.spring.demo.to.AuthorTo;

/**
 * @author HSIENKIE
 *
 */
@Service
public class AuthorServiceImpl implements AuthorService {

	private AuthorDao authorDao;

	/**
	 * 
	 */

	/* (non-Javadoc)
	 * @see pl.spring.demo.service.AuthorService#findAllAuthors()
	 */
	@Override
	public List<AuthorTo> findAllAuthors() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see pl.spring.demo.service.AuthorService#findAuthor(java.lang.String)
	 */
	@Override
	public Long findAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see pl.spring.demo.service.AuthorService#saveAuthor(pl.spring.demo.to.AuthorTo)
	 */
	@Override
	public AuthorTo saveAuthor(AuthorTo author) {
		// TODO Auto-generated method stub
		return null;
	}
	
    @Autowired
    public void setAuthorDao(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

}
