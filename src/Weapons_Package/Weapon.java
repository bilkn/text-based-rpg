package Weapons_Package;

import Interfaces.WeaponMethods;
import Item_Package.Item;

import java.util.ArrayList;


public class Weapon extends Item implements WeaponMethods {


    private final ArrayList<Item> weaponList = new ArrayList<>();
    private final int attackPoint;
    private int durability;

    public Weapon(String name, int id, int attackPoint, int durability, int price) {
        super(name, id, price);
        this.attackPoint = attackPoint;
        this.durability = durability;


    }

    public Weapon() {
        this.attackPoint = 0;


    }

    public ArrayList<Item> getWeaponList() {
        return weaponList;
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }

    @Override
    public int getAttackPoint() {
        return this.attackPoint;
    }

    @Override
    public int getDurability() {
        return this.durability;
    }

    @Override
    public void decreaseDurability() {


        this.durability -= this.attackPoint;
    }


    public static Weapon createWeapon(String weaponName) {

        switch (weaponName) {

            case "Punch":
                return new Punch();
            case "Knife":
                return new Knife();

            case "Sword":
                return new Sword();

            case "Long Sword":
                return new LongSword();

            case "Hammer":
                return new Hammer();

            default:
                break;


        }
        return null;

    }

    public void createWeaponList() {

        weaponList.add(createWeapon("Knife"));
        weaponList.add(createWeapon("Sword"));
        weaponList.add(createWeapon("Long Sword"));
        weaponList.add(createWeapon("Hammer"));

    }


    public boolean isWeaponBroken() {

        if (this.durability <= 0) {
            System.out.println(this.getName() + " is broken!.");
            return true;

        }
        return false;

    }


}
