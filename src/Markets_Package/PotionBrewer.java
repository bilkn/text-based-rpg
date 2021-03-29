package Markets_Package;

import Item_Package.Item;
import Places_Package.AbstractMarkets;
import Places_Package.Town_Marketplace;
import Potion_Package.Potion;
import com.company.Human;

import java.util.ArrayList;
import java.util.Arrays;

public class PotionBrewer extends AbstractMarkets {

    private Item [] potionStorage = new Item[9];
    public PotionBrewer(String name, int npcCount) {
        super(name, npcCount);

        Potion potionList = new Potion();
        Arrays.fill(potionStorage,Item.createEmptyItem());
        potionList.createPotionList();
        for (int i = 0;i<=potionList.getPotionList().size()-1; i++ ) {
            potionStorage [i] = potionList.getPotionList().get(i);


        }

    }
    public PotionBrewer() {
        super("Potion Brewer", 1);
        Potion potionList = new Potion();
        Arrays.fill(potionStorage,Item.createEmptyItem());
        potionList.createPotionList();
        for (int i = 0;i<=potionList.getPotionList().size()-1; i++ ) {
            potionStorage [i] = potionList.getPotionList().get(i);


        }

    }
    public void potionBrewerMenu(Human human) {
        boolean isPotionBrewerMenuOpen = true;

        while (isPotionBrewerMenuOpen) {

            System.out.println("1- Buy/sell potion. \n" +
                    "2- Go back to the marketplace.");


            int potionBrewerMenuInput = super.getScanner().nextInt();

            switch (potionBrewerMenuInput) {

                case 1:
                    super.setStorage(potionStorage);
                    super.marketMenu(human);
                    break;

                case 2:
                    Town_Marketplace townMarketplace = new Town_Marketplace();

                    townMarketplace.marketPlaceMenu(human);
                    isPotionBrewerMenuOpen = false;
                    break;
                default:
                    break;


            }
        }


    }

}
