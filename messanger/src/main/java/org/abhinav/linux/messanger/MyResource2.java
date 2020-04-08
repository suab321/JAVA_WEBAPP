package org.abhinav.linux.messanger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("myresource2")
public class MyResource2 {
	
	@Path("/hello")
	@GET
	public String Hello() {
		return "Hello";
	}
}
