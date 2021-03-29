package Places_Package;

import Item_Package.Empty;
import Item_Package.Item;
import com.company.Human;

import java.util.Arrays;


public abstract class AbstractMarkets extends Place {
    private Item[] storage = new Item[9];


    public AbstractMarkets(String name, int npcCount) {
        super(name, npcCount);


        Arrays.fill(storage, new Empty());


    }


    public void buyMenu(Human human) {

        boolean isBuyMenuOpen = true;

        while (isBuyMenuOpen) {
            showStorage();
            int buyMenuInput = super.getScanner().nextInt();

            if (buyMenuInput == 0) {
                isBuyMenuOpen = false;


            } else if (buyMenuInput < 10) {
                buyMenuInput = buyMenuInput - 1;
                if (!storage[buyMenuInput].getName().equals("Empty")) {
                    Item item = storage[buyMenuInput];

                        if (human.getGold() >= item.getPrice())
                            /* If player's gold is enough to buy the item and player's inventory is not full, player could buy the item.  */ {
                            System.out.println("Are you want to buy " + item.getName() + "?\n" +
                                    "1- Yes " + "(" + item.getPrice() + " GOLD).\n" +
                                    "2- No.");
                            int itemBuyInput = super.getScanner().nextInt();

                            switch (itemBuyInput) {

                                case 1:
                                    human.spendGold(item.getPrice());
                                    if (!human.addItemToInventory(item))  {

                                        System.out.println("Inventory is full.");
                                    }
                                    else {

                                        System.out.println("You bought " + item.getName() + ".");


                                    }
                                    break;

                                case 2:
                                default:
                                    break;


                            }


                        } else {
                            System.out.println("You don't have enough gold.");
                        }
                    }



                }


            }


        }




    public void sellMenu(Human human) {
        boolean isSellMenuOpen = true;

        while (isSellMenuOpen) {
            System.out.println("Your gold is " + human.getGold() +".");
            human.showInventory();
            System.out.println("0- Go back.");
            int sellMenuInput = super.getScanner().nextInt();
            if (sellMenuInput == 0) {
                isSellMenuOpen = false;


            } else if (sellMenuInput < 10) {
                sellMenuInput = sellMenuInput - 1;
                Item item = human.getInventory()[sellMenuInput];
                if (!item.getName().equals("Empty")) {

                    System.out.println("Are you want to sell " + item.getName() + " for " + item.getPrice() / 2 + " GOLD?\n" +
                            "1- Yes.\n" +
                            "2- No."

                    );
                    int itemSellInput = super.getScanner().nextInt();
                    switch (itemSellInput) {

                        case 1:
                            human.addGold(item.getPrice() / 2);
                            System.out.println("You earned " + item.getPrice() / 2 + " gold.");
                            human.removeItemFromInventory(item);

                            break;
                        case 2:

                        default:
                            break;


                    }

                }
            } else {

                System.out.println("Wrong input!");
            }


        }

    }

    public void marketMenu(Human human) {
        boolean isMarketMenuOpen = true;

        while (isMarketMenuOpen) {

            System.out.println("1- Buy \n" +
                    "2- Sell\n" +
                    "3- Go back.");
            int marketMenuInput = super.getScanner().nextInt();
            switch (marketMenuInput) {

                case 1:
                    buyMenu(human);
                    break;
                case 2:
                    sellMenu(human);
                    break;
                case 3:
                    isMarketMenuOpen = false;
                    break;
                default:
                    break;


            }

        }


    }

    public void showStorage() {
        for (int i = 0; i < this.storage.length; i++) {

            if (this.storage[i].getName().equals("Empty"))  {
                System.out.println(i+1 +"- Empty" );


            }
            else {
                System.out.println((i + 1) + "- " + this.storage[i].getName() + " ---> " + this.storage[i].getPrice() + " GOLD.");
            }

        }
        System.out.println("0- Go back.");


    }


    public Item[] getStorage() {
        return storage;
    }

    public void setStorage(Item[] storage) {
        this.storage = storage;
    }
}
