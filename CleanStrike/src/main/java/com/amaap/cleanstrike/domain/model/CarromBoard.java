package com.amaap.cleanstrike.domain.model;

import com.amaap.cleanstrike.domain.model.exception.InvalidCarromBoardDataException;
import com.amaap.cleanstrike.domain.model.exception.InvalidCarromBoardIdException;
import com.amaap.cleanstrike.domain.model.validator.CarromBoardValidator;

import java.util.List;
import java.util.Objects;

public class CarromBoard {

    private final int id;
    private int numberOfBlackCoins;
    private int numberOfRedCoins;
    private List<Player> players;
    public CarromBoard(int id, int numberOfBlackCoins, int numberOfRedCoins) {
        this.id = id;
        this.numberOfBlackCoins = numberOfBlackCoins;
        this.numberOfRedCoins = numberOfRedCoins;
    }

    public static CarromBoard create(int id, int numberOfBlackCoins, int numberOfRedCoins) throws InvalidCarromBoardDataException {
        if(CarromBoardValidator.isInvalidId(id)) throw new InvalidCarromBoardIdException("Invalid carrom board id "+id);
        return new CarromBoard(id,numberOfBlackCoins,numberOfRedCoins);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarromBoard that = (CarromBoard) o;
        return id == that.id && numberOfBlackCoins == that.numberOfBlackCoins && numberOfRedCoins == that.numberOfRedCoins && Objects.equals(players, that.players);
    }
}
