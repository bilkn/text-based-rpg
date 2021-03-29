package com.company;


import Item_Package.Armor;
import Item_Package.Empty;
import Item_Package.Item;
import Weapons_Package.Weapon;
import Potion_Package.Potion;
import java.util.Arrays;
import java.util.Scanner;


public class Human {
    private Scanner scanner;
    private String name;
    private int level;
    private int health;
    private Weapon weapon;
    private int gold = 99999;
    private int experience = 0;
    private Item[] inventory;
    private Armor armor;


    public Human(String name) {
        this.name = name;
        this.level = 1;
        this.health = 100;
        this.weapon = Weapon.createWeapon("Punch");
        this.armor = Armor.createArmor("None");
        this.inventory = new Item[9];
        Arrays.fill(inventory, new Empty());
        scanner = new Scanner(System.in);

    }

    public Human(String name, int level, int health, Weapon weapon, Armor armor) {
        this.name = name;
        this.level = level;
        this.health = health;
        this.weapon = weapon;
        this.armor = armor;
    }

    public Human() {

    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public int getGold() {
        return gold;
    }

    public Armor getArmor() {
        return armor;
    }

    public Item[] getInventory() {
        return inventory;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public int attack() {

        decreaseWeaponDurability();


        return this.weapon.getAttackPoint() * criticalStrike();


    }

    public int criticalStrike() {

        int criticalDamageMultiplier;
        double criticalStrike = (int) (Math.random() * 100);

        if (criticalStrike >= 1 && criticalStrike <= 10) {
            criticalDamageMultiplier = 3;

            System.out.println("Critical strike!!");

        } else {

            criticalDamageMultiplier = 1;
        }
        return criticalDamageMultiplier;

    }
    public boolean isMonsterAttackDecreaseTheHealth(int damage) {

        return this.armor.getDefencePoint() >= damage;

    }


    public void addGold(int gold) {


        this.gold += gold;

    }

    public void spendGold(int gold) {


        this.gold -= gold;

    }

    public void increaseHealth(int hitPoint) {


        int maxHealth = 100;
        if (this.health + hitPoint > maxHealth) {

            int additionalHealth = 100 - this.health;


            this.health = 100;

            System.out.println("You gained " + additionalHealth + " HP. " + "Your new health is " + this.health + ".");


        } else {

            this.health += hitPoint;
            System.out.println("You gained " + hitPoint + " HP." + " Your new health is " + this.health);

        }


    }

    public int decreaseHealth(int damage) {


        decreaseArmorDurability();
        if (isMonsterAttackDecreaseTheHealth(damage)) {

            return 0;


        } else {
            int defencePointMinusAttackDamage = (damage - this.armor.getDefencePoint());
            this.health = this.health - defencePointMinusAttackDamage;
            return defencePointMinusAttackDamage;

        }


    }
    public boolean isHumanDied() {

        if (this.health <= 0) {
            System.out.println("YOU ARE DEATH, GAME OVER!!!");

            return true;


        }
        return false;

    }



    public void levelUp(int level) {


        this.level += level;
        System.out.println("Level up! Now your level is " + this.level + ".");
        setExperience(0);

    }

    public void levelUpControl() {

        if (this.experience >= (this.experience + 1000) * this.level) {

            levelUp(1);


        }

    }


    public void gainExperience(int experience) {

        System.out.println("You have gained " + experience + " experience points.");
        this.experience += experience;

    }


    public void setExperience(int experience) {
        this.experience = experience;
    }


    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                        ", level=" + level +
                        ", hitPoint=" + health +
                        ", weapon='" + weapon + '\'' +
                        '}';
    }


    public void showInventory() {


        for (int i = 0; i < this.inventory.length; i++) {

            System.out.println((i + 1) + "- " + this.inventory[i].getName());


        }


    }


    public boolean addItemToInventory(Item item) {

        for (int i = 0; i < inventory.length; i++) {


            if (inventory[i].getName().equals("Empty")) {

                inventory[i] = item;
                return true;
            }


        }
        return false;


    }

    public void removeItemFromInventory(Item item) {

        for (int i = 0; i < inventory.length; i++) {


            if (inventory[i].getName().equals(item.getName())) {

                inventory[i] = Item.createEmptyItem();
                break;
            }

        }


    }

    public void removeItemByIndex(int inventoryIndex) {


        inventory[inventoryIndex] = Item.createEmptyItem();


    }



    public void decreaseWeaponDurability() {


        this.weapon.decreaseDurability();
    }

    public void decreaseArmorDurability() {


        this.armor.decreaseDurability();


    }


    public void chooseItemMenu() {
        System.out.println("0- Go back.");
        boolean isChooseItemMenuOpen = true;
        int itemIndex = scanner.nextInt();
        if (itemIndex == 0) {
            isChooseItemMenuOpen = false;

        } else {
            itemIndex -= 1;
            Item item = getInventory()[itemIndex];

            if (item instanceof Potion) {

                potionMenu(itemIndex);

            } else if (item instanceof Weapon) {

                if (item == this.getWeapon()) {
                    weaponMenuDismantle(itemIndex);


                } else {

                    weaponMenuEquip(itemIndex);
                }


            } else if (item instanceof Armor) {
                if (item == this.getArmor()) {

                    armorMenuDismantle(itemIndex);

                } else {

                    armorMenuEquip(itemIndex);
                }

            }
        }
    }

    public void potionMenu(int itemIndex) {

        boolean isPotionMenuOpen = true;
        while (isPotionMenuOpen) {
            System.out.println("1- Use (50 HP)\n" +
                    "2- Drop\n" +
                    "3- Go back");

            int potionMenuInput = scanner.nextInt();
            switch (potionMenuInput) {

                case 1:
                    increaseHealth(50);
                    removeItemByIndex(itemIndex);
                    break;
                case 2:
                    removeItemByIndex(itemIndex);
                    break;
                case 3:
                    isPotionMenuOpen = false;
                    break;
                default:
                    break;

            }
        }
    }

    public void weaponMenuEquip(int itemIndex) {
        boolean isWeaponMenuOpen = true;
        Weapon weapon = (Weapon) this.inventory[itemIndex];
        while (isWeaponMenuOpen) {
            System.out.println("1- Equip " + "(" + weapon.getAttackPoint() + " DMG).\n" +
                    "2- Drop.\n" +
                    "3- Go back.");
            int weaponMenuInput = scanner.nextInt();

            switch (weaponMenuInput) {

                case 1:
                    this.weapon = weapon;
                    System.out.println("You equipped the " + weapon.getName() + ".");
                    isWeaponMenuOpen = false;
                    break;
                case 2:
                    isWeaponMenuOpen = false;
                    System.out.println("You dropped the " + weapon.getName() + ".");
                    removeItemByIndex(itemIndex);


                    break;
                case 3:
                    isWeaponMenuOpen = false;
                    break;
                default:
                    break;


            }
        }

    }

    public void weaponMenuDismantle(int itemIndex) {

        boolean isWeaponMenuOpen = true;
        Weapon weapon = (Weapon) this.inventory[itemIndex];
        while (isWeaponMenuOpen) {
            System.out.println("1- Dismantle.\n" +
                    "2- Drop.\n" +
                    "3- Go back.");
            int weaponMenuInput = scanner.nextInt();

            switch (weaponMenuInput) {

                case 1:
                    this.weapon = Weapon.createWeapon("Punch");
                    System.out.println("You dismantled the " + weapon.getName() + ".");
                    isWeaponMenuOpen = false;

                    break;

                case 2:
                    System.out.println("You dropped the " + weapon.getName() + ".");
                    removeItemByIndex(itemIndex);
                    isWeaponMenuOpen = false;


                    break;
                case 3:
                    isWeaponMenuOpen = false;
                    break;
                default:
                    break;


            }
        }


    }

    public void armorMenuEquip(int itemIndex) {

        boolean isArmorMenuOpen = true;
        Armor armor = (Armor) this.inventory[itemIndex];
        while (isArmorMenuOpen) {
            System.out.println("1- Equip.\n" +
                    "2- Drop.\n" +
                    "3- Go back.");
            int armorMenuInput = scanner.nextInt();

            switch (armorMenuInput) {

                case 1:
                    this.armor = armor;
                    System.out.println("You equipped the " + armor.getName() + ".");
                    isArmorMenuOpen = false;

                    break;

                case 2:
                    System.out.println("You dropped the " + armor.getName() + ".");
                    removeItemByIndex(itemIndex);
                    isArmorMenuOpen = false;


                    break;
                case 3:
                    isArmorMenuOpen = false;
                    break;
                default:
                    break;


            }
        }


    }

    public void armorMenuDismantle(int itemIndex) {

        boolean isArmorMenuOpen = true;
        Armor armor = (Armor) this.inventory[itemIndex];
        while (isArmorMenuOpen) {
            System.out.println("1- Dismantle.\n" +
                    "2- Drop.\n" +
                    "3- Go back.");
            int armorMenuInput = scanner.nextInt();

            switch (armorMenuInput) {

                case 1:
                    this.armor = Armor.createArmor("None");
                    System.out.println("You dismantled the " + armor.getName() + ".");
                    isArmorMenuOpen = false;

                    break;

                case 2:
                    System.out.println("You dropped the " + armor.getName() + ".");
                    removeItemByIndex(itemIndex);
                    isArmorMenuOpen = false;


                    break;
                case 3:
                    isArmorMenuOpen = false;
                    break;
                default:
                    break;


            }
        }


    }



}
