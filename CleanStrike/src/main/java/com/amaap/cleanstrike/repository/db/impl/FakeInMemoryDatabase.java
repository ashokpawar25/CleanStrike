package com.amaap.cleanstrike.repository.db.impl;

import com.amaap.cleanstrike.repository.db.InMemoryDatabase;
import com.amaap.cleanstrike.domain.model.Player;

import java.util.ArrayList;
import java.util.List;

public class FakeInMemoryDatabase implements InMemoryDatabase {
    List<Player> players = new ArrayList<>();
    int playerIdCounter=1;
    @Override
    public Player insertIntoPlayerTable() {
        Player player = new Player(playerIdCounter,0,new ArrayList<>());
        playerIdCounter++;
        players.add(player);
        return player;
    }

    @Override
    public Player selectFromPlayerTable(int id) {
        for(Player player:players)
        {
            if(player.getId()== id) return player;
        }
        return null;
    }
}
