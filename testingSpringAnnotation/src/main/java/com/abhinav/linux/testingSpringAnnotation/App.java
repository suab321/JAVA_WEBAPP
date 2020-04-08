package com.abhinav.linux.testingSpringAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext factory=new AnnotationConfigApplicationContext(AppConfig.class);
    	TestModel tm=(TestModel)factory.getBean(TestModel.class);
    	tm.config();
    }
}
