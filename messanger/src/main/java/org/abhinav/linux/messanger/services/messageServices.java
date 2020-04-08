package org.abhinav.linux.messanger.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
//import javax.inject.Singleton;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.abhinav.linux.messanger.model.messanger;
import org.abhinav.linux.messanger.model.testModel;

//@Singleton
@Path("messageResource")
public class messageServices {
	
	static List<messanger> messages = new ArrayList<>();
	
	@POST
	@Path("/add")
	public Response add(testModel tm) {
		System.out.println(tm.getId()+" "+tm.getName());
		return Response.status(200).entity("Okay").build();
	}
	@Path("/show")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<messanger> show(){
		System.out.println("yes");
		int id=messages.size()+1;
		Date d=new Date();
		messanger m=new messanger(id,d,"abhi");
		messages.add(m);
		id=messages.size()+1;
		d=new Date();
		messanger n=new messanger(id,d,"hello");
		messages.add(n);
		for(messanger itr:messages) {
			System.out.println(itr.getId()+" "+itr.getDate()+" "+itr.getMessage());
		}
		return messages;
	}
	@Path("/query")
	@GET
	public Response query(@Context UriInfo uri) {
		String path1=uri.getQueryParameters().getFirst("id");
		System.out.println(uri.getPath()+" "+uri.getAbsolutePath()+" "+uri.getBaseUri());
		return Response.status(200).entity(path1).build();
	}
}
