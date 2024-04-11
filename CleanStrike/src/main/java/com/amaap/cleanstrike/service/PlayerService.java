package com.amaap.cleanstrike.service;

import com.amaap.cleanstrike.domain.config.StrikesConfig;
import com.amaap.cleanstrike.domain.model.CarromBoard;
import com.amaap.cleanstrike.domain.model.Player;
import com.amaap.cleanstrike.domain.model.Strikes;
import com.amaap.cleanstrike.repository.PlayerRepository;
import com.amaap.cleanstrike.service.exception.PlayerNotFoundException;

import java.util.Map;
import java.util.Random;

public class PlayerService {
    PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player create() {
        return playerRepository.add();
    }

    public Player get(int id) throws PlayerNotFoundException {
        Player player = playerRepository.getPlayer(id);
        if (player == null) throw new PlayerNotFoundException("Player with [id:" + id + "] not found");
        return player;
    }

    public void attemptStrike(Player player, CarromBoard carromBoard) {
        Random random = new Random();
        int strike = random.nextInt(1, 6);
        Map<Integer, Strikes> strikes = StrikesConfig.getStrikes();
        int existingPoint = player.getPoints();
        int blackCoins = carromBoard.getNumberOfBlackCoins();
        int redCoins = carromBoard.getNumberOfRedCoins();
        switch (strike) {
            case 1: //Strike
                System.out.println("Strike --> Strike");
                if (blackCoins > 0) {
                    player.setPoints(++existingPoint);
                }
                break;

            case 2:  // Multi Strike
                System.out.println("Strike --> MultiStrike");
                if (blackCoins >= 2) {
                    int noOfCoinsPocketed = random.nextInt(2, blackCoins + 1);
                    player.setPoints(existingPoint + 2);
                    carromBoard.setNumberOfBlackCoins((blackCoins - noOfCoinsPocketed) + 2);
                }
                break;

            case 3: // Defunct coin strike
                System.out.println("Strike --> Defunct coin Strike");
                if (blackCoins > 0) {
                    player.setPoints(existingPoint - 2);
                    carromBoard.setNumberOfBlackCoins(--blackCoins);
                }
                break;

            case 4: // Red Strike
                System.out.println("Strike --> Red Strike");
                if (redCoins > 0) {
                    carromBoard.setNumberOfRedCoins(--redCoins);
                    player.setPoints(existingPoint + 3);
                }
                break;

            case 5: //Striker strike
                System.out.println("Strike --> Striker Strike");
                player.setPoints(--existingPoint);
                break;
        }
    }
}
