package com.briup.apps.poll.bean.extend;

import java.util.List;

import com.briup.apps.poll.bean.Answer;
import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.bean.Course;
import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.User;

public class SurveyVM{
private Long id;
private String status;
private Integer code;
//@DateTimeFormat(pattern="yyyy-MM-DD")
private String surveyDate;
private Course course;
private Clazz clazz;
private User user;
private Questionnaire questionnaire; 
private List<Answer> answer;
public List<Answer> getAnswer() {
	return answer;
}
public void setAnswer(List<Answer> answer) {
	this.answer =answer;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public Integer getCode() {
	return code;
}
public void setCode(Integer code) {
	this.code = code;
}

public String getSurveyDate() {
	return surveyDate;
}
public void setSurveyDate(String surveyDate) {
	this.surveyDate = surveyDate;
}
public Course getCourse() {
	return course;
}
public void setCourse(Course course) {
	this.course = course;
}
public Clazz getClazz() {
	return clazz;
}
public void setClazz(Clazz clazz) {
	this.clazz = clazz;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Questionnaire getQuestionnaire() {
	return questionnaire;
}
public void setQuestionnaire(Questionnaire questionnaire) {
	this.questionnaire = questionnaire;
}

}
