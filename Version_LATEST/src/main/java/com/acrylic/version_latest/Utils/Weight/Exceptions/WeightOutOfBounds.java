package com.acrylic.version_latest.Utils.Weight.Exceptions;

public class WeightOutOfBounds extends RuntimeException {

    @Override
    public String toString() {
        return "Weight cannot be less than 0.";
    }
}
