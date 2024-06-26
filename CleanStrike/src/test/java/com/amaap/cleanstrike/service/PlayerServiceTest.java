package com.amaap.cleanstrike.service;

import com.amaap.cleanstrike.repository.db.InMemoryDatabase;
import com.amaap.cleanstrike.domain.model.Player;
import com.amaap.cleanstrike.domain.model.Strikes;
import com.amaap.cleanstrike.repository.PlayerRepository;
import com.amaap.cleanstrike.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.cleanstrike.repository.impl.InMemoryPlayerRepository;
import com.amaap.cleanstrike.service.exception.PlayerNotFoundException;
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
        Player expected = new Player(id,points);

        // act
        Player actual = playerService.create();

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToGetPlayerById() throws PlayerNotFoundException {
        // arrange
        int id = 1;
        int points = 0;
        Player expected = new Player(id,points);
        playerService.create();

        // act
        Player actual = playerService.get(1);

        // assert
        assertEquals(expected,actual);
    }

}