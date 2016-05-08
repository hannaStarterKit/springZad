/**
 * 
 */
package pl.spring.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.spring.demo.common.Sequence;
import pl.spring.demo.dao.BookDao;
import pl.spring.demo.to.BookEntity;
import pl.spring.demo.to.BookTo;

/**
 * @author HSIENKIE
 *
 */

@Aspect
@Component
public class AspectSave {

	@Autowired
	Sequence sequence;

	@Before("execution(* pl.spring.demo.dao.impl.BookDaoImpl.save(..))")
	public void saveBafore(JoinPoint joinPoint) {
		Object[] parametry = joinPoint.getArgs();
		BookEntity book = (BookEntity) parametry[0];
		if (book.getId() == null) {
			BookDao bookDao = (BookDao) joinPoint.getThis();
			book.setId(sequence.nextValue(bookDao.findAll()));
		}
	}

}
