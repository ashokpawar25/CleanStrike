package com.amaap.cleanstrike.repository.db;

import com.amaap.cleanstrike.domain.model.Player;

public interface InMemoryDatabase {
    Player insertIntoPlayerTable();

    Player selectFromPlayerTable(int id);
}
