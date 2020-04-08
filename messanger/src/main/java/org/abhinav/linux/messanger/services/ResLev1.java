package org.abhinav.linux.messanger.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

//import org.abhinav.linux.messanger.model.ResLev2Model;

@Path("/profile")
public class ResLev1 {
	
	@Path("/{profile}/comment")
	public ResLev2 sub() {
		return new ResLev2();
	}
}
