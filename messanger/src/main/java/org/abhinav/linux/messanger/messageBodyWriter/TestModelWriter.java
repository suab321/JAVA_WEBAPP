package org.abhinav.linux.messanger.messageBodyWriter;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import org.abhinav.linux.messanger.model.TestModel;

@Provider
public class TestModelWriter implements MessageBodyWriter<TestModel> {

	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		// TODO Auto-generated method stub
		return TestModel.class.isAssignableFrom(type);
	}
	
	@Override
	public void writeTo(TestModel t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
			throws IOException, WebApplicationException {
		// TODO Auto-generated method stub
		String stream=t.getName()+Integer.toString(t.getId());
		entityStream.write(stream.getBytes());
	}
}
