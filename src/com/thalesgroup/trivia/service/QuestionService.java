package com.thalesgroup.trivia.service;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Arrays;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.thalesgroup.trivia.bean.Question;
import com.thalesgroup.trivia.dao.DAO;

public class QuestionService {

	private DAO<Question> dao;
	private PrintStream ps = System.out;

	public QuestionService(DAO<Question> dao, PrintStream ps) {
		super();
		this.dao = dao;
		this.ps = ps;
	}

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}

	public void createQuestions(int counter) throws IOException, JSONException {
		JSONObject jsonObject = readJsonFromUrl("https://opentdb.com/api.php?amount=" +  counter + "&difficulty=hard&type=boolean");
		JSONArray array = jsonObject.getJSONArray("results");
		
		for(int i = 0; i < counter; i++) {
			Question q = new Question(((JSONObject) array.get(i)));
			this.dao.create(q);
		}
	}

	public Question[] getQuestions() {
		return this.dao.getAll();
	}
	
	public void printAll() {
		
		ps.println(Arrays.asList(dao.getAll()));
	}
}
