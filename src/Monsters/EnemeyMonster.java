package Monsters;

import Calc.map.Map;

import java.io.Serializable;
import java.util.Random;

public class EnemeyMonster implements Serializable {
    public int x=6;
    public int y=3;
    public int monster_serve_x = 6;
    public int monster_serve_y = 3;
    public String area = "メインマップ";
    public int walk(int ramdomposition){
        Random random =new Random();
        if (random.nextBoolean()){
            ramdomposition++;
        }else {
            ramdomposition--;
        }
        return ramdomposition;
    }
    public void randomNewEnemeyMonster(){
        Random random_new_enemey_monster =new Random();
        Map map =new Map();
        int[] range = map.getRange(this.area);
        int x = random_new_enemey_monster.nextInt(range[0]);
        int y = random_new_enemey_monster.nextInt(range[1]);
        String price =map.getMapCode(x,y,this.area);
        while (price.equals(map.E)){
            x =random_new_enemey_monster.nextInt(range[0]);
            y = random_new_enemey_monster.nextInt(range[1]);
            price =map.getMapCode(x,y,this.area);
        }
        this.x = x;
        this.y = y;
    }
}
