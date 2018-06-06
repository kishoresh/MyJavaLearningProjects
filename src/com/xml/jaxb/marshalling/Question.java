package com.xml.jaxb.marshalling;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Question {
	private int id;
	private String questionname;
	private List<Answer> answers;
	
	public Question(){};	
	public Question(int id, String qname, List<Answer> ansList){
		super();
		this.id = id;
		this.questionname = qname;
		this.answers = ansList;
	}
	
	@XmlAttribute
	public int getId() {
		return id;
	}
	@XmlElement
	public String getQuestionname() {
		return questionname;
	}
	@XmlElement
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setQuestionname(String questionname) {
		this.questionname = questionname;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
}
