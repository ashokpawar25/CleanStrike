package com.amaap.cleanstrike.service;

import com.amaap.cleanstrike.repository.db.InMemoryDatabase;
import com.amaap.cleanstrike.domain.model.Player;
import com.amaap.cleanstrike.domain.model.Strikes;
import com.amaap.cleanstrike.repository.PlayerRepository;
import com.amaap.cleanstrike.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.cleanstrike.repository.impl.InMemoryPlayerRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerServiceTest {
    InMemoryDatabase inMemoryDatabase = new FakeInMemoryDatabase();

    PlayerRepository playerRepository = new InMemoryPlayerRepository(inMemoryDatabase);
    PlayerService playerService = new PlayerService(playerRepository);
    @Test
    void shouldBeAbleToCreatePlayer()
    {
        // arrange
        int id = 1;
        int points = 0;
        List<Strikes> strikes = new ArrayList<>();
        Player expected = new Player(id,points,strikes);

        // act
        Player actual = playerService.create();

        // assert
        assertEquals(expected,actual);
    }

}