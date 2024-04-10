package com.amaap.cleanstrike.controller;

import com.amaap.cleanstrike.controller.dto.HttpStatus;
import com.amaap.cleanstrike.controller.dto.Response;
import com.amaap.cleanstrike.domain.model.CarromBoard;
import com.amaap.cleanstrike.domain.model.Player;
import com.amaap.cleanstrike.domain.model.exception.InvalidCarromBoardDataException;
import com.amaap.cleanstrike.repository.CarromBoardRepository;
import com.amaap.cleanstrike.repository.db.InMemoryDatabase;
import com.amaap.cleanstrike.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.cleanstrike.repository.impl.InMemoryCarromBoardRepository;
import com.amaap.cleanstrike.repository.impl.InMemoryPlayerRepository;
import com.amaap.cleanstrike.service.CarromBoardService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarromBoardControllerTest {

    InMemoryDatabase inMemoryDatabase = new FakeInMemoryDatabase();
    CarromBoardRepository carromBoardRepository = new InMemoryCarromBoardRepository(inMemoryDatabase);
    CarromBoardService carromBoardService = new CarromBoardService(carromBoardRepository);
    CarromBoardController carromBoardController = new CarromBoardController(carromBoardService);
    @Test
    void shouldBeAbleToCreateCarromBoard(){
        // arrange
        Response expected = new Response(HttpStatus.Ok,"Carrom board created Successfully");

        // act
        Response actual = carromBoardController.create(9,1);

        // assert
        assertEquals(expected,actual);
    }
}
