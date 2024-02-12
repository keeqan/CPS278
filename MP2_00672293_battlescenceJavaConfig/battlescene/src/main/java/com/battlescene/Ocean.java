package com.battlescene;

import org.springframework.stereotype.Component;

@Component("ocean")
public class Ocean implements BattleGround {
    @Override
    public String getBattleGroundDesc() {
        return "Somewhere In the Deep Seas";
    }
}