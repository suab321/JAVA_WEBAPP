package org.abhinav.linux.messanger.services;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.abhinav.linux.messanger.Exceptions.DataNotFoundException;
import org.abhinav.linux.messanger.model.TestModel;

//@Path("/")
public class ResLev2 {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public TestModel sub() {
		return new TestModel(1,"abhinav");
	}
	@POST 
	public String pub() throws DataNotFoundException {
		int t=1;
		if(t==1) {
			throw new DataNotFoundException("t is 1!");
		}
		return "bye";
	}
}
