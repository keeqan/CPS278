package com.college.collegedemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DIDemoApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        College college = (College)context.getBean("wcc");

        System.out.println(college);
        college.printCollegeService();

        Finaid finaid = (Finaid)context.getBean("finaid2");
        finaid.displayFinaid();

        ((ClassPathXmlApplicationContext)context).close();
        
    }
    
}
