package com.factoriaf5.kata;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// All the classes are named as "PascalCase"
public class CharacterTest {
    private Character melee;
    private Character ranged;
    @BeforeEach
    public void init() {
        this.melee  = new Character(CharacterType.MELEE);
        this.ranged = new Character(CharacterType.RANGED);
    }

    @Test
    // All the test are named as "camelCase"
    public void characterDoesntAttackItself() {
        assertEquals("A Character cannot Deal Damage to itself.", melee.attack(melee,450.0,2.0));
    }
    @Test
    public void attackTestNormal() {
        melee.attack(ranged,450.0, 2.0);
        assertEquals(550, ranged.getHealth());
    }
    @Test
    public void messageSuccesfulAttack() {
        assertEquals("RANGED have dealt 500.0 to MELEE", ranged.attack(melee, 500.0, 15.0));
    }
    @Test
    public void moreDamagedThanLifeTest() {
        melee.attack(ranged, 1001.0, 2.0);
        assertEquals(0, ranged.getHealth());
        assertFalse(ranged.getAlive());
    }
    @Test
    public void characterLevelDamage50More() {
        melee.setLevel(6);
        melee.attack(ranged, 200.0, 2.0);
        assertEquals(700, ranged.getHealth());
    }
    @Test
    public void characterLevelDamage50Less() {
        ranged.setLevel(6);
        melee.attack(ranged, 200.0, 2.0);
        assertEquals(900, ranged.getHealth());
    }
    @Test
    public void characterHealItself() {
        melee.attack(ranged,450.0, 2.0);
        assertEquals("A Character can only Heal itself.", melee.heal(ranged, 100.0));
    }
    @Test
    public void healDead() {
        melee.attack(ranged,1200.0, 2.0);
        assertEquals("Character can not be healed", ranged.heal(ranged, 500.0));
    }
    @Test
    public void healMaximum() {
        melee.attack(ranged, 1.0, 2.0);
        assertEquals("Healing cannot raise health above 1000", ranged.heal(ranged, 2.0));
    }
    @Test
    public void healNormal() {
        melee.attack(ranged, 200.0, 2.0);
        assertEquals("The character has been healed:" + 900.0, ranged.heal(ranged, 100.0));
    }
}
