package com.amaap.cleanstrike.service;

import com.amaap.cleanstrike.domain.model.CarromBoard;
import com.amaap.cleanstrike.domain.model.Player;
import com.amaap.cleanstrike.domain.model.exception.InvalidCarromBoardDataException;
import com.amaap.cleanstrike.domain.service.WinnerEvaluator;
import com.amaap.cleanstrike.repository.CarromBoardRepository;
import com.amaap.cleanstrike.repository.db.InMemoryDatabase;
import com.amaap.cleanstrike.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.cleanstrike.repository.impl.InMemoryCarromBoardRepository;
import com.amaap.cleanstrike.repository.impl.InMemoryPlayerRepository;
import com.amaap.cleanstrike.service.exception.CarromBoardNotFoundException;
import com.amaap.cleanstrike.service.exception.PlayerEngagedException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarromBoardServiceTest {
    InMemoryDatabase inMemoryDatabase = new FakeInMemoryDatabase();
    CarromBoardRepository carromBoardRepository = new InMemoryCarromBoardRepository(inMemoryDatabase);
    PlayerService playerService = new PlayerService(new InMemoryPlayerRepository(new FakeInMemoryDatabase()));
    WinnerEvaluator winnerEvaluator = new WinnerEvaluator(playerService);
    CarromBoardService carromBoardService = new CarromBoardService(carromBoardRepository, winnerEvaluator);
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

    @Test
    void shouldBeAbleToGetWinnerOfGame() throws CarromBoardNotFoundException, InvalidCarromBoardDataException, PlayerEngagedException {
        // arrange
        int numberOfBlackCoins=9;
        int numberOfRedCoins=1;
        int carromBoardId = 1;

        // act
        carromBoardService.create(numberOfBlackCoins,numberOfRedCoins);
        Player player1 = playerService.create();
        Player player2 = playerService.create();
        List<Player> players = List.of(player1,player2);
        carromBoardService.assignPlayers(players,carromBoardId);
        Player winningPlayer = carromBoardService.winnerEvaluator(carromBoardId);

        // assert
//        assertEquals(player1,winningPlayer);
    }

}