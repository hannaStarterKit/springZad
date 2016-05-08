package pl.spring.demo.configuration;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pl.spring.demo.common.Sequence;
import pl.spring.demo.dao.impl.BookDaoImpl;

@Configuration
public class ConfigurationContext {

/*	@Bean
	public ProxyFactoryBean proxy(Sequence sequence){
		ProxyFactoryBean factory = new ProxyFactoryBean();
		BookDaoImpl gh=new BookDaoImpl();
		gh.setSequence(sequence);
		factory.setTarget(gh);
		factory.setInterceptorNames("bookDaoAdvisor");
		return factory;
	}*/

}
