/**
 * 
 */
package pl.spring.demo.dao;

import java.util.List;

import pl.spring.demo.to.AuthorTo;


/**
 * @author HSIENKIE
 *
 */
public interface AuthorDao {

    List<AuthorTo> findAll();

    List<AuthorTo> findAuthor(String author);

    AuthorTo save(AuthorTo author);
	
}
