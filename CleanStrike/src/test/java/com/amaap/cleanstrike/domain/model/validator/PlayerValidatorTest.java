package com.amaap.cleanstrike.domain.model.validator;

import com.amaap.cleanstrike.domain.model.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerValidatorTest {

    @Test
    void shouldBeAbleToValidateIdOfPlayer()
    {
        assertTrue(PlayerValidator.isInvalidId(0));
        assertTrue(PlayerValidator.isInvalidId(-1));
        assertFalse(PlayerValidator.isInvalidId(1));
    }

    @Test
    void shouldBeAbleToValidateThePointsOfPlayer()
    {
        assertTrue(PlayerValidator.isInvalidPoints(-2));
        assertFalse(PlayerValidator.isInvalidPoints(0));
        assertFalse(PlayerValidator.isInvalidPoints(1));
    }

    @Test
    void shouldBeAbleToCreateInstanceOfClass()
    {
        // arrange
        PlayerValidator validator = new PlayerValidator();

        // assert
        assertNotNull(validator);
    }

}