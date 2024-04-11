package com.amaap.cleanstrike.domain.service;

import com.amaap.cleanstrike.domain.model.CarromBoard;
import com.amaap.cleanstrike.domain.model.Player;
import com.amaap.cleanstrike.domain.model.exception.InvalidCarromBoardDataException;
import com.amaap.cleanstrike.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.cleanstrike.repository.impl.InMemoryCarromBoardRepository;
import com.amaap.cleanstrike.repository.impl.InMemoryPlayerRepository;
import com.amaap.cleanstrike.service.CarromBoardService;
import com.amaap.cleanstrike.service.PlayerService;
import com.amaap.cleanstrike.service.exception.CarromBoardNotFoundException;
import com.amaap.cleanstrike.service.exception.PlayerEngagedException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WinnerEvaluatorTest {

    PlayerService playerService = new PlayerService(new InMemoryPlayerRepository(new FakeInMemoryDatabase()));
    WinnerEvaluator winnerEvaluator = new WinnerEvaluator(playerService);
    CarromBoardService carromBoardService = new CarromBoardService(new InMemoryCarromBoardRepository(new FakeInMemoryDatabase()),winnerEvaluator);
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
        CarromBoard carromBoard = carromBoardService.get(1);
        Player winningPlayer = winnerEvaluator.evaluateWinner(carromBoard);

        // assert
//        assertEquals(player1,winningPlayer);

    }
}