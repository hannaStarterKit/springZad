/**
 * 
 */
package pl.spring.demo.service;

import java.util.List;

import pl.spring.demo.to.AuthorTo;

/**
 * @author HSIENKIE
 *
 */
public interface AuthorService {

    List<AuthorTo> findAllAuthors();
    Long findAuthor(String author);

    AuthorTo saveAuthor(AuthorTo author);
}
