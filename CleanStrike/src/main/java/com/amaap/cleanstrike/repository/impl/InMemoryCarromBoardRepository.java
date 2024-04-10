package com.amaap.cleanstrike.repository.impl;

import com.amaap.cleanstrike.domain.model.CarromBoard;
import com.amaap.cleanstrike.domain.model.exception.InvalidCarromBoardDataException;
import com.amaap.cleanstrike.repository.CarromBoardRepository;
import com.amaap.cleanstrike.repository.db.InMemoryDatabase;

public class InMemoryCarromBoardRepository implements CarromBoardRepository {
    InMemoryDatabase inMemoryDatabase;
    public InMemoryCarromBoardRepository(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    @Override
    public CarromBoard insert(int numberOfBlackCoins, int numberOfRedCoins) throws InvalidCarromBoardDataException {
        return inMemoryDatabase.insertIntoCarromBoardTable(numberOfBlackCoins,numberOfRedCoins);
    }

    @Override
    public CarromBoard select(int id) {
        return inMemoryDatabase.selectFromCarromBoardTable(id);
    }
}
