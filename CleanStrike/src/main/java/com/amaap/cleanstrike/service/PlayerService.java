package com.amaap.cleanstrike.service;

import com.amaap.cleanstrike.domain.model.Player;
import com.amaap.cleanstrike.domain.model.Strikes;
import com.amaap.cleanstrike.repository.PlayerRepository;
import com.amaap.cleanstrike.service.exception.InvalidPlayerIdException;

import java.util.ArrayList;

public class PlayerService {
    PlayerRepository playerRepository;
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player create() {
        return playerRepository.add();
    }

    public Player get(int id) throws InvalidPlayerIdException {
        Player player = playerRepository.getPlayer(id);
        if (player == null) throw new InvalidPlayerIdException("Player with [id:"+id+"] not found");
        return player;
    }
}
