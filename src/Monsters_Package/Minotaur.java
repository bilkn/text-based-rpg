package Monsters_Package;

import com.company.Human;

public class Minotaur extends Monster {
    public Minotaur(Human human) {
        super("Minotaur", human.getLevel(), (human.getLevel() * 10) + (100), addWeaponToMonster(human), addArmorToMonster(human), (human.getLevel() * 20) + (100));


    }


}
