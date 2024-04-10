package com.amaap.cleanstrike.repository;

import com.amaap.cleanstrike.domain.model.CarromBoard;
import com.amaap.cleanstrike.domain.model.exception.InvalidCarromBoardDataException;

public interface CarromBoardRepository {
    CarromBoard insert(int numberOfBlackCoins, int numberOfRedCoins) throws InvalidCarromBoardDataException;

    CarromBoard select(int id);
}
