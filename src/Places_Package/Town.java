package Places_Package;

import com.company.Human;

public class Town extends Place {
    public Town(Human human) {
        super("Hunterville", human.getLevel());
    }

    public void townMenu(Human human) {
        boolean isTownMenuOpen = true;

        while (isTownMenuOpen) {

            System.out.println("1- Go to the dungeon\n" +
                    "2- Go to the temple\n" +
                    "3- Go to the marketplace\n" +
                    "4- Exit the game");
            int townMenuInput = super.getScanner().nextInt();


            switch (townMenuInput) {


                case 1:
                    Dungeon dungeon = new Dungeon(human);
                    dungeon.monsterBaseMenu(human);
                    break;


                case 2:
                    Temple temple = new Temple(human);
                    temple.monsterBaseMenu(human);
                    break;

                case 3:
                    Town_Marketplace marketplace = new Town_Marketplace();
                    marketplace.marketPlaceMenu(human);

                case 4:
                    isTownMenuOpen = false;
                default:
                    break;


            }


        }


    }
}
