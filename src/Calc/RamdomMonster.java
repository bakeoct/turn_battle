package Calc;

import Monsters.*;

import java.util.ArrayList;
import java.util.Random;

public class RamdomMonster {
    public Monster2 randomMonsters(ArrayList<Monster2> monsters){
        Random random_monsters =new Random();
        return monsters.get(random_monsters.nextInt(4));
    }
    public void randomNewEnemeyMonster(EnemeyMonster enemeyMonster){
        Random random_new_enemey_monster =new Random();
        Map map =new Map();
        int[] range = map.getRange(enemeyMonster.area);
        int x = random_new_enemey_monster.nextInt(range[0]);
        int y = random_new_enemey_monster.nextInt(range[1]);
        int number =map.getMapCode(x,y,enemeyMonster.area);
        while (number == map.E){
            x =random_new_enemey_monster.nextInt(range[0]);
            y = random_new_enemey_monster.nextInt(range[1]);
            number =map.getMapCode(x,y,enemeyMonster.area);
        }
            enemeyMonster.position.x = x;
            enemeyMonster.position.y = y;
    }
    public ArrayList<Monster2> initialization(ArrayList<Monster2> monster2s){
        monster2s.set(0,new DragonKing());
        monster2s.set(1,new MetalSlime());
        monster2s.set(2,new PutiSlime());
        monster2s.set(3,new Gorlem());
        return monster2s;
    }
}
