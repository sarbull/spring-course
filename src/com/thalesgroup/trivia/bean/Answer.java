package com.thalesgroup.trivia.bean;

public class Answer extends Entity {
	private static final long serialVersionUID = 8185362965080981969L;
	
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
