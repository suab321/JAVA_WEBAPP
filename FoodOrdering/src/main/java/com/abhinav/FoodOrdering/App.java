package com.abhinav.FoodOrdering;

import java.sql.Date;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ComponentScan("com.abhinav.FoodOrdering")
public class App 
{
	public static Environment env;
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
        System.out.println(Calendar.getInstance().getTime());
    }
}
