package Monsters_Package;

import Item_Package.Armor;
import Weapons_Package.Weapon;
import com.company.Human;

public abstract class Monster extends Human {

    int experiencePoint;

    public Monster(String name, int level, int health, Weapon weapon, Armor armor, int experiencePoint) {
        super(name, level, health, weapon, armor);
        this.experiencePoint = experiencePoint;
    }
    public int getExperiencePoint() {
        return experiencePoint;
    }


    protected static Weapon addWeaponToMonster(Human human) {

        Weapon weapon;
        switch (human.getLevel()) {
            case 1:
                weapon = Weapon.createWeapon("Punch");
                break;
            case 2:
                weapon = Weapon.createWeapon("Knife");
                break;

            case 3:
                weapon = Weapon.createWeapon("Sword");
                break;
            case 4:
                weapon = Weapon.createWeapon("Long Sword");
                break;
            case 5:


            default:

                weapon = Weapon.createWeapon("Hammer");
                break;


        }
        return weapon;

    }

    protected static Armor addArmorToMonster(Human human) {
        Armor armor;
        switch (human.getLevel()) {
            case 1:
                armor = Armor.createArmor("None");
                break;
            case 2:
                armor = Armor.createArmor("Leather Tunic");
                break;

            case 3:
            case 4:
                armor = Armor.createArmor("Chain Armor");
                break;
            case 5:
                armor = Armor.createArmor("Iron Armor");


            default:

                armor = Armor.createArmor("Iron Armor");
                break;


        }
        return armor;


    }

    public boolean isMonsterDied() {

        return this.getHealth() <= 0;
    }


}



