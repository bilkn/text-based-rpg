package Places_Package;

import Item_Package.Armor;
import Monsters_Package.Monster;
import Weapons_Package.Weapon;
import com.company.Human;

import java.util.ArrayList;


public abstract class MonsterBase extends Place {
    private final ArrayList<Monster> monsterList;

    public MonsterBase(String name, Human human) {
        super(name, human.getLevel() * 2);
        monsterList = new ArrayList<>();
    }


    public void setMonsterList(Monster monster) {
        this.monsterList.add(monster);
    }

    public void showEnemyList() {
        for (int i = 0; i < this.monsterList.size(); i++) {

            Monster getMonsterStat = this.monsterList.get(i);
            System.out.println("#" + (i + 1) + " enemy [NAME = " + getMonsterStat.getName() + "," +
                    " LEVEL = " + getMonsterStat.getLevel() + "," +
                    " HEALTH = " + getMonsterStat.getHealth() + "," +
                    " WEAPON = " + getMonsterStat.getWeapon().getName() + "]");


        }


    }

    public void monsterBaseMenu(Human human) {
        boolean isMonsterBaseMenuOpen = true;
        while (isMonsterBaseMenuOpen) {
            System.out.println("1- Show enemies\n" +
                    "2- Show inventory\n" +
                    "3- Go back to the town");

            int monsterBaseMenuInput = super.getScanner().nextInt();

            switch (monsterBaseMenuInput) {

                case 1:

                    showEnemyList();
                    monsterMenu(human);
                    break;
                case 2:
                    human.showInventory();
                    human.chooseItemMenu();
                    break;
                case 3:
                    isMonsterBaseMenuOpen = false;
                    break;
                default:
                    break;


            }

        }
    }

    private void monsterMenu(Human human) {

        int monsterIndex = super.getScanner().nextInt();
        monsterIndex -= 1;


        boolean isFight = true;
        while (isFight) {
            System.out.println("1- Attack.\n" +
                    "2- Wait\n" +
                    "3- Go back.");

            int attackInput = super.getScanner().nextInt();

            switch (attackInput) {

                case 1:
                    if (monsterAttack(human, monsterIndex)) {

                        isFight = false;

                    }

                    break;
                case 2:
                    System.out.println("You are waiting..");
                    break;

                case 3:
                    isFight = false;
                    break;
                default:
                    break;

            }

        }


    }

    //returns true if monster died.
    public boolean monsterAttack(Human human, int monsterIndex) {
        Monster monster = this.monsterList.get(monsterIndex);
        int humanAttackDamage = monster.decreaseHealth(human.attack());
        boolean isMonsterDied = false;


        System.out.println("You use your " + human.getWeapon().getName() + " and gave to " + monster.getName() + " " + humanAttackDamage + " damage.");
        System.out.println(monster.getName() + " health is " + monster.getHealth() + ".");


        if (human.getWeapon().isWeaponBroken()) {
            human.removeItemFromInventory(human.getWeapon());
            human.setWeapon(Weapon.createWeapon("Punch"));


        } else if (!human.getWeapon().getName().equals("Punch")) {


            System.out.println("Your weapon durability is " + human.getWeapon().getDurability() + ".");

        }
        if (monster.isMonsterDied()) {
            int gainedExperience = monster.getExperiencePoint();
            human.gainExperience(gainedExperience);
            monsterList.remove(monsterIndex);

            System.out.println(monster.getName() + " killed. You gained " + gainedExperience + " experience points.");
            human.levelUpControl();
            isMonsterDied = true;


        } else {
            int monsterAttackDamage = human.decreaseHealth(monster.attack());

            System.out.println(monster.getName() + " uses its " + monster.getWeapon().getName() + " and gave " + monsterAttackDamage + " damage.");
            System.out.println("Your health is " + human.getHealth() + ".");


        }
        if (human.getArmor().isArmorBroken()) {

            human.removeItemFromInventory(human.getArmor());
            human.setArmor(Armor.createArmor("None"));
            System.out.println("Your armor is broken!");


        } else if (!human.getArmor().getName().equals("None")) {

            System.out.println("Your armor durability is " + human.getArmor().getDurability() + ".");
        }
       human.isHumanDied();

        return isMonsterDied;
    }


}


