package Potion_Package;

import Item_Package.Item;

import java.util.ArrayList;

public  class Potion extends Item {

    private final ArrayList<Item> potionList;

    public Potion(String name, int id, int price) {
        super(name, id, price);
        this.potionList = new ArrayList<>();

    }
    public Potion () {
        this.potionList = new ArrayList<>();




    }

    public static Potion createPotion (String name) {


        switch (name) {

            case "Health Potion":
                return new HealthPotion();




        }
        return null;

    }

    public ArrayList<Item> getPotionList() {
        return potionList;
    }
    public void createPotionList () {

        potionList.add(createPotion("Health Potion"));
    }
}
