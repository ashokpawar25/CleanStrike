package com.amaap.cleanstrike.controller;

import com.amaap.cleanstrike.controller.dto.HttpStatus;
import com.amaap.cleanstrike.controller.dto.Response;
import com.amaap.cleanstrike.domain.model.CarromBoard;
import com.amaap.cleanstrike.domain.model.Player;
import com.amaap.cleanstrike.domain.model.exception.InvalidCarromBoardDataException;
import com.amaap.cleanstrike.service.CarromBoardService;
import com.amaap.cleanstrike.service.exception.CarromBoardNotFoundException;
import com.amaap.cleanstrike.service.exception.PlayerEngagedException;

import java.util.List;

public class CarromBoardController {
    CarromBoardService carromBoardService;

    public CarromBoardController(CarromBoardService carromBoardService) {
        this.carromBoardService = carromBoardService;
    }

    public Response create(int numberOfBlackCoins, int numberOfRedCoins) {
        try {
            carromBoardService.create(numberOfBlackCoins,numberOfRedCoins);
            return new Response(HttpStatus.Ok,"Carrom board created Successfully");
        }
        catch (InvalidCarromBoardDataException exception)
        {
            return new Response(HttpStatus.BAD_REQUEST,exception.getMessage());
        }
    }

    public CarromBoard get(int id) throws CarromBoardNotFoundException {
        return carromBoardService.get(id);
    }

    public Response assignPlayers(List<Player> players, int carromBoardId) {
        try {
            carromBoardService.assignPlayers(players,carromBoardId);
            return new Response(HttpStatus.Ok,"Players assigned to carrom board");
        }
        catch (PlayerEngagedException exception)
        {
            return new Response(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
        catch (CarromBoardNotFoundException exception)
        {
            return new Response(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }
}
