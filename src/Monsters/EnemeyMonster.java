package Monsters;

import Calc.Position;

import java.util.Random;

public class EnemeyMonster {
    public int x=6;
    public int y=3;
    public Position position =new Position(x,y);
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
