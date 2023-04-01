package Calc;

import java.util.Random;

public class Monster2 {
    public int HP;
    public int MP;
    public int Attack;
    public String name;
    public String seibetu;
    public int leberu;
    public boolean isalive;
    public int judgeSente;

    public Monster2(String name, String sei, int lv, int hp, int attack, int mp, int judgeSente) {
        this.name = name;
        this.seibetu = sei;
        this.leberu = lv;
        this.HP = hp;
        this.Attack = attack;
        this.MP = mp;
        this.isalive = true;
        this.judgeSente = judgeSente;
    }

    public String Name() {
        return this.name;
    }

    public String Seibetu() {
        return this.seibetu;
    }

    public int LV() {
        return this.leberu;
    }

    public String look(Monster2 monster) {
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

    public int[] battle(Monster2 enemiy_monster) {
        int[] enemiy_monster_hp0_mp1=new int[2];
        if (enemiy_monster.HP > 0) {
            System.out.println(this.name+"と"+enemiy_monster.name+"の戦い");
            while (enemiy_monster.isalive && this.isalive) {
                boolean sente = judgeSente(this.judgeSente, enemiy_monster.judgeSente);
                if (sente) {
                    this.MP = enemiy_monster.turn(enemiy_monster);
                    enemiy_monster.MP = this.turn(enemiy_monster);
                    enemiy_monster.alive();
                } else {
                    enemiy_monster.MP = this.turn(enemiy_monster);
                    this.MP = enemiy_monster.turn(this);
                    enemiy_monster.alive();
                }
            }
            enemiy_monster_hp0_mp1[0] = enemiy_monster.HP;
            enemiy_monster_hp0_mp1[1] = enemiy_monster.MP;
            return enemiy_monster_hp0_mp1;
        }else {
            enemiy_monster_hp0_mp1[0] = enemiy_monster.HP;
            enemiy_monster_hp0_mp1[1] = enemiy_monster.MP;
            return enemiy_monster_hp0_mp1;
        }
    }

    public boolean judgeSente(int judgeSenteFirst, int judgeSenteSecond) {
        Random random = new Random(2);
        boolean sente = true;
        if (judgeSenteFirst < judgeSenteSecond) {
            sente = false;
        } else {
            if (judgeSenteFirst == judgeSenteSecond) {
                sente = random.nextBoolean();
            }
        }
        return sente;
    }

    public void alive() {
        if (this.HP<=0) {
            System.out.println(this.name + "を倒した");
        }
    }
}