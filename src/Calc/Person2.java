package Calc;

import java.util.ArrayList;

public class Person2 {
    public int position;
    public ArrayList<Monster2> monsters2;
    public String name;
    public String seibetu;
    public Monster2 has_monster1;
    public Monster2 has_monster2;

    public Person2(String namae,String seibetu2,ArrayList<Monster2> monsters2,Monster2 hasmonster1,Monster2 hasmonster2){
        this.position=0;
        this.name=namae;
        this.monsters2=monsters2;
        this.seibetu=seibetu2;
        this.has_monster1=hasmonster1;
        this.has_monster2=hasmonster2;
        if (this.seibetu.equals("dannsei")){
            System.out.print(namae+"くんのモンスター("+this.has_monster1.name+","+this.has_monster2.name+")が戦っているのは");
        }
        if (this.seibetu.equals("josei")){
            System.out.print(namae+"さんのモンスターが("+this.has_monster1.name+","+this.has_monster2.name+")戦っているのは");
        }
        if (!(this.seibetu.equals("dannsei") || this.seibetu.equals("josei"))){
            System.out.println("(josei)または(dannsei)を入力してください。");
        }
    }
    public int walk(){
        this.position++;
        return this.position;
    }
    public void battle(Monster2 enemeymonster){
        int[] enemey_hp0_mp1 = new int[2];
        enemey_hp0_mp1[0]=enemeymonster.HP;
        int i=0;
        while (enemey_hp0_mp1[0]>0 && i<3) {
            if (i == 0) {
                enemey_hp0_mp1 = this.has_monster1.battle(enemeymonster);
                enemeymonster.HP = enemey_hp0_mp1[0];
                enemeymonster.MP = enemey_hp0_mp1[1];
            }
            if (i == 1) {
                enemey_hp0_mp1 = this.has_monster2.battle(enemeymonster);
            }
            if (i == 2) {
                System.out.println("負けてしまった");
            }
            i++;
        }
    }
}
