package com.battlescene;

public class FireballFightingPower implements FightingPower {

    @Override
    public String getFightingPowerDesc() {
        return "casting fireballs";
    }

    @Override
    public int usePower() {
        return 20; 
    }
}
