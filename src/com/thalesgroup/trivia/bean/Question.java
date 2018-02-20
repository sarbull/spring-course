package com.thalesgroup.trivia.bean;

import org.json.JSONObject;

public class Question extends Entity {

	private static final long serialVersionUID = 1L;
	
	private String category;
	private boolean type;
	private String difficulty;
	private String question;
	private boolean correctAnswer;

	public Question(String category, boolean type, String difficulty, String question, boolean correctAnswer) {
		super();
		
		this.category = category;
		this.type = type;
		this.difficulty = difficulty;
		this.question = question;
		this.correctAnswer = correctAnswer;
	}
	
	public Question(JSONObject jsonObject) {
		super();
		
		this.category = (String) jsonObject.get("category");
		this.type = Boolean.valueOf(jsonObject.get("type").toString().toLowerCase());
		this.difficulty = (String) jsonObject.get("difficulty");
		this.question = (String) jsonObject.get("question");
		this.correctAnswer = Boolean.valueOf(jsonObject.get("correct_answer").toString().toLowerCase());
	}
	
	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public boolean isType() {
		return type;
	}


	public void setType(boolean type) {
		this.type = type;
	}


	public String getDifficulty() {
		return difficulty;
	}


	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public boolean correctAnswer() {
		return correctAnswer;
	}


	public void setCorrectAnswer(boolean correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	@Override
	public String toString() {
		return "Question [category=" + category + ", type=" + type + ", difficulty=" + difficulty + ", question="
				+ question + ", correctAnswer=" + correctAnswer + "]";
	}

}
