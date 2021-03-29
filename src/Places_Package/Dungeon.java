package Places_Package;

import Monsters_Package.Minotaur;
import Monsters_Package.Monster;
import com.company.Human;

public class Dungeon extends MonsterBase {


    public Dungeon(Human human) {
        super("Dungeon",human);


    }



    @Override
    public void monsterBaseMenu(Human human) {
        System.out.println("You are at the dungeon. " +"("+super.getNpcCount() + " enemies)" );
        createMonster(human);
        super.monsterBaseMenu(human);


    }
    public void createMonster (Human human) {


        for (int i = 1; i<= this.getNpcCount(); i++) {

            Minotaur minotaur = new Minotaur(human);

            this.setMonsterList(minotaur);

        }



    }

}
