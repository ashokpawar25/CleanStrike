package com.amaap.cleanstrike.service;

import com.amaap.cleanstrike.domain.model.CarromBoard;
import com.amaap.cleanstrike.domain.model.exception.InvalidCarromBoardDataException;
import com.amaap.cleanstrike.repository.CarromBoardRepository;
import com.amaap.cleanstrike.service.exception.CarromBoardNotFoundException;

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
}
