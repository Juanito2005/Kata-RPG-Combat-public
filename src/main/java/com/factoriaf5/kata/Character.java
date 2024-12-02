package com.factoriaf5.kata;

public class Character {
    // se pone "_" para ver de mejor visualizacion numeros grandes
    // y mostrar sus decimales
    private Double health = 1_000.0;
    private Integer level = 1;
    private Boolean alive = true;
    private CharacterType type;
    
    public Character(CharacterType type) {
        this.type = type;

        // Ternario Si este tipo de personaje es igual a Melee, se le asigna 2.0, si no, se
        // le asigna 20.0
        //this.attackRange = (type == CharacterType.MELEE) ? 2.0 : 20.0;
    }
    
    public Double getHealth() {
        return health;
    }

    public void setHealth(Double health) {
        this.health = health;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Boolean getAlive() {
        return alive;
    }

    public void setAlive(Boolean alive) {
        this.alive = alive;
    }
    
    public String attack(Character target, Double damage, Double distance) {
        // sout: te escribe automaticamente el System.out.println
        // System.out.println();
        if (this != target) {
            if (distance > type.getRange()) {
                return "Target is out of range.";
            }

            if ((target.getLevel() - this.getLevel()) >= 5) {
                damage = damage * 0.5;
            } else if ((target.getLevel() - this.getLevel()) <= -5) {
                damage = damage * 1.5;
            }

            if (damage >= target.getHealth()) {
                target.setHealth(0.0);
                target.setAlive(false);
            } else {
                target.setHealth(target.getHealth() - damage);
            }
            return this.type + " have dealt " + damage + " to " + target.type;
        }
        return "A Character cannot Deal Damage to itself.";
    }

    public String heal(Character target, Double heal) {
        if (this == target) {
            if (target.getAlive() == false) {
                return "Character can not be healed";
            } else if ((target.getHealth() + heal) > 1000) {
                return "Healing cannot raise health above 1000";
            } else {
                target.setHealth(target.getHealth() + heal);
            } return "The character has been healed:" + target.getHealth();
        }
        return "A Character can only Heal itself.";
    }

}