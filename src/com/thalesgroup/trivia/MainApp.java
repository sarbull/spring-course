package com.thalesgroup.trivia;

import java.io.IOException;
//import java.util.Arrays;

import org.json.JSONException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

//import com.thalesgroup.trivia.bean.Question;
//import com.thalesgroup.trivia.dao.DAO;
import com.thalesgroup.trivia.service.QuestionService;

@Component
public class MainApp {

	public static void main(String[] args) throws IOException, JSONException {

		System.out.println("start app!");

		ApplicationContext context = new AnnotationConfigApplicationContext(com.thalesgroup.trivia.ComponentConfig.class);
		
//		 test1(context);

		test2(context);

	}

	@SuppressWarnings("unchecked")
	private static void test1(ApplicationContext context) {
//		DAO<Question> dao = (DAO<Question>) context.getBean("collection");
//		 DAO<Question> dao1 = (DAO<Question>) context.getBean("map");
		// DAO<Person> dao = context.getBean(DAO.class);
//
//		dao.create(new Question("ionel1", "ionut1@email.com", "0723 123 456", "Google SRL"));
//		dao.create(new Question("ionel2", "ionut2@email.com", "0723 123 456", "Google SRL"));
//		dao.create(new Question("ionel3", "ionut3@email.com", "0723 123 456", "Google SRL"));
		

//		dao1.create(new Question("ionel4", "ionut4@email.com", "0723 123 456", "Google 4 SRL"));

//		System.out.println(Arrays.asList(dao.getAll()));
		

//		System.out.println(Arrays.asList(dao1.getAll()));
	}

	@SuppressWarnings("unchecked")
	private static void test2(ApplicationContext context) throws IOException, JSONException {
		QuestionService service = context.getBean(QuestionService.class);

		service.createQuestions(10);
		service.printAll();
	}
}
