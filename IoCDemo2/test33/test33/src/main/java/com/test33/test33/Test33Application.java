package com.test33.test33;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Test33Application {

	public static void main(String[] args) {
		SpringApplication.run(Test33Application.class, args);
		ApplicationContext context = new ClassPathXmlApplicationContext("beanConfig.xml");
		IBird bird = (IBird)context.getBean("bird");
		System.out.println(bird.getEatingHabit());

		((ClassPathXmlApplicationContext)context).close();
	}

}
