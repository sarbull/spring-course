package ro.memiq.training;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import ro.memiq.training.bean.Person;
import ro.memiq.training.dao.DAO;
import ro.memiq.training.service.PersonService;

@Component
public class MainApp {

	public static void main(String[] args) {

		System.out.println("start app!");

		ApplicationContext context = new AnnotationConfigApplicationContext(ro.memiq.training.ComponentConfig.class);

		 test1(context);

//		test2(context);

	}

	@SuppressWarnings("unchecked")
	private static void test1(ApplicationContext context) {
		DAO<Person> dao = (DAO<Person>) context.getBean("collection");
		 DAO<Person> dao1 = (DAO<Person>) context.getBean("map");
		// DAO<Person> dao = context.getBean(DAO.class);

		dao.create(new Person("ionel1", "ionut1@email.com", "0723 123 456", "Google SRL"));
		dao.create(new Person("ionel2", "ionut2@email.com", "0723 123 456", "Google SRL"));
		dao.create(new Person("ionel3", "ionut3@email.com", "0723 123 456", "Google SRL"));
		

		dao1.create(new Person("ionel4", "ionut4@email.com", "0723 123 456", "Google 4 SRL"));

		System.out.println(Arrays.asList(dao.getAll()));
		

		System.out.println(Arrays.asList(dao1.getAll()));
	}

	@SuppressWarnings("unchecked")
	private static void test2(ApplicationContext context) {
		PersonService service = context.getBean(PersonService.class);

		service.createPersons(20);
		service.printAll();
	}
}
