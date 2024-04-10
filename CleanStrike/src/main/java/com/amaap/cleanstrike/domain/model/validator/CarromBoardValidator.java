package com.amaap.cleanstrike.domain.model.validator;

public class CarromBoardValidator {
    public static boolean isInvalidId(int id) {
        if(id <= 0) return true;
        return false;
    }
}
