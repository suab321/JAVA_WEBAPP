package org.abhinav.linux.messanger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class messanger {
	int id;
	Date date;
	String message;
	messanger(){}
	public messanger(int id,Date date,String message){
		this.id=id;
		this.date=date;
		this.message=message;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
