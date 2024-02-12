package com.battlescene;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Character character1() {
        return new Character("Keegan", 100, 50, fireballFightingPower());
    }

    @Bean
    public Character character2() {
        return new Character("Java Bugs", 100, 45, swordFightingPower());
    }

    @Bean
    public FightingPower fireballFightingPower() {
        return new FireballFightingPower();
    }

    @Bean
    public FightingPower swordFightingPower() {
        return new SwordFightingPower();
    }

    @Bean
    public BattleGround plains() {
        return new Plains();
    }

    @Bean
    public Battle battle() {
        return new Battle(character1(), character2(), plains());
    }
}