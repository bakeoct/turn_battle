package Calc;

import Calc.Item.Item;
import Calc.Item.Ladder;
import Calc.Item.Ship;
import Monsters.Metal_slime;
import Monsters.Monster2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Person2 {
    public ArrayList<Monster2> monsters2;
    public ArrayList<Item> items;
    public String name;
    public String seibetu;
    public int x=0;
    public int y=0;
    public Position position =new Position(x,y);
    public Ladder ladder =new Ladder();
    public Ship ship =new Ship();
    public Person2(String namae, String seibetu2, ArrayList<Monster2> monsters2,ArrayList<Item> items) {
        this.name = namae;
        this.monsters2 = monsters2;
        this.items = items;
        this.seibetu = seibetu2;
        if (this.seibetu.equals("dannsei")) {
            System.out.print(namae + "くんが持っているはモンスターは(モンスター");
            for (Monster2 mons : monsters2) {
                System.out.print("," + mons.name);
            }
            System.out.println(")です");
            for (Item item : items){
                System.out.println("そして、"+namae+"君は"+item.name+"を持っています");
            }
        }
        if (this.seibetu.equals("josei")) {
            System.out.print(namae + "さんが持っているはモンスターは(モンスター");
            for (Monster2 mons : monsters2) {
                System.out.print("," + mons.name);
            }
            System.out.println(")です");
            if (ladder.have){
                System.out.println("そして、"+namae+"君は"+ladder.name+"を持っています");
            }else {
                System.out.println("そして、"+namae+"君は梯子を持っていません");
            }
        }
        if(!(this.seibetu.equals("dannsei") || this.seibetu.equals("josei"))) {
            System.out.println("(josei)または(dannsei)を入力してください。");
        }
    }
    public int walkx(int ramdomposition,String plice){
        if (plice.equals("d")){
            ramdomposition++;
        }else {
            if (plice.equals("a")) {
                ramdomposition--;
            }
        }
        return ramdomposition;
    }
    public int walky(int ramdomposition,String plice){
        if (plice.equals("w")){
            ramdomposition++;
        }else {
            if (plice.equals("s")) {
                ramdomposition--;
            }
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
