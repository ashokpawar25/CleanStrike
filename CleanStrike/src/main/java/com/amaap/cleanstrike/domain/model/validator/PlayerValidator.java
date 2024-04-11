package com.amaap.cleanstrike.domain.model.validator;

public class PlayerValidator {
    public static boolean isInvalidId(int id) {
        return id<=0;
    }

    public static boolean isInvalidPoints(int points) {
        return points<0;
    }
}
