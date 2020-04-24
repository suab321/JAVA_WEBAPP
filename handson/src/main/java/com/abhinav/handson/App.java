package com.abhinav.handson;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.abhinav.handson.config.Config;
import com.abhinav.handson.model.CollectionModel;
import com.abhinav.handson.model.EmployeeModel;
import com.abhinav.handson.model.UserModel;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext c=new AnnotationConfigApplicationContext(Config.class);
        UserModel um=(UserModel)c.getBean("userSetter");
        EmployeeModel em=(EmployeeModel) c.getBean("empSetter");
        CollectionModel CM=(CollectionModel) c.getBean("collection");
        CM.values();
        System.out.println(um.getAge());
        System.out.println(em.getUm().getAge());
    }
}
