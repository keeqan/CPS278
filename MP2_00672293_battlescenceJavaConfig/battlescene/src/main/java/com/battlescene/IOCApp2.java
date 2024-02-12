package com.battlescene;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCApp2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Battle battle = context.getBean(Battle.class);
        battle.fight();
        context.close();
    }
}
