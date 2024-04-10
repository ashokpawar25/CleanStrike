package com.amaap.cleanstrike.repository.impl;

import com.amaap.cleanstrike.domain.model.CarromBoard;
import com.amaap.cleanstrike.domain.model.exception.InvalidCarromBoardDataException;
import com.amaap.cleanstrike.repository.CarromBoardRepository;
import com.amaap.cleanstrike.repository.db.InMemoryDatabase;
import com.amaap.cleanstrike.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.cleanstrike.service.CarromBoardService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryCarromBoardRepositoryTest {

    InMemoryDatabase inMemoryDatabase = new FakeInMemoryDatabase();
    CarromBoardRepository carromBoardRepository = new InMemoryCarromBoardRepository(inMemoryDatabase);
    @Test
    void shouldBeAbleToCreateCarromBoard() throws InvalidCarromBoardDataException {
        // arrange
        int id = 1;
        int numberOfBlackCoins=9;
        int numberOfRedCoins=1;
        CarromBoard expected = new CarromBoard(id,numberOfBlackCoins,numberOfRedCoins);

        // act
        CarromBoard actual = carromBoardRepository.insert(numberOfBlackCoins,numberOfRedCoins);

        // assert
        assertEquals(expected,actual);
    }

}