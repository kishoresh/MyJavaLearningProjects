package com.xml.jaxb.marshalling;

public class Answer {
	private int id;
	private String answername;
	private String postedBy;
	
	public Answer() {}
	public Answer(int id, String ansname, String postedby){
		super();
		this.id = id;
		this.answername = ansname;
		this.postedBy = postedby;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAnswername() {
		return answername;
	}
	public void setAnswername(String answername) {
		this.answername = answername;
	}
	public String getPostedBy() {
		return postedBy;
	}
	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}
}
