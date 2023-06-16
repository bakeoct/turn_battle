package Monsters;

import java.io.Serializable;
import java.util.Random;

public class EnemeyMonster implements Serializable {
    public int x=6;
    public int y=3;
    public int monsterservex = 6;
    public int monsterservey = 3;
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
}
