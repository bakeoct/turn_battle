package Monsters;

import Calc.Error.Finish;
import Calc.Item.FightItem;
import Calc.Person2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public abstract class Monster2 implements Serializable {
    public int HP;
    public int MP;
    public int Attack;
    public String name;
    public String seibetu;
    public int leberu;
    public boolean isalive;
    public int judgeSente;
    public Boolean fellow;
    public int can_get_experince_point;
    public int have_experince_point = 0;
    public int need_experince_point = 0;

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
        if (monster.isalive) {
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
        }
        return 1;
    }

    public static String battle(Monster2 monster1, Monster2 monster2,String what_did,Person2 p) throws Finish {
            System.out.println(monster2.name + "と" + monster1.name + "の戦い");
            if (monster2.isalive) {
                while (monster1.isalive && monster2.isalive) {
                    boolean sente = judgeSente(monster2.judgeSente, monster1.judgeSente);
                    what_did = monster1.chooseDo(what_did,p);
                    if (sente) {
                        monster2.reflectDo(what_did,monster1,p);
                        if(!(what_did.equals("goback"))) {
                            monster2.turn(monster1);
                            monster1.alive();
                        }else {
                            break;
                        }
                    } else {
                        if (!(what_did.equals("goback"))) {
                            monster2.turn(monster1);
                            if (monster2.isalive) {
                                monster2.reflectDo(what_did, monster1, p);
                            }
                            monster1.alive();
                        } else {
                            break;
                        }
                    }
                }
            } else {
                System.out.println("しかし、" + monster2.name + "はすでに死んでいる");
            }
            return what_did;
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
            }
        }
    }
    public void goBackStatus(ArrayList<FightItem> fight_items){
        for (FightItem item : fight_items){
            if (item.itemgroup.equals("attack")){
                this.Attack -= item.upattack;
            }else if (item.itemgroup.equals("armor")){
                this.HP -= item.uphp;
            }
        }
    }
    public String chooseDo(String what_did,Person2 p) throws Finish {
        Scanner scanner =new Scanner(System.in);
        int endflg = 0;
        while (endflg == 0) {
                System.out.println("戦う　[fight]");
                System.out.println("アイテム　[item]");
                System.out.println("逃げる　[goBack]");
                String what_do = scanner.next();
                if (what_do.equals("fight")) {
                    what_did = "fight";
                    endflg++;
                } else if (what_do.equals("item")) {
                    what_did = "item";
                    endflg = useItem(p,endflg);
                } else if (what_do.equals("goBack")) {
                    what_did = "goback";
                    endflg++;
                } else if (what_do.equals("finish")) {
                    throw new Finish();
                } else {
                    System.out.println("選択肢の中から選んでください");
                }
        }
        return what_did;
    }
    public int useItem(Person2 p,int do_flg){
        System.out.println("インベントリ");
        System.out.println();
        Scanner scanner =new Scanner(System.in);
        int endflg = 0;
        while (true) {
            for (FightItem fightItem : p.fight_items) {
                endflg = 1;
                System.out.println(fightItem.name + " " + fightItem.have_point + "個 " + "[" + fightItem.code + "]");
            }
            if (endflg == 0){
                System.out.println("何も持っていないのでアイテムは使えません");
                break;
            }
            System.out.println("戻る [goback]");
            String what_use = scanner.next();
            for (int i=0;i<p.fight_items.size();i++) {
                if (what_use.equals(p.fight_items.get(i).code)) {
                    System.out.println(p.fight_items.get(i).name+"を使った！");
                    endflg = 0;
                    p.choose_item = i;
                }
            }
            if (what_use.equals("goback")){
                break;
            } else if (!(endflg == 0)){
                System.out.println("選択肢から選んでください");
            }else {
                do_flg++;
                break;
            }
        }
        return do_flg;
    }
    public void useItemMath(FightItem fightItem){
        if (fightItem.itemgroup.equals("heal")){
            this.HP += fightItem.heal;
        }
    }
    public void reflectDo(String what_did,Monster2 monster1,Person2 p){
        if (what_did.equals("fight")){
            monster1.turn(this);
        }else {
            if (what_did.equals("item")){
                p.fight_items.get(p.choose_item).have_point--;
                this.useItemMath(p.fight_items.get(p.choose_item));
                if (p.fight_items.get(p.choose_item).have_point == 0){
                    p.fight_items.remove(p.choose_item);
                }
            }
        }
    }
}