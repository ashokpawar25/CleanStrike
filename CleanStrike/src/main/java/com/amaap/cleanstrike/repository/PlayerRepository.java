package com.amaap.cleanstrike.repository;

import com.amaap.cleanstrike.domain.model.Player;

public interface PlayerRepository {
    Player add();

    Player getPlayer(int id);
}
