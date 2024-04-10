package com.amaap.cleanstrike.repository.db;

import com.amaap.cleanstrike.domain.model.CarromBoard;
import com.amaap.cleanstrike.domain.model.Player;
import com.amaap.cleanstrike.domain.model.exception.InvalidCarromBoardDataException;

public interface InMemoryDatabase {
    Player insertIntoPlayerTable();

    Player selectFromPlayerTable(int id);

    CarromBoard insertIntoCarromBoardTable(int numberOfBlackCoins, int numberOfRedCoins) throws InvalidCarromBoardDataException;
}
