package com.amaap.cleanstrike.domain.model;

import com.amaap.cleanstrike.domain.model.exception.InvalidPlayerIdException;
import com.amaap.cleanstrike.domain.model.exception.InvalidePlayerPointsException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PlayerTest {

    @Test
    void shouldBeAbleToCreatePlayer() throws InvalidPlayerIdException, InvalidePlayerPointsException {
        // arrange
        int id = 1;
        int points = 0;
        Player expected = new Player(id, points);

        // act
        Player actual = Player.create(id, points);

        // assert
        assertEquals(expected, actual);

    }

    @Test
    void shouldBeAbleToThrowInvalidIdExceptionWhenInvalidIdIsPassed(){

        assertThrows(InvalidPlayerIdException.class, () -> Player.create(0, 0));
    }

    @Test
    void shouldBeAbleToThrowInvalidPointExceptionWhenInvalidPointIsPassed(){

        assertThrows(InvalidePlayerPointsException.class, () -> Player.create(1, -2));
    }

}