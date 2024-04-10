package com.amaap.cleanstrike.service;

import com.amaap.cleanstrike.domain.model.Player;
import com.amaap.cleanstrike.domain.model.Strikes;
import com.amaap.cleanstrike.repository.PlayerRepository;

import java.util.ArrayList;

public class PlayerService {
    PlayerRepository playerRepository;
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player create() {
        return playerRepository.add();
    }

    public Player get(int id) {
        return playerRepository.getPlayer(id);
    }
}
