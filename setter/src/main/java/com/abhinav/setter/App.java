package com.abhinav.setter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.abhinav.setter.config.Config;
import com.abhinav.setter.model.UserModel;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext c=new AnnotationConfigApplicationContext(Config.class);
        UserModel um=(UserModel) c.getBean("user");
        System.out.println(um.getName());
    }
}
