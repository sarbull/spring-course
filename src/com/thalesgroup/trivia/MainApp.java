package com.thalesgroup.trivia;

import java.io.IOException;
//import java.util.Arrays;
import java.util.Scanner;

import org.json.JSONException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.thalesgroup.trivia.bean.Answer;
import com.thalesgroup.trivia.bean.Question;
import com.thalesgroup.trivia.dao.DAO;
//import com.thalesgroup.trivia.bean.Question;
//import com.thalesgroup.trivia.dao.DAO;
import com.thalesgroup.trivia.service.QuestionService;

@Component
public class MainApp {

	public static void main(String[] args) throws IOException, JSONException {

		System.out.println("start app!");

		ApplicationContext context = new AnnotationConfigApplicationContext(com.thalesgroup.trivia.ComponentConfig.class);

		test2(context);

		startGame(context);
	}

	private static void test2(ApplicationContext context) throws IOException, JSONException {
		QuestionService service = context.getBean(QuestionService.class);

		service.createQuestions(5);
		service.printAll();
	}
	
	public static String escapeHTML(String s) {
	    StringBuilder out = new StringBuilder(Math.max(16, s.length()));
	    for (int i = 0; i < s.length(); i++) {
	        char c = s.charAt(i);
	        if (c > 127 || c == '"' || c == '<' || c == '>' || c == '&') {
	            out.append("&#");
	            out.append((int) c);
	            out.append(';');
	        } else {
	            out.append(c);
	        }
	    }
	    return out.toString();
	}
	
	private static void startGame(ApplicationContext context) {
		QuestionService service = context.getBean(QuestionService.class);
		
		Scanner s = new Scanner(System.in);
		
		DAO<Answer> daoAnswer = (DAO<Answer>) context.getBean("answers");
		
		Question[] questions = service.getQuestions();
		
		System.out.println("Game has started!");
		for (Question question : questions) {
			System.out.println("Question = " + escapeHTML(question.getQuestion()));
			
			boolean answer = Boolean.valueOf(s.nextLine().toLowerCase());
			
			if(answer == question.correctAnswer()) {
				Answer a = new Answer(answer);
				daoAnswer.create(a);
			}
		}
		s.close();
		
		System.out.println("END OF GAME");
		System.out.println("You scored = " +  daoAnswer.getAll().length);
	}
}
