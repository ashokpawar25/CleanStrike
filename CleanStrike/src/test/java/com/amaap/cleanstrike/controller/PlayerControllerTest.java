package com.amaap.cleanstrike.controller;

import com.amaap.cleanstrike.domain.model.Player;
import com.amaap.cleanstrike.domain.model.Strikes;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerControllerTest {
    PlayerController playerController = new PlayerController();

    @Test
    void shouldBeAbleToCreatePlayer()
    {
        // arrange
        int id = 1;
        int points = 0;
        List<Strikes> strikes = new ArrayList<Strikes>();
        Player expected = new Player(id,points,strikes);

        // act
        Player actual = playerController.create();

        // assert
        assertEquals(expected,actual);
    }
}
