package com.amaap.cleanstrike.controller;

import com.amaap.cleanstrike.domain.model.Player;
import com.amaap.cleanstrike.domain.model.Strikes;
import com.amaap.cleanstrike.repository.db.InMemoryDatabase;
import com.amaap.cleanstrike.controller.dto.HttpStatus;
import com.amaap.cleanstrike.controller.dto.Response;
import com.amaap.cleanstrike.repository.PlayerRepository;
import com.amaap.cleanstrike.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.cleanstrike.repository.impl.InMemoryPlayerRepository;
import com.amaap.cleanstrike.service.PlayerService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerControllerTest {
    InMemoryDatabase inMemoryDatabase = new FakeInMemoryDatabase();
    PlayerRepository playerRepository = new InMemoryPlayerRepository(inMemoryDatabase);
    PlayerService playerService = new PlayerService(playerRepository);
    PlayerController playerController = new PlayerController(playerService);

    @Test
    void shouldBeAbleToCreatePlayer()
    {
        // arrange
        Response expected = new Response(HttpStatus.Ok,"Player created successfully");

        // act
        Response actual = playerController.create();

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToGetPlayerById()
    {
        // arrange
        int id = 1;
        int points = 0;
        List<Strikes> strikes = new ArrayList<>();
        Player expected = new Player(id,points,strikes);
        playerController.create();

        // act
        Player actual = playerController.get(id);

        // assert
        assertEquals(expected,actual);
    }
}
