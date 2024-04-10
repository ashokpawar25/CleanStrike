package com.amaap.cleanstrike.repository.db.impl;

import com.amaap.cleanstrike.domain.model.CarromBoard;
import com.amaap.cleanstrike.domain.model.exception.InvalidCarromBoardDataException;
import com.amaap.cleanstrike.repository.db.InMemoryDatabase;
import com.amaap.cleanstrike.domain.model.Player;

import java.util.ArrayList;
import java.util.List;

public class FakeInMemoryDatabase implements InMemoryDatabase {
    List<Player> players = new ArrayList<>();
    List<CarromBoard> carromBoards = new ArrayList<>();
    int playerIdCounter=1;
    int carromBoardIdCounter=1;
    @Override
    public Player insertIntoPlayerTable() {
        Player player = new Player(playerIdCounter,0,new ArrayList<>());
        playerIdCounter++;
        players.add(player);
        return player;
    }

    @Override
    public Player selectFromPlayerTable(int id) {
        for(Player player:players)
        {
            if(player.getId()== id) return player;
        }
        return null;
    }

    @Override
    public CarromBoard insertIntoCarromBoardTable(int numberOfBlackCoins, int numberOfRedCoins) throws InvalidCarromBoardDataException {
        CarromBoard carromBoard = CarromBoard.create(carromBoardIdCounter,numberOfBlackCoins,numberOfRedCoins);
        carromBoardIdCounter++;
        carromBoards.add(carromBoard);
        return carromBoard;
    }

    @Override
    public CarromBoard selectFromCarromBoardTable(int id) {
        for(CarromBoard carromBoard:carromBoards)
        {
            if(carromBoard.getId()==id) return carromBoard;
        }
        return null;
    }
}
