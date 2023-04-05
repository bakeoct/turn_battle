package Monsters;

import Calc.Person2;

import java.util.Random;

public class Dragon_king extends Monster2{
    public Dragon_king() {
        this.HP=200000000;
        this.MP=200;
        this.judgeSente=7000;
        this.name="竜王";
        this.Attack=300000000;
        this.seibetu="男性";
        this.leberu=1;
        this.isalive=true;
        this.fellow=false;
    }
    public int[] walk(){
        int x=0;
        int y=0;
        x=Ramdomwalk(x);
        y=Ramdomwalk(y);
        this.position[0]=x;
        this.position[1]=y;
        return this.position;
    }
    public int Ramdomwalk(int ramdomposition){
        Random random =new Random();
        if (random.nextInt(2)<=0){
            ramdomposition++;
        }else {
            ramdomposition--;
        }
        return ramdomposition;
    }
    public static int[] battle(Monster2 monster1,Monster2 monster2) {
        return Monster2.battle(monster1,monster2);
    }
    public static String look(Monster2 monster){
        return monster.name;
    }
    public Boolean change(){
        return this.fellow=true;
    }
}
