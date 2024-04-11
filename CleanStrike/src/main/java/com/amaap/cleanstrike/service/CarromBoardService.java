package com.amaap.cleanstrike.service;

import com.amaap.cleanstrike.domain.model.CarromBoard;
import com.amaap.cleanstrike.domain.model.Player;
import com.amaap.cleanstrike.domain.model.exception.InvalidCarromBoardDataException;
import com.amaap.cleanstrike.domain.service.WinnerEvaluator;
import com.amaap.cleanstrike.repository.CarromBoardRepository;
import com.amaap.cleanstrike.service.exception.CarromBoardNotFoundException;
import com.amaap.cleanstrike.service.exception.PlayerEngagedException;

import java.util.List;

public class CarromBoardService {
    private CarromBoardRepository carromBoardRepository;
    private WinnerEvaluator winnerEvaluator;
    public CarromBoardService(CarromBoardRepository carromBoardRepository, WinnerEvaluator winnerEvaluator) {
        this.carromBoardRepository = carromBoardRepository;
        this.winnerEvaluator=winnerEvaluator;
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

    public Player winnerEvaluator(int carromBoardId) throws CarromBoardNotFoundException {
        CarromBoard carromBoard = this.get(carromBoardId);
        Player winningPlayer = winnerEvaluator.evaluateWinner(carromBoard);
        if(winningPlayer==null)
        {
            System.out.println("Game draw");
            return null;
        }
        else{
            System.out.println("Player having Id :"+winningPlayer.getId()+" is winner");
            return winningPlayer;
        }
    }
}
