package com.mbdev.springcontext;

import org.springframework.context.support.ClassPathXmlApplicationContext;
public class  Application {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        FightClub fightClub = context.getBean(FightClub.class);
        fightClub.fight();
    }
}
