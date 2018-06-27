package com.briup.apps.poll.bean.extend;

import com.briup.apps.poll.bean.Question;

public class OptionsVM {
    private Long id;
    private String name;    
    private String label;   
    private Integer score;   
    private Question question;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Question getQuestionId() {
		return question;
	}
	public void setQuestionId(Question questionId) {
		this.question = questionId;
	}
}