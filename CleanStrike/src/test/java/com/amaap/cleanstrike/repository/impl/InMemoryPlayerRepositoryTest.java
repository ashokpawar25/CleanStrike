package com.amaap.cleanstrike.repository.impl;

import com.amaap.cleanstrike.repository.db.InMemoryDatabase;
import com.amaap.cleanstrike.domain.model.Player;
import com.amaap.cleanstrike.domain.model.Strikes;
import com.amaap.cleanstrike.repository.db.impl.FakeInMemoryDatabase;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryPlayerRepositoryTest {
    InMemoryDatabase inMemoryDatabase = new FakeInMemoryDatabase();

    InMemoryPlayerRepository inMemoryPlayerRepository = new InMemoryPlayerRepository(inMemoryDatabase);

    @Test
    void shouldBeAbleToCreatePlayer()
    {
        // arrange
        int id = 1;
        int points = 0;
        List<Strikes> strikes = new ArrayList<>();
        Player expected = new Player(id,points,strikes);

        // act
        Player actual = inMemoryPlayerRepository.add();

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
        inMemoryPlayerRepository.add();

        // act
        Player actual = inMemoryPlayerRepository.getPlayer(1);

        // assert
        assertEquals(expected,actual);
    }

}