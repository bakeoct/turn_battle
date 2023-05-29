package Calc;

import Calc.Error.Finish;
import Calc.Item.*;
import Calc.Mission.MissionDragonKing;
import Calc.Mission.MissionSab;
import Monsters.*;

import java.io.Serializable;
import java.util.ArrayList;

public class Person2 implements Serializable {
    public Level level =new Level();
    public ArrayList<Monster2> monsters2 =new ArrayList<Monster2>();
    public int LV=1;
    public int have_experince_point = 0;
    public int need_experince_point = 100;
    public ArrayList<FieldItem> field_items =new ArrayList<FieldItem>();
    public ArrayList<MonsterItem> monster_items =new ArrayList<MonsterItem>();
    public ArrayList<FightItem> fight_items =new ArrayList<FightItem>();
    public ArrayList<Item> items =new ArrayList<>();
    public String name;
    public String seibetu;
    public int money=100;
    public String area = "メインマップ";
    public int x=6;
    public int y=6;
    public Position position =new Position(x,y);
    public Ladder ladder =new Ladder();
    public Ship ship =new Ship();
    public Person2(String namae, String seibetu2, MetalSlime metal_slime, Gorlem gorlem) throws Finish {
        this.name = namae;
        this.seibetu = seibetu2;
        this.monsters2.add(metal_slime);
        this.monsters2.add(gorlem);
        for (Item item : field_items){
            items.add(item);
        }
        for (Item item : fight_items){
            items.add(item);
        }
        for (Item item : monster_items){
            items.add(item);
        }
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
    public void battle(Monster2 enemeymonster, DragonKing dragon_king, MissionDragonKing missionDragon_king){
        MissionSab missionSab =new MissionSab();
        int serve_hp = enemeymonster.HP;
        int serve_mp = enemeymonster.MP;
        int win_flg =0;
        int[] enemey_hp0_mp1;
        System.out.println(this.monsters2.get(0).name);
        System.out.println("f");
        for (Monster2 mons : this.monsters2) {
            System.out.println("1");
            mons.itemsStatus(this.fight_items);
            //enemy_monsterの中のすべての情報を初期化する
            System.out.println(enemeymonster.HP);
            System.out.println(enemeymonster.isalive);
            enemey_hp0_mp1 = Monster2.battle(enemeymonster,mons);
            mons.goBackStatus(this.fight_items);
            enemeymonster.HP = enemey_hp0_mp1[0];
            enemeymonster.MP = enemey_hp0_mp1[1];
            if (enemeymonster.HP<=0){
                for (Monster2 monsters : this.monsters2) {
                    monsters.have_experince_point += enemeymonster.can_get_experince_point;
                }
                this.have_experince_point += enemeymonster.can_get_experince_point;
                level.upLevel(this);
                System.out.println("勝利した");
                enemeymonster.HP = serve_hp;
                enemeymonster.MP = serve_mp;
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
