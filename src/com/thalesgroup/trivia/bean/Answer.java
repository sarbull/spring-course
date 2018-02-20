package com.thalesgroup.trivia.bean;

public class Answer extends Entity {
	private boolean answer;
	
	public Answer(boolean answer) {
		this.answer = answer;
	}

	public boolean isAnswer() {
		return answer;
	}

	public void setAnswer(boolean answer) {
		this.answer = answer;
	}
}
