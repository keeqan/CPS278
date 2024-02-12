package com.battlescene;

public class Battle {
    private Character character1;
    private Character character2;
    private BattleGround battleground;

    // Default constructor
    public Battle() {}

    // Constructor with all fields
    public Battle(Character character1, Character character2, BattleGround battleground) {
        this.character1 = character1;
        this.character2 = character2;
        this.battleground = battleground;
    }

    // Getters and setters
    public Character getCharacter1() {
        return character1;
    }

    public void setCharacter1(Character character1) {
        this.character1 = character1;
    }

    public Character getCharacter2() {
        return character2;
    }

    public void setCharacter2(Character character2) {
        this.character2 = character2;
    }

    public BattleGround getBattleground() {
        return battleground;
    }

    public void setBattleground(BattleGround battleground) {
        this.battleground = battleground;
    }

   // Other methods for battle logic
   public void fight() {
    String battlegroundDesc = battleground.getBattleGroundDesc();
    System.out.println("Location ~~~~  " + battlegroundDesc + ", " + character1.getName() + " and " + character2.getName() + " are fighting.");
    
    while (character1.getHealth() > 0 && character2.getHealth() > 0) {
        int damageByCharacter1 = character1.getStrength() + character1.getFightingPower().usePower();
        int damageByCharacter2 = character2.getStrength() + character2.getFightingPower().usePower();

        character2.setHealth(character2.getHealth() - damageByCharacter1);
        character1.setHealth(character1.getHealth() - damageByCharacter2);

        System.out.println(character1.getName() + " attacks " + character2.getName() + " with " + damageByCharacter1 + " damage. " + character2.getName() + " has " + character2.getHealth() + " health remaining.");
        System.out.println(character2.getName() + " counterattacks " + character1.getName() + " with " + damageByCharacter2 + " damage. " + character1.getName() + " has " + character1.getHealth() + " health remaining.");
    }

    if (character1.getHealth() <= 0 && character2.getHealth() <= 0) {
        System.out.println("It's a draw!");
    } else if (character1.getHealth() <= 0) {
        System.out.println(character2.getName() + " wins the battle!");
    } else {
        System.out.println(character1.getName() + " wins the battle!");
    }
}
}