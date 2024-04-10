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

    public CarromBoardService(CarromBoardRepository carromBoardRepository) {
        this.carromBoardRepository = carromBoardRepository;
    }

    public CarromBoard create(int numberOfBlackCoins, int numberOfRedCoins) throws InvalidCarromBoardDataException {
        return carromBoardRepository.insert(numberOfBlackCoins,numberOfRedCoins);
    }

    public CarromBoard get(int id) throws CarromBoardNotFoundException {
        CarromBoard carromBoard = carromBoardRepository.select(id);
        if(carromBoard == null) throw new CarromBoardNotFoundException("Carrom board not found");
        return carromBoard;
    }

    public void assignPlayers(List<Player> players, int carromBoardId) throws PlayerEngagedException, CarromBoardNotFoundException {
        CarromBoard carromBoard = this.get(carromBoardId);
        for(Player player:players)
        {
            if (player.isAlreadyPlaying())
                throw new PlayerEngagedException("Player with [id:"+player.getId()+"] is already playing");
        }
        carromBoard.setPlayers(players);
    }
}
