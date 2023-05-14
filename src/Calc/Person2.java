package Calc;

import Calc.Error.Finish;
import Calc.Item.*;
import Calc.Mission.Mission;
import Calc.Mission.MissionDragon_king;
import Calc.Mission.MissionSab;
import Monsters.Dragon_king;
import Monsters.EnemeyMonster;
import Monsters.Metal_slime;
import Monsters.Monster2;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Person2 {
    public int LV=1;
    public ArrayList<Monster2> monsters2;
    public ArrayList<FieldItem> field_items =new ArrayList<FieldItem>();
    public ArrayList<MonsterItem> monster_items =new ArrayList<MonsterItem>();
    public ArrayList<FightItem> fight_items =new ArrayList<FightItem>();
    public String name;
    public String seibetu;
    public int money=100;
    public int x=6;
    public int y=6;
    public Position position =new Position(x,y);
    public Ladder ladder =new Ladder();
    public Ship ship =new Ship();
    public Person2(String namae, String seibetu2, ArrayList<Monster2> monsters2, int personkey) throws Finish {
        this.name = namae;
        this.monsters2 = monsters2;
        this.seibetu = seibetu2;
        if (personkey==1) {
            if (this.seibetu.equals("dannsei")) {
                System.out.print(namae + "くんが持っているはモンスターは(モンスター");
                for (Monster2 mons : monsters2) {
                    System.out.print("," + mons.name);
                }
                System.out.println(")です");
                for (FightItem fight_item : fight_items) {
                    System.out.println("そして、" + namae + "君は" + fight_item.name + "を持っています");
                }
                for (MonsterItem monster_item : monster_items){
                    System.out.println("そして、" + namae + "君は" + monster_item.name + "を持っています");
                }
                for (FieldItem field_item : field_items){
                    System.out.println("そして、" + namae + "君は" + field_item.name + "を持っています");
                }
            }
            if (this.seibetu.equals("josei")) {
                System.out.print(namae + "さんが持っているはモンスターは(モンスター");
                for (Monster2 mons : monsters2) {
                    System.out.print("," + mons.name);
                }
                System.out.println(")です");
                for (FightItem fight_item : fight_items) {
                    System.out.println("そして、" + namae + "君は" + fight_item.name + "を持っています");
                }
                for (MonsterItem monster_item : monster_items){
                    System.out.println("そして、" + namae + "君は" + monster_item.name + "を持っています");
                }
                for (FieldItem field_item : field_items){
                    System.out.println("そして、" + namae + "君は" + field_item.name + "を持っています");
                }
            }
            if (this.seibetu.equals("finish")) {
                throw new Finish();
            }
            if (!(this.seibetu.equals("dannsei") || this.seibetu.equals("josei"))) {
                System.out.println("(josei)または(dannsei)を入力してください。");
            }
        }
    }
    public int walkX(int ramdomposition,String plice){
        if (plice.equals("d")){
            ramdomposition++;
        }else if (plice.equals("a")) {
               ramdomposition--;
        }
        return ramdomposition;
    }
    public int walkY(int ramdomposition,String plice){
        if (plice.equals("w")){
            ramdomposition++;
        }else if (plice.equals("s")) {
            ramdomposition--;
        }
        return ramdomposition;
    }
    public void battle(Monster2 enemeymonster, Dragon_king dragon_king, MissionDragon_king missionDragon_king){
        MissionSab missionSab =new MissionSab();
        int win_flg =0;
        int[] enemey_hp0_mp1 = new int[2];
        for (Monster2 mons : this.monsters2) {
            mons.itemsStatus(this.fight_items);
            enemey_hp0_mp1 = Monster2.battle(enemeymonster,mons);
            enemeymonster.HP = enemey_hp0_mp1[0];
            enemeymonster.MP = enemey_hp0_mp1[1];
            if (enemeymonster.HP<=0){
                System.out.println("勝利した");
                win_flg++;
                if (enemeymonster == dragon_king && missionDragon_king.progress){
                    missionSab.missionProgres(missionDragon_king);
                    System.out.println(missionDragon_king.name+"を達成した！");
                    System.out.println("お店で報酬をもらおう！");
                }
                break;
            }
        }
        if (win_flg == 0){
            System.out.println("負けてしまった");
        }
    }
}
