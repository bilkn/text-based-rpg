package Places_Package;

import Monsters_Package.Demon;

import com.company.Human;

public class Temple extends MonsterBase {
    public Temple(Human human) {
        super("Temple",human);
    }


    @Override
    public void monsterBaseMenu(Human human) {
        System.out.println("You are at the temple. " +"("+super.getNpcCount() + " enemies)" );
        createMonster(human);
        super.monsterBaseMenu(human);


    }
    public void createMonster (Human human) {


        for (int i = 1; i<= this.getNpcCount(); i++) {

            Demon demon = new Demon(human);

            this.setMonsterList(demon);

        }



    }
}
