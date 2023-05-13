package Calc;

import Monsters.EnemeyMonster;
import Monsters.Monster2;

import java.util.ArrayList;
import java.util.Random;

public class RamdomMonster {
    public Monster2 randomMonsters(ArrayList<Monster2> monsters){
        Random random_monsters =new Random();
        int random_monster = random_monsters.nextInt(4);
        return monsters.get(random_monster);
    }
    public void randomNewEnemeyMonster(EnemeyMonster enemeyMonster){
        Random random_new_enemey_monster =new Random();
        Map map =new Map();
        int x =random_new_enemey_monster.nextInt(13);
        int y = random_new_enemey_monster.nextInt(13);
        while (map.map[y][x] == map.E){
            x =random_new_enemey_monster.nextInt(13);
            y = random_new_enemey_monster.nextInt(13);
        }
            enemeyMonster.position.x = x;
            enemeyMonster.position.y = y;
    }
}
