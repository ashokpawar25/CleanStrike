package com.amaap.cleanstrike.domain.config;

import com.amaap.cleanstrike.domain.model.Strikes;

import java.util.HashMap;
import java.util.Map;

public class StrikesConfig {
    public static Map<Integer, Strikes> getStrikes() {
        Map<Integer, Strikes> strikes = new HashMap<>();
        strikes.put(1,Strikes.EMPTY_STRIKE);
        strikes.put(2,Strikes.STRIKE);
        strikes.put(3,Strikes.MULTI_STRIKE);
        strikes.put(4,Strikes.DEFUNCT_COIN_STRIKE);
        strikes.put(5,Strikes.RED_STRIKE);
        strikes.put(6,Strikes.STRIKER_STRIKE);
        return strikes;
    }
}
