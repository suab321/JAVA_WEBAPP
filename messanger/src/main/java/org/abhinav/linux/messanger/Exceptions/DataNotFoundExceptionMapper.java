package org.abhinav.linux.messanger.Exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {
	@Override
	public Response toResponse(DataNotFoundException exception) {
		System.out.println("Mapper");
		return Response.status(Response.Status.BAD_REQUEST).entity(exception).build();
	}
}
