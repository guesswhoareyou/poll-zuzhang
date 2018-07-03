package com.briup.apps.poll.vm;

import java.util.List;
import com.briup.apps.poll.bean.Answer;
import com.briup.apps.poll.bean.extend.SurveyVM;

public class SurveyAndAnswerVM {
	private SurveyVM surveyVM;
	private List<Answer> Answer;
	
	public SurveyVM getSurveyVM() {
		return surveyVM;
	}
	public void setSurveyVM(SurveyVM surveyVM) {
		this.surveyVM = surveyVM;
	}
	public List<Answer> getAnswer() {
		return Answer;
	}
	public void setAnswer(List<Answer> Answer) {
		this.Answer = Answer;
	}
	
}
