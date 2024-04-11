package com.amaap.cleanstrike.domain.model;

import com.amaap.cleanstrike.domain.model.exception.InvalidPlayerIdException;
import com.amaap.cleanstrike.domain.model.exception.InvalidePlayerPointsException;
import com.amaap.cleanstrike.domain.model.validator.PlayerValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.amaap.cleanstrike.domain.model.validator.PlayerValidator.isInvalidId;
import static com.amaap.cleanstrike.domain.model.validator.PlayerValidator.isInvalidPoints;

public class Player {
    private final int id;
    private int points;
    private List<Strikes> strikes;
    private boolean isAlreadyPlaying;

    public Player(int id, int points) {
        this.id = id;
        this.points = points;
        this.strikes = new ArrayList<>();
        this.isAlreadyPlaying = false;
    }

    public static Player create(int id, int points) throws InvalidPlayerIdException, InvalidePlayerPointsException {
        if(isInvalidId(id)) throw new InvalidPlayerIdException("Invalid player id "+id);
        if(isInvalidPoints(points)) throw new InvalidePlayerPointsException("Points should be greater than 0");
        return new Player(id,points);
    }

    public int getId() {
        return id;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setAlreadyPlaying(boolean alreadyPlaying) {
        isAlreadyPlaying = alreadyPlaying;
    }

    public boolean isAlreadyPlaying() {
        return isAlreadyPlaying;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id == player.id && points == player.points && Objects.equals(strikes, player.strikes);
    }
}
