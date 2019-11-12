package tp.xml;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tp.xml.services.AuthenticationService;
import tp.xml.services.AuthenticationServiceImpl;

public class Main {

	public static void main(String[] args) {
		// avec XML, sans annotations
		System.out.println("------------- Avec XML sans annotations ---------------");
		
		//container contextXML
		AbstractApplicationContext contextXML = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		AuthenticationService asXML = (AuthenticationServiceImpl) contextXML.getBean("asimpl");
		System.out.println(asXML.authenticate("admin", "toto"));
		System.out.println(asXML.authenticate("admin1", "michel"));
		System.out.println("AUTHENTIFICATION : "+asXML.authenticate("papa", "toto"));
		
		// avec annotations
		System.out.println("--------------- Avec annotations -------------------");

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class);
		
		AuthenticationService as = context.getBean(AuthenticationServiceImpl.class);
		System.out.println(as.authenticate("admin", "toto"));
		System.out.println(as.authenticate("admin1", "michel"));
		System.out.println("AUTHENTIFICATION : "+as.authenticate("papa", "toto"));
		

	}

}
