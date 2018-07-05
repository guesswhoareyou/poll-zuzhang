package com.briup.apps.poll.bean.extend;

import java.util.List;

import io.swagger.annotations.Api;

@Api(value="问卷模型")
public class QuestionnaireVM {
	private Long id;
	private String name;
	private String description;
	
	private List<QuestionVM> questionVM;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<QuestionVM> getQuestionVM() {
		return questionVM;
	}

	public void setQuestionVM(List<QuestionVM> questionVM) {
		this.questionVM = questionVM;
	}



}
