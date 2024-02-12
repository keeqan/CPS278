package com.battlescene;

public class SwordFightingPower implements FightingPower {

    @Override
    public String getFightingPowerDesc() {
        return "swinging swords";
    }

    @Override
    public int usePower() {
        return 15; 
    }
}
