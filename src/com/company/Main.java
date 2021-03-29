package com.company;

import Item_Package.Armor;
import Item_Package.Item;
import Weapons_Package.Weapon;
import Places_Package.Town;


import java.util.Scanner;

//created by Bilkan Konus, Date: 09.06.2020
public class Main {


    private static final Scanner scanner = new Scanner(System.in);
    private static final Item item = new Item();
    public static Human human = new Human("SmochGD");
    public static Armor armor = new Armor();
    public static Weapon weapon = new Weapon();
    public static boolean isTownMenuOpen = true;
    public static Town town = new Town(human);



    public static void main(String[] args) {

          town.townMenu(human);


    }





//    public static void place(Place place) {
//
//
//        boolean isPlaceOpen = true;
//        boolean isFight;
//
//
//        while (isPlaceOpen) {
//
//            System.out.println("You are at the " + place.getPlaceName());
//            System.out.println("1- See enemies\n" +
//                    "2- Show inventory\n" +
//                    "3- Go back to the town");
//
//            int placeInput = scanner.nextInt();
//            switch (placeInput) {
//
//
//                case 1:
//                    for (int i = 0; i < place.getMonsters().size(); i++) {
//
//                        Monster getMonsterStat = place.getMonsters().get(i);
//                        System.out.println("#" + (i + 1) + " enemy [NAME = " + getMonsterStat.getName() + "," +
//                                " LEVEL = " + getMonsterStat.getLevel() + "," +
//                                " HEALTH = " + getMonsterStat.getHitPoint() + "," +
//                                " WEAPON = " + getMonsterStat.getWeapon().getName() + "]");
//
//
//                    }
//
//                    if (place.getMonsters().size() > 0) {
//
//                        System.out.println("Choose enemy");
//
//                        int enemyInput = scanner.nextInt() - 1;
//                        if (enemyInput + 1 > place.getMonsters().size()) {
//
//                            System.out.println("No enemy at number " + (enemyInput + 1) + ".");
//                            break;
//                        }
//
//                        if (place.getMonsters().get(enemyInput) != null && place.getMonsters().size() > 0) {
//
//                            Monster monster = place.getMonsters().get(enemyInput);
//
//                            isFight = true;
//                            while (isFight) {
//                                System.out.println("1- Attack\n" +
//                                        "2- Wait\n" +
//                                        "3- Go back");
//
//                                int attackInput = scanner.nextInt();
//
//                                switch (attackInput) {
//
//
//                                    case 1:
//                                        int criticalDamageMultiplier;
//                                        double criticalStrike = (int) (Math.random() * 100);
//
//                                        if (criticalStrike >= 1 && criticalStrike <= 10) {
//                                            criticalDamageMultiplier = 3;
//
//                                            System.out.println("Critical strike!!");
//
//                                        } else {
//
//                                            criticalDamageMultiplier = 1;
//                                        }
//
//                                        place.getMonsters().get(enemyInput).decreaseHitPoints(human.attack() * criticalDamageMultiplier);
//                                        System.out.println("You use your " + human.getWeapon().getName() + " and gave to " + monster.getName() + " " + human.attack() * criticalDamageMultiplier + " damage.");
//
//                                        int monsterSumAttack = monster.attack() - (human.getArmor().getDefencePoint());
//                                        if (monsterSumAttack < 0) {
//
//                                            monsterSumAttack = 0;
//                                        }
//                                        human.decreaseHitPoints(monsterSumAttack);
//
//
//                                        if (!human.getArmor().getName().equals("none")) {
//                                            human.getArmor().decreaseDurability();
//                                            System.out.println("Your armor health is " + human.getArmor().getDurability() + ".");
//                                        }
//                                        if (!human.getWeapon().getName().equals("punch")) {
//
//
//                                            human.getWeapon().decreaseDurability();
//                                            System.out.println("Your weapon health is " + human.getWeapon().getDurability() + ".");
//
//                                        }
//                                        System.out.println(monster.getName() + " gave " + monsterSumAttack + " damage.");
//                                        System.out.println(monster.getName() + " health is " + monster.getHitPoint() + ".");
//                                        if (human.getArmor().getDurability() <= 0) {
//
//
//                                            human.removeItemFromInventory(human.getArmor());
//                                            human.setArmor(Armor.createArmor("None"));
//                                            System.out.println("Your armor is broken!");
//
//                                        }
//                                        if (human.getWeapon().getDurability() <= 0) {
//                                            human.removeItemFromInventory(human.getWeapon());
//                                            human.setWeapon(Weapon.createWeapon("Punch"));
//                                            System.out.println("Your weapon is broken!");
//
//                                        }
//                                        if (human.getHitPoint() <= 0) {
//
//                                            System.out.println("YOU ARE DEAD!");
//                                            isPlaceOpen = false;
//                                            isFight = false;
//                                            isTownMenuOpen = false;
//                                            break;
//
//                                        } else if (monster.getHitPoint() <= 0) {
//
//                                            int earnedGold = 0;
//                                            int earnedExperience = 0;
//                                            switch (monster.getName()) {
//                                                case "Minotaur": {
//
//
//                                                    earnedGold = monster.getLevel() * 50 + 50;
//
//                                                    earnedExperience = monster.getLevel() * 50 + 150;
//
//                                                    break;
//
//
//                                                }
//
//                                                case "Demon":
//                                                    earnedGold = monster.getLevel() * 50 + 75;
//                                                    earnedExperience = monster.getLevel() * 50 + 200;
//
//
//                                                    break;
//
//
//                                            }
//
//                                            System.out.println("Nice, you killed the " + monster.getName() + " you earned " + earnedGold + " gold and " + earnedExperience + " experience points.");
//                                            place.getMonsters().remove(enemyInput);
//                                            human.addGold(earnedGold);
//                                            human.gainExperience(earnedExperience);
//
//
//                                            if (human.getExperience() >= 1000 * human.getLevel()) {
//                                                human.levelUp(1);
//                                                System.out.println("Level up. Your new level is " + human.getLevel() + ".");
//
//                                            }
//                                            isFight = false;
//
//
//                                        }
//
//
//                                        System.out.println("Your health is " + human.getHitPoint() + ".");
//                                        break;
//
//                                    case 2:
//                                        human.increaseHitPoints(20, human);
//
//                                        break;
//                                    case 3:
//                                        isFight = false;
//                                        break;
//                                    default:
//                                        break;
//
//
//                                }
//
//
//                            }
//                        }
//
//
//                    } else {
//
//                        System.out.println("No enemy is here.");
//                        break;
//
//                    }
//
//
//                    break;
//
//
//                case 2:
//                    boolean isInventoryOpen = true;
//                    while (isInventoryOpen) {
//                        human.showInventory();
//                        System.out.println("0- Go back.");
//                        int inventoryInput = scanner.nextInt();
//                        if (inventoryInput == 0) {
//
//                            isInventoryOpen = false;
//
//
//
//                        }
//                        else {
//                            inventoryInput -=1;
//
//                        }
//
//
//                        Item inventoryIndex = human.getInventory()[inventoryInput];
//
//
//
//
//                            if (!inventoryIndex.getName().equals("Empty")) {
//
//
//                                if (!inventoryIndex.getName().equals("Health potion")) {
//
//                                    boolean isEquipped = false;
//                                    if ((human.getWeapon().getName().equals(inventoryIndex.getName()) || human.getArmor().getName().equals(inventoryIndex.getName()))) {
//
//                                        isEquipped = true;
//                                        System.out.println("1- Dismantle\n" +
//                                                "2- Drop\n" +
//                                                "3- Go back");
//
//                                    }
//                                    else {
//                                        System.out.println("1- Equip\n" +
//                                                "2- Drop\n" +
//                                                "3- Go back");
//                                    }
//                                    int itemInput = scanner.nextInt();
//
//                                    switch (itemInput) {
//
//
//                                        case 1:
//                                            switch (inventoryIndex.getName()) {
//
//                                                case "Knife":
//                                                case "Sword":
//                                                case "Long sword":
//                                                case "Hammer":
//                                                    if (isEquipped) {
//                                                        human.setWeapon(Weapon.createWeapon("Punch"));
//                                                        System.out.println("You dismantled " + inventoryIndex + ".");
//                                                        break;
//                                                    }
//                                                    human.setWeapon(Weapon.createWeapon(inventoryIndex.getName()));
//                                                    System.out.println("You equipped " + inventoryIndex.getName() + ".");
//                                                    break;
//                                                case "leather armor":
//                                                case "chain armor":
//                                                case "iron armor":
//                                                case "steel armor":
//                                                case "diamond armor":
//                                                    if (isEquipped) {
//                                                        human.setArmor(Armor.createArmor("None"));
//                                                        System.out.println("You dismantled " + inventoryIndex.getName() + ".");
//                                                        break;
//                                                    }
//                                                    human.setArmor(Armor.createArmor(inventoryIndex.getName()));
//                                                    System.out.println("You equipped " + inventoryIndex.getName() + ".");
//                                                    break;
//
//                                                default:
//                                                    break;
//
//
//                                            }
//                                            break;
//
//                                        case 2:
//
//                                            System.out.println("You dropped " + inventoryIndex + ".");
//                                            human.removeItemFromInventory(inventoryIndex);
//                                            break;
//
//                                        case 3:
//
//                                        default:
//                                            break;
//                                    }
//
//
//                                } else {
//
//                                    System.out.println("1- Use (50 HP)\n" +
//                                            "2- Drop\n" +
//                                            "3- Go back");
//
//                                    int otherItemInput = scanner.nextInt();
//                                    switch (otherItemInput) {
//
//
//                                        case 1:
//                                            human.increaseHitPoints(50, human);
//                                            human.removeItemFromInventory(inventoryIndex);
//                                            break;
//                                        case 2:
//                                            human.removeItemFromInventory(inventoryIndex);
//                                            break;
//                                        case 3:
//
//                                        default:
//                                            break;
//                                    }
//                                }
//                            }
//
//
//                    }
//                    break;
//
//                case 3:
//                    isPlaceOpen = false;
//                    break;
//                default:
//                    break;
//
//
//            }
//
//
//        }
//
//
//    }
//
//
//
}
