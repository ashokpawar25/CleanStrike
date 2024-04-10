package com.amaap.cleanstrike.repository.impl;

import com.amaap.cleanstrike.repository.db.InMemoryDatabase;
import com.amaap.cleanstrike.domain.model.Player;
import com.amaap.cleanstrike.repository.PlayerRepository;

public class InMemoryPlayerRepository implements PlayerRepository {
    InMemoryDatabase inMemoryDatabase;
    public InMemoryPlayerRepository(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    @Override
    public Player add() {
        return inMemoryDatabase.insertIntoPlayerTable();
    }
}
