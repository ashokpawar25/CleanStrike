package com.amaap.cleanstrike.controller;

import com.amaap.cleanstrike.domain.model.Player;
import com.amaap.cleanstrike.domain.model.Strikes;

import java.awt.*;
import java.util.ArrayList;

public class PlayerController {
    public Player create() {
        return new Player(1,0,new ArrayList<Strikes>());
    }
}
