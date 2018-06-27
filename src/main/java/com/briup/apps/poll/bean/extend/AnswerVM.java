package com.briup.apps.poll.bean.extend;

import com.briup.apps.poll.bean.Survey;

public class AnswerVM {
	private Long id;
	private String selection;
	private String checkes;
	private String content;
	private Survey survey;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSelection() {
		return selection;
	}
	public void setSelection(String selection) {
		this.selection = selection;
	}
	public String getCheckes() {
		return checkes;
	}
	public void setCheckes(String checkes) {
		this.checkes = checkes;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Survey getSurvey() {
		return survey;
	}
	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

}
