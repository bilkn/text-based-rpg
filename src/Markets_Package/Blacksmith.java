package Markets_Package;

import Item_Package.Armor;
import Item_Package.Item;
import Weapons_Package.Weapon;
import Places_Package.AbstractMarkets;
import Places_Package.Town_Marketplace;
import com.company.Human;

import java.util.Arrays;

public class Blacksmith extends AbstractMarkets {
    private final Item[] weaponStorage = new Item[9];
    private final Item[] armorStorage = new Item [9];


    public Blacksmith(String name, int npcCount) {
        super(name, npcCount);
        Weapon weaponList = new Weapon();
        Arrays.fill(weaponStorage,Item.createEmptyItem());
        weaponList.createWeaponList();
        for (int i = 0; i <= weaponList.getWeaponList().size()-1; i++) {

            weaponStorage[i] = weaponList.getWeaponList().get(i);

        }
        Armor armorList = new Armor();
        Arrays.fill(armorStorage,Item.createEmptyItem());
        armorList.createArmorList();
        for (int i = 0; i <= armorList.getArmorList().size()-1; i++) {


            armorStorage [i] = armorList.getArmorList().get(i);
        }


    }
    public Blacksmith() {
        super("Black Smith", 1);
        Weapon weaponList = new Weapon();
        Arrays.fill(weaponStorage,Item.createEmptyItem());
        weaponList.createWeaponList();

        for (int i = 0; i <= weaponList.getWeaponList().size()-1; i++) {

            weaponStorage[i] = weaponList.getWeaponList().get(i);

        }
        Armor armorList = new Armor();
        Arrays.fill(armorStorage,Item.createEmptyItem());
        armorList.createArmorList();
        for (int i = 0; i <= armorList.getArmorList().size()-1; i++) {


            armorStorage [i] = armorList.getArmorList().get(i);
        }


    }


    public void blackSmithMenu(Human human) {
        boolean isBlackSmithMenuOpen = true;

        while (isBlackSmithMenuOpen) {

            System.out.println("1- Buy weapon/sell item \n" +
                    "2- Buy armor/sell item\n" +
                    "3- Go back to the marketplace");

            int blackSmithMenuInput = super.getScanner().nextInt();

            switch (blackSmithMenuInput) {

                case 1:
                    super.setStorage(weaponStorage);
                    super.marketMenu(human);
                    break;
                case 2:
                    super.setStorage(armorStorage);
                    super.marketMenu(human);
                    break;
                case 3:
                    Town_Marketplace townMarketplace = new Town_Marketplace();

                    townMarketplace.marketPlaceMenu(human);
                    isBlackSmithMenuOpen = false;
                    break;
                default:
                    break;


            }
        }


    }

}
