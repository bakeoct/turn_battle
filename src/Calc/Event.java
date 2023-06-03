package Calc;

import Calc.Error.Finish;
import Calc.Item.*;
import Calc.Mission.Mission;
import Calc.Mission.MissionDragonKing;
import Monsters.EnemeyMonster;
import Monsters.Monster2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Event implements Serializable{
    public Person2 p;
    public String itembox = "宝箱";
    public Map map;
    public String point = null;
    public Ladder ladder;
    public Ship ship;
    public MissionDragonKing missionDragonKing;
    public EnemeyMonster enemeyMonster;
    public Event(Person2 p, Map map, Ladder ladder, Ship ship, MissionDragonKing missionDragonKing, EnemeyMonster enemeyMonster){
        this.p = p;
        this.map = map;
        this.ladder = ladder;
        this.ship = ship;
        this.missionDragonKing = missionDragonKing;
        this.enemeyMonster = enemeyMonster;
    }
    public int eventPerson(int serveget_map_code, int i, int servex, int servey, Store store, ArrayList<Item> items_all,ArrayList<MonsterItem> monster_items_all) throws Finish {
        //これをmapに送って二つメソッド動かす
        int get_map_code = map.getMapCode(p.position.x, p.position.y,p.area);
        if (get_map_code == 1 && !(get_map_code == serveget_map_code)) {
            point = "崖";
            i = notPoint(ladder, servex, servey, i, point);
        } else if (get_map_code == 2 && !(get_map_code == serveget_map_code)) {
            point = "山";
            i = notPoint(ladder, servex, servey, i, point);
        } else if (get_map_code == 3 && !(get_map_code == serveget_map_code)) {
            point = "海";
            i = notPoint(ship, servex, servey, i, point);
        } else if (get_map_code == 4) {
            i = openTreasureChest(i, ship, servex, servey);
        } else if (get_map_code == 5) {
            i = openTreasureChest(i, ladder, servex, servey);
        } else if (get_map_code == 6) {
            store.shoppingStore(p.monsters2, items_all, missionDragonKing,p,monster_items_all);
            for (Monster2 monster : p.monsters2) {
                System.out.println(monster.name);
            }
            p.position.x = servex;
            p.position.y = servey;
        } else if (get_map_code == 7) {
            if (p.area.equals("民家1")){
                System.out.println("人間は"+p.area+"から出て行った");
                p.position.x = 4;
                p.position.y = 9;
            }else if (p.area.equals("洞窟1")){
                System.out.println("人間は"+p.area+"から出て行った");
                p.position.x = 11;
                p.position.y = 8;
            }
            p.area = "メインマップ";
        } else if (get_map_code == 9) {
            p.area = "民家1";
            System.out.println("人間は"+p.area+"へ入った");
            p.position.x = 4;
            p.position.y = 7;
        }else if (get_map_code == 11) {
            p.area = "洞窟1";
            System.out.println("人間は"+p.area+"へ入った");
            p.position.x = 2;
            p.position.y = 7;
        } else if (get_map_code == 12) {
            p.area = "洞窟1_1";
            System.out.println("人間は"+p.area+"へ入った");
            p.position.x = 2;
            p.position.y = 7;
        } else if (get_map_code == 13) {
            if (p.area.equals("洞窟1_1")){
                System.out.println("人間は"+p.area+"から出て行った");
                p.position.x = 2;
                p.position.y = 1;
            }
            p.area = "洞窟1";
        } else if (get_map_code == -1) {
            System.out.println("画面外なので、再度選んでください");
            i--;
            p.position.x = servex;
            p.position.y = servey;
        }
        return i;
    }
    public int eventMonster(int monsteri, int monsterservex, int monsterservey){
        int monster_get_map_code = map.getMapCode(enemeyMonster.position.x, enemeyMonster.position.y,enemeyMonster.area);
        if (monster_get_map_code == -1) {
            monsteri--;
            enemeyMonster.position.x = monsterservex;
            enemeyMonster.position.y = monsterservey;
        }else if (monster_get_map_code == 7){
            if (enemeyMonster.area.equals("民家1")){
                System.out.println("モンスターは"+enemeyMonster.area+"から出て行った");
                enemeyMonster.position.x = 4;
                enemeyMonster.position.y = 9;
            }else if (enemeyMonster.area.equals("洞窟1")){
                System.out.println("モンスターは"+p.area+"から出て行った");
                p.position.x = 11;
                p.position.y = 8;
            }
            enemeyMonster.area = "メインマップ";
        }else if (monster_get_map_code == 9){
            enemeyMonster.area = "民家1";
            System.out.println("モンスターは"+enemeyMonster.area+"へ入った");
            enemeyMonster.position.x = 4;
            enemeyMonster.position.y = 7;
        }else if (monster_get_map_code == 11) {
            enemeyMonster.area = "洞窟1";
            System.out.println("モンスターは"+enemeyMonster.area+"へ入った");
            enemeyMonster.position.x = 2;
            enemeyMonster.position.y = 7;
        } else if (monster_get_map_code == 12) {
            enemeyMonster.area = "洞窟1_1";
            System.out.println("モンスターは"+enemeyMonster.area+"へ入った");
            enemeyMonster.position.x = 2;
            enemeyMonster.position.y = 7;
        } else if (monster_get_map_code == 13) {
            if (enemeyMonster.area.equals("洞窟1_1")){
                System.out.println("モンスターは"+enemeyMonster.area+"から出て行った");
                enemeyMonster.position.x = 2;
                enemeyMonster.position.y = 1;
            }
            enemeyMonster.area = "洞窟1";
        }
        return monsteri;
    }
    public int notPoint(Item item, int servex, int servey, int i, String point) throws Finish {
        Scanner scanner = new Scanner(System.in);
        //map.oceanxそれかyの中の数字に該当する数字だった場合tureを返す
        System.out.print("ここには" + point + "があります。　");
        int endflg = 0;
        while (item.have && endflg == 0) {
            System.out.println(item.name + "を使いますか？ 使う「ture」 使わない「false」");
            if (scanner.next().equals("ture")) {
                System.out.println(item.name + "を使った！");
                endflg++;
            } else if (scanner.next().equals("false")) {
                System.out.println("再度選んでください");
                p.position.x = servex;
                p.position.y = servey;
                i--;
                endflg++;
            } else if (scanner.next().equals("finish")) {
                throw new Finish();
            } else {
                System.out.println("tureかfalseを選んでください");
            }
        }
        if (endflg == 0) {
            System.out.println("再度選んでください");
            p.position.x = servex;
            p.position.y = servey;
            i--;
        }
        return i;
    }

    public int openTreasureChest(int i, Item item, int servex, int servey) throws Finish {
        Scanner scanner = new Scanner(System.in);
        int endflg = 0;
        while (endflg == 0) {
            System.out.println("これは" + itembox + "を開けますか？ 開ける「ture」 開けない「false」");
            if (scanner.next().equals("ture")) {
                if (item.havenumber >= 1) {
                    System.out.println(itembox + "はすでに空っぽだ。再度選んでください");
                    i--;
                    endflg++;
                } else {
                    System.out.println(itembox + "を開けた！," + item.name + "を手に入れた");
                    item.havenumber++;
                    item.have = true;
                    item.have_point++;
                    if (item.itemsclass.equals("fightitem")) {
                        this.p.fight_items.add((FightItem) item);
                    } else if (item.itemsclass.equals("fielditem")) {
                        this.p.field_items.add((FieldItem) item);
                    } else if (item.itemsclass.equals("monsteritem")) {
                        this.p.monster_items.add((MonsterItem) item);
                    }
                    p.items.add(item);
                    endflg++;
                }
            } else if (scanner.next().equals("false")) {
                System.out.println("再度選んでください");
                i--;
                endflg++;
            } else if (scanner.next().equals("finish")) {
                throw new Finish();
            } else {
                System.out.println("tureかfalseを選んでください");
            }
        }
        p.position.x = servex;
        p.position.y = servey;
        return i;
    }
}
