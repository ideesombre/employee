package tp.xml;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import tp.xml.services.AuthenticationService;
import tp.xml.services.AuthenticationServiceImpl;
import tp.xml.dummy.Dummy;
import tp.xml.dummy.DummyAlreadyExistsException;
import tp.xml.dummy.DummyService;

public class Main {

	public static void main(String[] args) throws DummyAlreadyExistsException{
		/*
		 * // avec XML, sans annotations
		 * System.out.println("------------- Avec XML sans annotations ---------------"
		 * );
		 * 
		 * // container contextXML AbstractApplicationContext contextXML = new
		 * ClassPathXmlApplicationContext("applicationContext.xml");
		 * 
		 * AuthenticationService asXML = (AuthenticationServiceImpl)
		 * contextXML.getBean("asimpl"); System.out.println(asXML.authenticate("admin",
		 * "toto")); System.out.println(asXML.authenticate("admin1", "michel"));
		 * System.out.println("AUTHENTIFICATION : " + asXML.authenticate("papa",
		 * "toto"));
		 * 
		 * // avec annotations
		 * System.out.println("\n--------------- Avec annotations -------------------");
		 * 
		 * AbstractApplicationContext context = new
		 * AnnotationConfigApplicationContext(App.class);
		 * 
		 * AuthenticationService as = context.getBean(AuthenticationServiceImpl.class);
		 * System.out.println(as.authenticate("admin", "toto"));
		 * System.out.println(as.authenticate("admin1", "michel"));
		 * System.out.println("AUTHENTIFICATION : " + as.authenticate("papa", "toto"));
		 * 
		 */

		System.out.println("\n--------------- Aspect AOP -------------------");

		AbstractApplicationContext contextAOP = new AnnotationConfigApplicationContext(App.class);
		DummyService service = contextAOP.getBean(DummyService.class);

		System.out.println("\n" + service.getDummies().toString());
		
		System.out.println("\n** get*() **");

		service.getDummies();

		System.out.println("\n** delete*(7L) **");
		try {
			service.deleteDummy(7L);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		System.out.println("\n** save*(null) **");
		try {
			service.saveDummy(null);
		} catch (Exception e1) {
			System.out.println("Exception thrown in main");
			;
		}

		System.out.println("\n** save*(new dummy) **");
		try {
			Dummy dummy = new Dummy(20L, "n°" + 20);
			service.saveDummy(dummy);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		System.out.println("\n** save*(dummy already exist) **");
		try {
			service.saveDummy(new Dummy(2L, "n°" + 2));
		} catch (Exception e1) {
			//e1.printStackTrace();
		}

		System.out.println("\n" + service.getDummies().toString());
		JdbcTemplate.class 
	}

}
