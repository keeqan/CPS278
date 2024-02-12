package com.battlescene;

public class Character {
    private String name;
    private int health;
    private int strength;
    private FightingPower fightingPower;

    // Default constructor
    public Character() {}

    // Constructor with all fields
    public Character(String name, int health, int strength, FightingPower fightingPower) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.fightingPower = fightingPower;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public FightingPower getFightingPower() {
        return fightingPower;
    }

    public void setFightingPower(FightingPower fightingPower) {
        this.fightingPower = fightingPower;
    }

    public String useFightingPower() {
        return name + " is " + fightingPower.getFightingPowerDesc() + ".";
    }
}