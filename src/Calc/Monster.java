package Calc;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Random;

public class Monster {
    public int HP;
    public int MP;
    public int Attack;
    public String name;
    public String seibetu;
    public int leberu;
    public boolean isalive;
    public int judgeSente;

    public Monster(String name, String sei, int lv, int hp, int attack, int mp,int judgeSente) {
        this.name = name;
        this.seibetu = sei;
        this.leberu = lv;
        this.HP = hp;
        this.Attack = attack;
        this.MP = mp;
        this.isalive= true;
        this.judgeSente=judgeSente;
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

    public String look(Monster monster) {
        return monster.name;
    }

    public int attack(Monster hpmonster) {
        if (hpmonster.HP - this.Attack <= 0) {
            return 0;

        } else {
            return hpmonster.HP - this.Attack;
        }
    }

    public int turn(Monster monster) {
        if (!(monster.isalive)) {
            return monster.MP;
        }
            if (monster.MP >= 10) {
                this.HP = monster.attack(this);
                monster.MP = monster.MP-10;
                System.out.println(monster.name + "の攻撃　　ドーン！！　" + this.name + "の体力が" + this.HP + "になった。　　" + monster.name + "のMPが10下がって" + monster.MP + "になった");
            } else {
                System.out.println(monster.name + "の攻撃　　しかしMPが足りなかった");
            }
            if (this.HP == 0) {
                this.isalive=false;
                System.out.println(this.name + "は死んでしまった");
            }
        return monster.MP;
    }
        public void battle (Monster enemiy_monster){
            while (enemiy_monster.isalive && this.isalive) {
                boolean sente=judgeSente(this.judgeSente, enemiy_monster.judgeSente);
                if (sente) {
                    this.MP = enemiy_monster.turn(this);
                    enemiy_monster.MP = this.turn(enemiy_monster);
                }else {
                    enemiy_monster.MP = this.turn(enemiy_monster);
                    this.MP = enemiy_monster.turn(this);
                }
            }
    }
    public boolean judgeSente(int judgeSentef,int judgeSentes){
        Random random =new Random(2);
        boolean sente=true;
        if (judgeSentef<judgeSentes){
            sente=false;
        }else {
            if (judgeSentef==judgeSentes){
                sente= random.nextBoolean();
            }
        }
        return sente;
    }
}
