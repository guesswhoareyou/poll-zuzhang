package com.briup.apps.poll.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("答卷类")
public class Answer {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poll_answer.id
     *
     * @mbg.generated Mon Jun 25 16:39:51 CST 2018
     */
	@ApiModelProperty("答卷编号")
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poll_answer.selection
     *
     * @mbg.generated Mon Jun 25 16:39:51 CST 2018
     */
    @ApiModelProperty("单选题答案eg:5|4|5")
    private String selection;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poll_answer.checkes
     *
     * @mbg.generated Mon Jun 25 16:39:51 CST 2018
     */
    @ApiModelProperty("多选题答案eg：5,3|5,4")
    private String checkes;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poll_answer.content
     *
     * @mbg.generated Mon Jun 25 16:39:51 CST 2018
     */
    @ApiModelProperty("简答题答案")
    private String content;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poll_answer.survey_id
     *
     * @mbg.generated Mon Jun 25 16:39:51 CST 2018
     */
    @ApiModelProperty("课调编号，外键")
    private Long surveyId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poll_answer.id
     *
     * @return the value of poll_answer.id
     *
     * @mbg.generated Mon Jun 25 16:39:51 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poll_answer.id
     *
     * @param id the value for poll_answer.id
     *
     * @mbg.generated Mon Jun 25 16:39:51 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poll_answer.selection
     *
     * @return the value of poll_answer.selection
     *
     * @mbg.generated Mon Jun 25 16:39:51 CST 2018
     */
    public String getSelection() {
        return selection;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poll_answer.selection
     *
     * @param selection the value for poll_answer.selection
     *
     * @mbg.generated Mon Jun 25 16:39:51 CST 2018
     */
    public void setSelection(String selection) {
        this.selection = selection == null ? null : selection.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poll_answer.checkes
     *
     * @return the value of poll_answer.checkes
     *
     * @mbg.generated Mon Jun 25 16:39:51 CST 2018
     */
    public String getCheckes() {
        return checkes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poll_answer.checkes
     *
     * @param checkes the value for poll_answer.checkes
     *
     * @mbg.generated Mon Jun 25 16:39:51 CST 2018
     */
    public void setCheckes(String checkes) {
        this.checkes = checkes == null ? null : checkes.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poll_answer.content
     *
     * @return the value of poll_answer.content
     *
     * @mbg.generated Mon Jun 25 16:39:51 CST 2018
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poll_answer.content
     *
     * @param content the value for poll_answer.content
     *
     * @mbg.generated Mon Jun 25 16:39:51 CST 2018
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poll_answer.survey_id
     *
     * @return the value of poll_answer.survey_id
     *
     * @mbg.generated Mon Jun 25 16:39:51 CST 2018
     */
    public Long getSurveyId() {
        return surveyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poll_answer.survey_id
     *
     * @param surveyId the value for poll_answer.survey_id
     *
     * @mbg.generated Mon Jun 25 16:39:51 CST 2018
     */
    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }
}