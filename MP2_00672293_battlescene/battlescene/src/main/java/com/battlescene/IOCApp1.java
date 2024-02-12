package com.battlescene;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class IOCApp1 {
    public static void main(String[] args) {
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("file:src/main/resources/beans.xml");
        Battle battle = context.getBean(Battle.class);
        battle.fight();
        context.close();
    }
}