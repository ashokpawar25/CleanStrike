package com.amaap.cleanstrike.domain.service;

import com.amaap.cleanstrike.domain.model.CarromBoard;
import com.amaap.cleanstrike.domain.model.Player;
import com.amaap.cleanstrike.service.PlayerService;

public class WinnerEvaluator {
    PlayerService playerService;

    public WinnerEvaluator(PlayerService playerService) {
        this.playerService = playerService;
    }

    public Player evaluateWinner(CarromBoard carromBoard) {
        Player player1 = carromBoard.getPlayers().get(0);
        Player player2 = carromBoard.getPlayers().get(1);
        while (true) {
            playerService.attemptStrike(player1, carromBoard);
            playerService.attemptStrike(player2, carromBoard);
            System.out.println("Player one points :" + player1.getPoints());
            System.out.println("Player two points :" + player2.getPoints());
            if (carromBoard.getNumberOfBlackCoins() == 0 && carromBoard.getNumberOfRedCoins() == 0) {
                return (null);
            }
            if (player1.getPoints() >= 5 && player1.getPoints() - player2.getPoints() >= 3) {
                return (player1);
            }
            if (player2.getPoints() >= 5 && player2.getPoints() - player1.getPoints() >= 3) {
                return (player2);
            }
        }
    }
}
