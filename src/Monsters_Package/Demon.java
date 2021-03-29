package Monsters_Package;

import com.company.Human;

public class Demon extends Monster {
    public Demon(Human human) {
        super("Demon", human.getLevel(), (human.getLevel() * 20) + 100, addWeaponToMonster(human), addArmorToMonster(human), (human.getLevel() * 20) + (100));
        ;
    }
}
