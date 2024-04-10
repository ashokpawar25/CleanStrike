package com.amaap.cleanstrike.service;

import com.amaap.cleanstrike.domain.model.CarromBoard;
import com.amaap.cleanstrike.domain.model.Player;
import com.amaap.cleanstrike.domain.model.exception.InvalidCarromBoardDataException;
import com.amaap.cleanstrike.repository.CarromBoardRepository;
import com.amaap.cleanstrike.service.exception.CarromBoardNotFoundException;
import com.amaap.cleanstrike.service.exception.PlayerEngagedException;

import java.util.List;

public class CarromBoardService {
    private CarromBoardRepository carromBoardRepository;
    private PlayerService playerService;

    public CarromBoardService(CarromBoardRepository carromBoardRepository,PlayerService playerService) {
        this.playerService = playerService;
        this.carromBoardRepository = carromBoardRepository;
    }

    public CarromBoard create(int numberOfBlackCoins, int numberOfRedCoins) throws InvalidCarromBoardDataException {
        return carromBoardRepository.insert(numberOfBlackCoins, numberOfRedCoins);
    }

    public CarromBoard get(int id) throws CarromBoardNotFoundException {
        CarromBoard carromBoard = carromBoardRepository.select(id);
        if (carromBoard == null) throw new CarromBoardNotFoundException("Carrom board not found");
        return carromBoard;
    }

    public void assignPlayers(List<Player> players, int carromBoardId) throws PlayerEngagedException, CarromBoardNotFoundException {
        CarromBoard carromBoard = this.get(carromBoardId);
        for (Player player : players) {
            if (player.isAlreadyPlaying())
                throw new PlayerEngagedException("Player with [id:" + player.getId() + "] is already playing");
        }
        carromBoard.setPlayers(players);
    }

    public void winnerEvaluator(int carromBoardId) throws CarromBoardNotFoundException {
        CarromBoard carromBoard = this.get(carromBoardId);
        Player player1 = carromBoard.getPlayers().get(0);
        Player player2 = carromBoard.getPlayers().get(1);
        boolean isGameOver = false;
        do {
            playerService.attemptStrike(player1,carromBoard);
            playerService.attemptStrike(player2,carromBoard);
            System.out.println("Player one points :"+player1.getPoints());
            System.out.println("Player two points :"+player2.getPoints());
            if (carromBoard.getNumberOfBlackCoins() == 0 && carromBoard.getNumberOfRedCoins() == 0)
            {
                System.out.println("Game draw");
                isGameOver = true;
            }
            if (player1.getPoints() >= 5 && player1.getPoints() - player2.getPoints() >= 3) {
                System.out.println("Player 1 is winner");
                isGameOver = true;
            }
            if (player2.getPoints() >= 5 && player2.getPoints() - player1.getPoints() >= 3) {
                System.out.println("Player 2 is winner");
                isGameOver = true;
            }

        } while (!isGameOver);
    }
}
