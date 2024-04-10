package com.amaap.cleanstrike.repository.db.impl;

import com.amaap.cleanstrike.domain.model.CarromBoard;
import com.amaap.cleanstrike.domain.model.Player;
import com.amaap.cleanstrike.domain.model.Strikes;
import com.amaap.cleanstrike.domain.model.exception.InvalidCarromBoardDataException;
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

    @Test
    void shouldBeAbleToGetPlayerById()
    {
        // arrange
        int id = 1;
        int points = 0;
        List<Strikes> strikes = new ArrayList<>();
        Player expected = new Player(id,points,strikes);
        fakeInMemoryDatabase.insertIntoPlayerTable();

        // act
        Player actual = fakeInMemoryDatabase.selectFromPlayerTable(id);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToCreateCarromBoard() throws InvalidCarromBoardDataException {
        // arrange
        int id = 1;
        int numberOfBlackCoins=9;
        int numberOfRedCoins=1;
        CarromBoard expected = new CarromBoard(id,numberOfBlackCoins,numberOfRedCoins);

        // act
        CarromBoard actual = fakeInMemoryDatabase.insertIntoCarromBoardTable(numberOfBlackCoins,numberOfRedCoins);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToGetCarromBoardById() throws InvalidCarromBoardDataException {
        // arrange
        int id = 1;
        int numberOfBlackCoins=9;
        int numberOfRedCoins=1;
        CarromBoard expected = new CarromBoard(id,numberOfBlackCoins,numberOfRedCoins);

        // act
        fakeInMemoryDatabase.insertIntoCarromBoardTable(numberOfBlackCoins,numberOfRedCoins);
        CarromBoard actual = fakeInMemoryDatabase.selectFromCarromBoardTable(id);

        // assert
        assertEquals(expected,actual);
    }
}