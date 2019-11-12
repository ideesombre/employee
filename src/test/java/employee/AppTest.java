package employee;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import tp.xml.App;

public class AppTest {

	@Test
	public void test() {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class);
	}

}
