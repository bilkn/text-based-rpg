package Places_Package;


import Markets_Package.Blacksmith;
import Markets_Package.PotionBrewer;
import com.company.Human;

public class Town_Marketplace extends Place {
    private final Blacksmith blacksmith = new Blacksmith();
    private final PotionBrewer potionBrewer = new PotionBrewer();


    public Town_Marketplace() {

        super("Marketplace", 0);
    }

    public Town_Marketplace(String name, int npcCount) {

        super(name, npcCount);
    }


    public void marketPlaceMenu(Human human) {
        boolean isMarketPlaceMenuOpen = true;
        while (isMarketPlaceMenuOpen) {
            System.out.println("1- Go the blacksmith \n" +
                    "2- Go to the stable\n" +
                    "3- Go to the potion brewer\n" +
                    "4- Go to the merchant\n" +
                    "5- Go back to the town");

            int marketPlaceMenuInput = super.getScanner().nextInt();
            switch (marketPlaceMenuInput) {

                case 1:
                    blacksmith.blackSmithMenu(human);
                    break;

                case 3:
                    potionBrewer.potionBrewerMenu(human);
                    break;
                case 2:
                case 4:
                    System.out.println("Under construction");
                    break;
                case 5:
                    Town town = new Town(human);
                    town.townMenu(human);
                    isMarketPlaceMenuOpen = false;

                    break;
                default:
                    break;

            }
        }

    }

}
