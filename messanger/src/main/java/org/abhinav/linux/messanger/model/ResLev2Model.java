package org.abhinav.linux.messanger.model;


public class ResLev2Model {
	int id;
	String comment;
	public ResLev2Model(){}
	public ResLev2Model(int id,String comment) {
		this.id=id;
		this.comment=comment;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
