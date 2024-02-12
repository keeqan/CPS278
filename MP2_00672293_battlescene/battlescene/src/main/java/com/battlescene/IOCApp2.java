package com.battlescene;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCApp2 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Battle battle = context.getBean(Battle.class);
        battle.fight();
        context.close();
    }
}