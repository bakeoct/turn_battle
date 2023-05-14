package Monsters;

import Calc.Item.FightItem;
import Calc.Item.Item;
import Calc.Position;

import java.util.ArrayList;
import java.util.Random;

public abstract class Monster2 {
    public int HP;
    public int MP;
    public int Attack;
    public String name;
    public String seibetu;
    public int leberu;
    public boolean isalive;
    public int judgeSente;
    public Boolean fellow;


    public String Name() {
        return this.name;
    }

    public String Seibetu() {
        return this.seibetu;
    }

    public int LV() {
        return this.leberu;
    }

    public static String look(Monster2 monster) {
        return monster.name;
    }

    public int attack(Monster2 hpmonster) {
        if (hpmonster.HP - this.Attack <= 0) {
            return 0;

        } else {
            return hpmonster.HP - this.Attack;
        }
    }

    public int turn(Monster2 monster) {
        if (!(monster.isalive)) {
            return monster.MP;
        }
        if (monster.MP >= 10) {
            this.HP = monster.attack(this);
            monster.MP = monster.MP - 10;
            System.out.println(monster.name + "の攻撃　　ドーン！！　" + this.name + "の体力が" + this.HP + "になった。　　" + monster.name + "のMPが10下がって" + monster.MP + "になった");
        } else {
            System.out.println(monster.name + "の攻撃　　しかしMPが足りなかった");
        }
        if (this.HP == 0) {
            this.isalive = false;
            System.out.println(this.name + "は死んでしまった");
        }
        return monster.MP;
    }
    public static int[] battle(Monster2 monster1, Monster2 monster2) {
        int[] monster1_hp0_mp1=new int[2];
        if (monster1.isalive) {
            System.out.println(monster2.name+"と"+monster1.name+"の戦い");
            if (monster2.isalive) {
                while (monster1.isalive && monster2.isalive) {
                    boolean sente = judgeSente(monster2.judgeSente, monster1.judgeSente);
                    if (sente) {
                        monster2.MP = monster1.turn(monster2);
                        monster1.MP = monster2.turn(monster1);
                        monster1.alive();
                    } else {
                        monster1.MP = monster2.turn(monster1);
                        monster2.MP = monster1.turn(monster2);
                        monster1.alive();
                    }
                }
                monster1_hp0_mp1[0] = monster1.HP;
                monster1_hp0_mp1[1] = monster1.MP;
                return monster1_hp0_mp1;
            }else {
                System.out.println("しかし、"+monster2.name+"はすでに死んでいる");
                monster1_hp0_mp1[0] = monster1.HP;
                monster1_hp0_mp1[1] = monster1.MP;
                return monster1_hp0_mp1;
            }
        }else {
            monster1_hp0_mp1[0] = monster1.HP;
            monster1_hp0_mp1[1] = monster1.MP;
            return monster1_hp0_mp1;
        }
    }

    public static boolean judgeSente(int judgeSenteFirst, int judgeSenteSecond) {
        Random random = new Random(2);
        boolean sente = true;
        if (judgeSenteFirst < judgeSenteSecond) {
            sente = false;
        } else if (judgeSenteFirst == judgeSenteSecond) {
            sente = random.nextBoolean();
        }
        return sente;
    }

    public void alive() {
        if (this.HP<=0) {
            System.out.println(this.name + "を倒した");
        }
    }
    public void itemsStatus(ArrayList<FightItem> fight_items){
        for (FightItem item : fight_items){
            if (item.itemgroup.equals("attack")){
                this.Attack += item.upattack;
            }else if (item.itemgroup.equals("armor")){
                this.HP += item.uphp;
            }else if (item.itemgroup.equals("heal")){
                this.HP += item.heal;
            }
        }
    }
}