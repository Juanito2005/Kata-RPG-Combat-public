package com.factoriaf5.kata;

public enum CharacterType {
    MELEE(2.0),
    RANGED(20.0);
    
    private final Double range;

    private CharacterType(Double range) {
        this.range = range;
    }

    public Double getRange() {
        return range;
    }
}
