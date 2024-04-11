package com.amaap.cleanstrike.controller;

import com.amaap.cleanstrike.controller.dto.HttpStatus;
import com.amaap.cleanstrike.controller.dto.Response;
import com.amaap.cleanstrike.domain.model.CarromBoard;
import com.amaap.cleanstrike.domain.model.Player;
import com.amaap.cleanstrike.domain.model.exception.InvalidCarromBoardDataException;
import com.amaap.cleanstrike.domain.model.exception.InvalidCarromBoardIdException;
import com.amaap.cleanstrike.domain.model.exception.InvalideNumberOfCoinsException;
import com.amaap.cleanstrike.repository.CarromBoardRepository;
import com.amaap.cleanstrike.repository.db.InMemoryDatabase;
import com.amaap.cleanstrike.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.cleanstrike.repository.impl.InMemoryCarromBoardRepository;
import com.amaap.cleanstrike.repository.impl.InMemoryPlayerRepository;
import com.amaap.cleanstrike.service.CarromBoardService;
import com.amaap.cleanstrike.service.PlayerService;
import com.amaap.cleanstrike.service.exception.CarromBoardNotFoundException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CarromBoardControllerTest {

    InMemoryDatabase inMemoryDatabase = new FakeInMemoryDatabase();
    CarromBoardRepository carromBoardRepository = new InMemoryCarromBoardRepository(inMemoryDatabase);
    PlayerService playerService = new PlayerService(new InMemoryPlayerRepository(new FakeInMemoryDatabase()));
    CarromBoardService carromBoardService = new CarromBoardService(carromBoardRepository,playerService);
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

    @Test
    void shouldBeAbleToGetResponseAsBadRequestWhenInvalidInputsProvided()
    {
        // arrange
        Response expected = new Response(HttpStatus.BAD_REQUEST,"Invalid number of coins");

        // act
        Response actual = carromBoardController.create(-9,0);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToGetCarromBoardById() throws CarromBoardNotFoundException {
        // arrange
        int id = 1;
        int numberOfBlackCoins=9;
        int numberOfRedCoins=1;
        CarromBoard expected = new CarromBoard(id,numberOfBlackCoins,numberOfRedCoins);

        // act
        carromBoardController.create(numberOfBlackCoins,numberOfRedCoins);
        CarromBoard actual = carromBoardController.get(id);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldThrowCarromBoardNotFoundExceptionWhenCarromBoardIsNotPresentInDatabase(){
        // arrange
        int id = 1;
        int numberOfBlackCoins=9;
        int numberOfRedCoins=1;
        // act
        carromBoardController.create(numberOfBlackCoins,numberOfRedCoins);

        // assert
        assertThrows(CarromBoardNotFoundException.class,()->carromBoardController.get(2));
    }

    @Test
    void shouldBeAbleToAssignPlayersToCarromBoard() {
        // arrange
        int numberOfBlackCoins=9;
        int numberOfRedCoins=1;
        int carromBoardId = 1;
        Response expected = new Response(HttpStatus.Ok,"Players assigned to carrom board");

        // act
        carromBoardController.create(numberOfBlackCoins,numberOfRedCoins);
        Player player1 = playerService.create();
        Player player2 = playerService.create();
        List<Player> players = List.of(player1,player2);
        Response actual = carromBoardController.assignPlayers(players,carromBoardId);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToGetBadRequestAsResponseWhenTryToAssignAlreadyPlayingPlayerToCarromBoard() {
        // arrange
        int numberOfBlackCoins=9;
        int numberOfRedCoins=1;
        int carromBoardId = 1;
        Response expected = new Response(HttpStatus.BAD_REQUEST,"Player with [id:1] is already playing");

        // act
        carromBoardController.create(numberOfBlackCoins,numberOfRedCoins);
        Player player1 = playerService.create();
        Player player2 = playerService.create();
        player1.setAlreadyPlaying(true);
        List<Player> players = List.of(player1,player2);
        Response actual = carromBoardController.assignPlayers(players,carromBoardId);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToGetBadRequestAsResponseWhenTryToAssignPlayerToInvalidCarromBoard() {
        // arrange
        int numberOfBlackCoins=9;
        int numberOfRedCoins=1;
        int carromBoardId = 2;
        Response expected = new Response(HttpStatus.BAD_REQUEST,"Carrom board not found");

        // act
        carromBoardController.create(numberOfBlackCoins,numberOfRedCoins);
        Player player1 = playerService.create();
        Player player2 = playerService.create();
        List<Player> players = List.of(player1,player2);
        Response actual = carromBoardController.assignPlayers(players,carromBoardId);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToGetWinnerOfGame() throws CarromBoardNotFoundException {
        // arrange
        int numberOfBlackCoins=9;
        int numberOfRedCoins=1;
        int carromBoardId = 1;

        // act
        carromBoardController.create(numberOfBlackCoins,numberOfRedCoins);
        Player player1 = playerService.create();
        Player player2 = playerService.create();
        List<Player> players = List.of(player1,player2);
        carromBoardController.assignPlayers(players,carromBoardId);
        carromBoardController.winnerEvaluator(carromBoardId);
    }

    @Test
    void shouldBeAbleToCheckEqualityOfInstances()
    {
        CarromBoard carromBoard1 = new CarromBoard(1,9,1);
        CarromBoard carromBoard2 = new CarromBoard(1,9,1);
        CarromBoard carromBoard3 = new CarromBoard(1,8,2);
        Object object = new Object();

        assertTrue(carromBoard1.equals(carromBoard1));
        assertTrue(carromBoard1.equals(carromBoard2));
        assertFalse(carromBoard1.equals(object));
        assertFalse(carromBoard1.equals(null));
        assertFalse(carromBoard1.equals(carromBoard3));

    }
}
