package com.amaap.cleanstrike.domain.model;

import java.util.List;
import java.util.Objects;

public class Player {
    private final int id;
    private int points;
    private List<Strikes> strikes;

    public Player(int id, int points, List<Strikes> strikes) {
        this.id = id;
        this.points = points;
        this.strikes = strikes;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id == player.id && points == player.points && Objects.equals(strikes, player.strikes);
    }
}
