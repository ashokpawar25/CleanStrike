package com.amaap.cleanstrike.service;

import com.amaap.cleanstrike.controller.CarromBoardController;
import com.amaap.cleanstrike.domain.model.CarromBoard;
import com.amaap.cleanstrike.domain.model.exception.InvalidCarromBoardDataException;
import com.amaap.cleanstrike.repository.CarromBoardRepository;
import com.amaap.cleanstrike.repository.db.InMemoryDatabase;
import com.amaap.cleanstrike.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.cleanstrike.repository.impl.InMemoryCarromBoardRepository;
import com.amaap.cleanstrike.service.exception.CarromBoardNotFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarromBoardServiceTest {
    InMemoryDatabase inMemoryDatabase = new FakeInMemoryDatabase();
    CarromBoardRepository carromBoardRepository = new InMemoryCarromBoardRepository(inMemoryDatabase);
    CarromBoardService carromBoardService = new CarromBoardService(carromBoardRepository);
    @Test
    void shouldBeAbleToCreateCarromBoard() throws InvalidCarromBoardDataException {
        // arrange
        int id = 1;
        int numberOfBlackCoins=9;
        int numberOfRedCoins=1;
        CarromBoard expected = new CarromBoard(id,numberOfBlackCoins,numberOfRedCoins);

        // act
        CarromBoard actual = carromBoardService.create(numberOfBlackCoins,numberOfRedCoins);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToGetCarromBoardById() throws CarromBoardNotFoundException, InvalidCarromBoardDataException {
        // arrange
        int id = 1;
        int numberOfBlackCoins=9;
        int numberOfRedCoins=1;
        CarromBoard expected = new CarromBoard(id,numberOfBlackCoins,numberOfRedCoins);

        // act
        carromBoardService.create(numberOfBlackCoins,numberOfRedCoins);
        CarromBoard actual = carromBoardService.get(id);

        // assert
        assertEquals(expected,actual);
    }

}