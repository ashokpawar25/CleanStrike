package com.amaap.cleanstrike.repository.db.impl;

import com.amaap.cleanstrike.domain.model.Player;
import com.amaap.cleanstrike.domain.model.Strikes;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FakeInMemoryDatabaseTest {

    FakeInMemoryDatabase fakeInMemoryDatabase = new FakeInMemoryDatabase();
    @Test
    void shouldBeAbleToCreatePlayer()
    {
        // arrange
        int id = 1;
        int points = 0;
        List<Strikes> strikes = new ArrayList<>();
        Player expected = new Player(id,points,strikes);

        // act
        Player actual = fakeInMemoryDatabase.insertIntoPlayerTable();

        // assert
        assertEquals(expected,actual);
    }
}