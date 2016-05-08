/**
 * 
 */
package pl.spring.demo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.spring.demo.common.Sequence;
import pl.spring.demo.dao.AuthorDao;
import pl.spring.demo.to.AuthorTo;

/**
 * @author HSIENKIE
 *
 */

@Component //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
public class AuthorDaoImpl implements AuthorDao {

	
	private Sequence sequence;
	
	/**
	 * 
	 */
	public AuthorDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see pl.spring.demo.dao.AuthorDao#findAll()
	 */
	@Override
	public List<AuthorTo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see pl.spring.demo.dao.AuthorDao#findAuthor(java.lang.String)
	 */
	@Override
	public List<AuthorTo> findAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

    @Autowired
    public void setSequence(Sequence sequence) {
        this.sequence = sequence;
    }
	
	/* (non-Javadoc)
	 * @see pl.spring.demo.dao.AuthorDao#save(pl.spring.demo.to.AuthorTo)
	 */
	@Override
	public AuthorTo save(AuthorTo author) {
		// TODO Auto-generated method stub
		return null;
	}

}
