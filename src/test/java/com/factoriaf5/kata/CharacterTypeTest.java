package com.factoriaf5.kata;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// All the classes are named as "PascalCase"
public class CharacterTypeTest {
    private Character melee;
    private Character ranged;
    @BeforeEach
    public void init() {
        this.melee  = new Character(CharacterType.MELEE);
        this.ranged = new Character(CharacterType.RANGED);
    }
    @Test
    public void meleeRangedTest() {
        assertEquals("Target is out of range.", melee.attack(ranged, 450.0, 3.0));
    }
    @Test
    public void rangedRangeTest() {
        assertEquals("Target is out of range.", ranged.attack(melee, 450.0, 21.0));
    }
}