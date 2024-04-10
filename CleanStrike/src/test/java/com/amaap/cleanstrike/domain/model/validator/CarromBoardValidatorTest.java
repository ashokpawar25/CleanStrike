package com.amaap.cleanstrike.domain.model.validator;

import org.junit.jupiter.api.Test;

import static com.amaap.cleanstrike.domain.model.validator.CarromBoardValidator.isInvalidId;
import static com.amaap.cleanstrike.domain.model.validator.CarromBoardValidator.isInvalidNumbersOfCoin;
import static org.junit.jupiter.api.Assertions.*;

class CarromBoardValidatorTest {

    @Test
    void shouldBeAbleToValidateIdForCarromBoard()
    {
        assertTrue(isInvalidId(0));
        assertTrue(isInvalidId(-2));
        assertFalse(isInvalidId(1));
    }

    @Test
    void shouldBeAbleToValidateNumberOfCoinsForCarromBoard()
    {
        assertTrue(isInvalidNumbersOfCoin(0,4));
        assertTrue(isInvalidNumbersOfCoin(4,0));
        assertTrue(isInvalidNumbersOfCoin(5,-1));
        assertTrue(isInvalidNumbersOfCoin(-3,4));
        assertTrue(isInvalidNumbersOfCoin(-7,-4));
        assertFalse(isInvalidNumbersOfCoin(9,1));

    }

}