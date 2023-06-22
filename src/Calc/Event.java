package Calc;

import Calc.Error.Finish;
import Calc.Item.*;
import Calc.Mission.MissionDragonKing;
import Calc.map.Cave1;
import Calc.map.Cave1_1;
import Calc.map.Map;
import Calc.map.PersonHome1;
import Monsters.EnemeyMonster;
import Monsters.Monster2;
import java.io.File;
import java.io.Serializable;
import java.util.Scanner;
import static Calc.Sound.*;

public class Event implements Serializable{
    public Person2 p;
    public String itembox;
    public Map map;
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
    public int eventPerson(String serveget_map_code, int i, int servex, int servey, Store store) throws Finish {
        //これをmapに送って二つメソッド動かす
        String get_map_code = map.getMapCode(p.x, p.y,p.area);
        if (get_map_code.equals("崖")) {
            if (!(get_map_code.equals(serveget_map_code))) {
                i = notPoint(ladder, servex, servey, i, get_map_code,ON_GRAVEL_AUDIO);
            }else {
                startAudio(ON_GRAVEL_AUDIO);
            }
        } else if (get_map_code.equals("山")) {
            if (!(get_map_code.equals(serveget_map_code))) {
                i = notPoint(ladder, servex, servey, i, get_map_code,ON_FALLEN_LEAVES_AUDIO);
            }else {
                startAudio(ON_FALLEN_LEAVES_AUDIO);
            }
        } else if (get_map_code .equals("海")) {
            if (!(get_map_code.equals(serveget_map_code))) {
                //notPointにもしたのサウンドを出すのを入れる。
                //notPointのtureをおすと、の場所で押すが選択されたときにの場所にサウンドを入れる。
                i = notPoint(ship, servex, servey, i, get_map_code,IN_SEA_AUDIO);
            }else {
                startAudio(IN_SEA_AUDIO);
            }
        } else if (get_map_code .equals("treasure_chest_ship")) {
            itembox ="宝箱";
            i = openTreasureChest(i, ship, servex, servey,OPEN_TREASURE_CHEST_AUDIO);
        } else if (get_map_code .equals("treasure_chest_ladder")) {
            itembox ="宝箱";
            i = openTreasureChest(i, ladder, servex, servey,OPEN_TREASURE_CHEST_AUDIO);
        } else if (get_map_code .equals("store")) {
            store.shoppingStore(p);
            for (Monster2 monster : p.monsters2) {
                System.out.println(monster.name);
            }
            p.x = servex;
            p.y = servey;
        } else if (get_map_code.equals("back_world")) {
            if (p.area.equals("民家1")){
                startAudio(OPEN_DOOR_AUDIO);
                p.x = PersonHome1.BACK_MAIN_WORLD_INITIAL_X;
                p.y = PersonHome1.BACK_MAIN_WORLD_INITIAL_Y;
            }else if (p.area.equals("洞窟1")){
                startAudio(ON_STONE_AUDIO);
                p.x = Cave1.BACK_MAIN_WORLD_INITIAL_X;
                p.y = Cave1.BACK_MAIN_WORLD_INITIAL_Y;
            }
            System.out.println("人間は"+p.area+"から出て行った");
            p.area = "メインマップ";
        } else if (get_map_code .equals("people_home_1")) {
            p.area = "民家1";
            System.out.println("人間は"+p.area+"へ入った");
            startAudio(OPEN_DOOR_AUDIO);
            p.x = PersonHome1.INITIAL_X;
            p.y = 7;
        }else if (get_map_code .equals("cave1")) {
            p.area = "洞窟1";
            System.out.println("人間は"+p.area+"へ入った");
            startAudio(ON_STONE_AUDIO);
            p.x = Cave1.INITIAL_X;
            p.y = Cave1.INITIAL_Y;
        } else if (get_map_code .equals("cave1_1")) {
            p.area = "洞窟1_1";
            System.out.println("人間は"+p.area+"へ入った");
            startAudio(ON_STONE_AUDIO);
            p.x = Cave1_1.INITIAL_X;
            p.y = Cave1_1.INITIAL_Y;
        } else if (get_map_code .equals("back_cave_1")) {
            if (p.area.equals("洞窟1_1")){
                startAudio(ON_STONE_AUDIO);
                p.x = Cave1_1.BACK_CAVE1_INITIAL_X;
                p.y = Cave1_1.BACK_CAVE1_INITIAL_Y;
            }
            System.out.println("人間は"+p.area+"から出て行った");
            p.area = "洞窟1";
        } else if (get_map_code.equals("glass")) {
            startAudio(ON_GLASS_AUDIO);
        } else if (get_map_code.equals("stone")) {
            startAudio(ON_STONE_AUDIO);
        } else if (get_map_code.equals("wood")) {
            startAudio(ON_WOOD_AUDIO);
        }  else if (get_map_code .equals("errer")) {
            System.out.println("画面外なので、再度選んでください");
            i--;
            p.x = servex;
            p.y = servey;
        }
        return i;
    }
    public int eventMonster(int monsteri, int monsterservex, int monsterservey){
        String monster_get_map_code = map.getMapCode(enemeyMonster.x, enemeyMonster.y,enemeyMonster.area);
        if (monster_get_map_code.equals("errer")) {
            monsteri--;
            enemeyMonster.x = monsterservex;
            enemeyMonster.y = monsterservey;
        }else if (monster_get_map_code.equals("back_world")){
            if (enemeyMonster.area.equals("民家1")){
                enemeyMonster.x = PersonHome1.BACK_MAIN_WORLD_INITIAL_X;
                enemeyMonster.y = PersonHome1.BACK_MAIN_WORLD_INITIAL_Y;
            }else if (enemeyMonster.area.equals("洞窟1")){
                p.x = Cave1.BACK_MAIN_WORLD_INITIAL_X;
                p.y = Cave1.BACK_MAIN_WORLD_INITIAL_Y;
            }
            System.out.println("モンスターは"+enemeyMonster.area+"から出て行った");
            enemeyMonster.area = "メインマップ";
        }else if (monster_get_map_code.equals("people_home_1")){
            enemeyMonster.area = "民家1";
            System.out.println("モンスターは"+enemeyMonster.area+"へ入った");
            enemeyMonster.x = PersonHome1.INITIAL_X;
            enemeyMonster.y = PersonHome1.INITIAL_Y;
        }else if (monster_get_map_code.equals("cave1")) {
            enemeyMonster.area = "洞窟1";
            System.out.println("モンスターは"+enemeyMonster.area+"へ入った");
            enemeyMonster.x = Cave1.INITIAL_X;
            enemeyMonster.y = Cave1.INITIAL_Y;
        } else if (monster_get_map_code.equals("cave1_1")) {
            enemeyMonster.area = "洞窟1_1";
            System.out.println("モンスターは"+enemeyMonster.area+"へ入った");
            enemeyMonster.x = Cave1_1.INITIAL_X;
            enemeyMonster.y = Cave1_1.INITIAL_Y;
        } else if (monster_get_map_code.equals("back_cave_1")) {
            if (enemeyMonster.area.equals("洞窟1_1")){
                enemeyMonster.x = Cave1_1.BACK_CAVE1_INITIAL_X;
                enemeyMonster.y = Cave1_1.BACK_CAVE1_INITIAL_Y;
            }
            System.out.println("モンスターは"+enemeyMonster.area+"から出て行った");
            enemeyMonster.area = "洞窟1";
        }
        return monsteri;
    }
    public int notPoint(Item item, int servex, int servey, int i, String point,File audio_file) throws Finish {
        Scanner scanner = new Scanner(System.in);
        //map.oceanxそれかyの中の数字に該当する数字だった場合tureを返す
        System.out.print("ここには" + point + "があります。　");
        int endflg = 0;
        while (item.have && endflg == 0) {
            System.out.println(item.name + "を使いますか？ 使う「ture」 使わない「false」");
            if (scanner.next().equals("ture")) {
                System.out.println(item.name + "を使った！");
                startAudio(audio_file);
                endflg++;
            } else if (scanner.next().equals("false")) {
                System.out.println("再度選んでください");
                p.x = servex;
                p.y = servey;
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
            p.x = servex;
            p.y = servey;
            i--;
        }
        return i;
    }

    public int openTreasureChest(int i, Item item, int servex, int servey,File audio_file) throws Finish {
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
                    startAudio(audio_file);
                    if (item instanceof FightItem) {
                        this.p.fight_items.add((FightItem) item);
                    } else if (item instanceof FieldItem) {
                        this.p.field_items.add((FieldItem) item);
                    } else {
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
        p.x = servex;
        p.y = servey;
        return i;
    }
}