package Calc;

import Calc.map.Map;
import Monsters.*;
import java.util.ArrayList;
import java.util.Random;

public class RamdomMonster {
    public void randomNewEnemeyMonster(EnemeyMonster enemeyMonster){
        Random random_new_enemey_monster =new Random();
        Map map =new Map();
        int[] range = map.getRange(enemeyMonster.area);
        int x = random_new_enemey_monster.nextInt(range[0]);
        int y = random_new_enemey_monster.nextInt(range[1]);
        String price =map.getMapCode(x,y,enemeyMonster.area);
        while (price.equals(map.E)){
            x =random_new_enemey_monster.nextInt(range[0]);
            y = random_new_enemey_monster.nextInt(range[1]);
            price =map.getMapCode(x,y,enemeyMonster.area);
        }
            enemeyMonster.x = x;
            enemeyMonster.y = y;
    }

    public Monster2 getMonsterRandomly() {
        Random random = new Random();
        ArrayList<Monster2> monster2List = new ArrayList<>();
        monster2List.add(new DragonKing());
        monster2List.add(new MetalSlime());
        monster2List.add(new PutiSlime());
        monster2List.add(new Gorlem());
        //0~3 no random na value get
        int randomNum = random.nextInt(monster2List.size());
        return monster2List.get(randomNum);
    }
}
