package Calc;

import Monsters.Metal_slime;
import Monsters.Monster2;

import java.util.ArrayList;
import java.util.Random;

public class Person2 {
    public int[] position = new int[2];
    public ArrayList<Monster2> monsters2;
    public String name;
    public String seibetu;

    public Person2(String namae, String seibetu2, ArrayList<Monster2> monsters2) {
        this.name = namae;
        this.monsters2 = monsters2;
        this.seibetu = seibetu2;
        if (this.seibetu.equals("dannsei")) {
            System.out.print(namae + "くんが持っているはモンスターは(モンスター");
            for (Monster2 mons : monsters2) {
                System.out.print("," + mons.name);
            }
            System.out.println(")です");
        }
        if (this.seibetu.equals("josei")) {
            System.out.print(namae + "さんが持っているはモンスターは(モンスター");
            for (Monster2 mons : monsters2) {
                System.out.print("," + mons.name);
            }
            System.out.println(")です");
        }
        if(!(this.seibetu.equals("dannsei") || this.seibetu.equals("josei"))) {
            System.out.println("(josei)または(dannsei)を入力してください。");
        }
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
        if (random.nextInt(2)==0){
            ramdomposition++;
        }else {
            ramdomposition--;
        }
        return ramdomposition;
    }
    public void battle(Monster2 enemeymonster){
        int[] enemey_hp0_mp1 = new int[2];
        enemey_hp0_mp1[0]=enemeymonster.HP;
        int i=0;
        for (Monster2 mons : this.monsters2) {
                enemey_hp0_mp1 = Monster2.battle(enemeymonster,mons);
                enemeymonster.HP = enemey_hp0_mp1[0];
                enemeymonster.MP = enemey_hp0_mp1[1];
            if (enemeymonster.HP<=0){
                System.out.println("勝利した");
                break;
            }
        }
        if (enemeymonster.HP>0){
            System.out.println("負けてしまった");
        }
    }
}
