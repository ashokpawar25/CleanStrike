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

    @Test
    void shouldBeAbleToCheckEqualityOfInstances()
    {
        CarromBoard carromBoard1 = new CarromBoard(1,9,1);
        CarromBoard carromBoard2 = new CarromBoard(1,9,1);
        CarromBoard carromBoard3 = new CarromBoard(1,9,2);
        CarromBoard carromBoard4 = new CarromBoard(1,7,2);
        CarromBoard carromBoard5 = new CarromBoard(2,7,2);
        Object object = new Object();

        assertTrue(carromBoard1.equals(carromBoard1));
        assertTrue(carromBoard1.equals(carromBoard2));
        assertFalse(carromBoard1.equals(object));
        assertFalse(carromBoard1.equals(null));
        assertFalse(carromBoard1.equals(carromBoard3));
        assertFalse(carromBoard3.equals(carromBoard4));
        assertFalse(carromBoard4.equals(carromBoard5));
    }
}