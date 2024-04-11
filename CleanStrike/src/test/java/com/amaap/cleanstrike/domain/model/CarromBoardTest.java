package com.amaap.cleanstrike.domain.model;

import com.amaap.cleanstrike.domain.model.exception.InvalidCarromBoardDataException;
import com.amaap.cleanstrike.domain.model.exception.InvalidCarromBoardIdException;
import com.amaap.cleanstrike.domain.model.exception.InvalideNumberOfCoinsException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarromBoardTest {

    @Test
    void shouldBeAbleToCreateCarromBoard() throws InvalidCarromBoardDataException {
        // arrange
        int id = 1;
        int numberOfBlackCoins = 9;
        int numberOfRedCoins = 1;
        CarromBoard expected = new CarromBoard(id,numberOfBlackCoins,numberOfRedCoins);

        // act
        CarromBoard actual = CarromBoard.create(id,numberOfBlackCoins,numberOfRedCoins);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToThrowInvalidCarromBoardIdExceptionInvalidIdIsPassed()
    {
        assertThrows(InvalidCarromBoardIdException.class,()->CarromBoard.create(0,9,1));
        assertThrows(InvalidCarromBoardIdException.class,()->CarromBoard.create(-1,9,1));
    }

    @Test
    void shouldBeAbleToThrowInvalidNumberOfCoinsExceptionWhenInvalidCoinsArePassed()
    {
        assertThrows(InvalideNumberOfCoinsException.class,()->CarromBoard.create(1,0,1));
        assertThrows(InvalideNumberOfCoinsException.class,()->CarromBoard.create(1,5,-1));
        assertThrows(InvalideNumberOfCoinsException.class,()->CarromBoard.create(1,9,0));
        assertThrows(InvalideNumberOfCoinsException.class,()->CarromBoard.create(1,-1,0));
    }


}