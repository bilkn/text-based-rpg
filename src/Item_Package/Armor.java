package Item_Package;

import Armors_Package.*;
import Interfaces.ArmorMethods;
import Weapons_Package.*;
import com.company.Human;

import java.util.ArrayList;

public class Armor extends Item implements ArmorMethods {


    private final ArrayList<Item> armorList;
    private int defencePoint;
    private int durability;


    public Armor(String name, int id, int defencePoint, int durability,int price) {
        super(name, id, price);
        this.defencePoint = defencePoint;
        this.durability = durability;
        armorList = new ArrayList<>();

    }
    public Armor () {

        armorList = new ArrayList<>();
        durability = 0;

    }

    @Override
    public int getDurability() {
        return this.durability;
    }

    @Override
    public void decreaseDurability() {
    this.durability -= this.defencePoint;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }

    public static Armor createArmor(String armorName) {

        switch (armorName) {

            case "None":
                return new NoneArmor();
            case "Leather Tunic":
                return new LeatherTunic();

            case "Chain Armor":
                return new ChainArmor();

            case "Iron Armor":
                return new IronArmor();

            case "Steel Armor":
                return new SteelArmor();

            case "Diamond Armor":
                return new DiamondArmor();

            default:
                break;


        }
        return null;

    }

    public ArrayList<Item> getArmorList() {
        return armorList;
    }

    public int getDefencePoint() {
        return defencePoint;
    }
    public void createArmorList () {

        armorList.add(createArmor("Leather Tunic"));
        armorList.add(createArmor("Chain Armor"));
        armorList.add(createArmor("Iron Armor"));
        armorList.add(createArmor("Steel Armor"));
        armorList.add(createArmor("Diamond Armor"));

    }
    public boolean isArmorBroken () {

        if (this.durability <=0) {
            System.out.println(this.getName() + " is broken!.");
            return true;

        }
        return false;

    }
}
