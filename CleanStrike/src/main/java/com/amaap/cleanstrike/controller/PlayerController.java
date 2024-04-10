package com.amaap.cleanstrike.controller;

import com.amaap.cleanstrike.controller.dto.HttpStatus;
import com.amaap.cleanstrike.controller.dto.Response;
import com.amaap.cleanstrike.domain.model.Player;
import com.amaap.cleanstrike.service.PlayerService;
import com.amaap.cleanstrike.service.exception.InvalidPlayerIdException;

import java.util.ArrayList;

public class PlayerController {
    PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    public Response create() {
        playerService.create();
        return new Response(HttpStatus.Ok,"Player created successfully");
    }


    public Player get(int id) throws InvalidPlayerIdException {
        return playerService.get(id);
    }
}
