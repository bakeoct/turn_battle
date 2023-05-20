package Calc;

import Calc.Error.Finish;
import Calc.Item.*;
import Calc.Mission.MissionDragon_king;
import Calc.save.SaveLoadManager;
import Monsters.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
//敵を一回倒したらその敵をエラーの場所以外のどこかへ飛ばしまた倒されたら別の場所にまた飛ばす
public class Game implements Serializable {
    public SuperSword superSword =new SuperSword();
    public Puti_slimemerchandise puti_slimemerchandise =new Puti_slimemerchandise();
    public HealGlass healGlass =new HealGlass();
    public SteelArmor steelArmor =new SteelArmor();
    public Ship ship =new Ship();
    public Ladder ladder =new Ladder();
    public Map map;
    public Person2 p;
    public String point;
    public int servex = 6;
    public int servey = 6;
    public int monsterservex = 6;
    public int monsterservey = 3;
    public String itembox = "宝箱";
    public ArrayList<Item> items_all=new ArrayList<Item>();
    public MissionDragon_king missionDragon_king;
    public ArrayList<FightItem> fight_items_all = new ArrayList<FightItem>();
    public ArrayList<MonsterItem> monster_items_all =new ArrayList<MonsterItem>();
    public ArrayList<Monster2> monsters2_have_person = new ArrayList<Monster2>();
    public EnemeyMonster enemeyMonster = new EnemeyMonster();
    public ArrayList<Monster2> enemy_monsters = new ArrayList<Monster2>();
    public Dragon_king dragon_king =new Dragon_king();

    public Game(Map map, Person2 person2, MissionDragon_king missionDragon_king, EnemeyMonster enemeyMonster,ArrayList<Monster2> enemy_monsters,Dragon_king dragon_king) {
        this.map = map;
        this.p = person2;
        this.dragon_king = dragon_king;
        this.missionDragon_king = missionDragon_king;
        this.enemeyMonster = enemeyMonster;
        this.enemy_monsters = enemy_monsters;
        this.items_all.add(ship);
        this.items_all.add(ladder);
        this. items_all.add(puti_slimemerchandise);
        this.items_all.add(healGlass);
        this.items_all.add(steelArmor);
        this.items_all.add(superSword);
        this.fight_items_all.add(healGlass);
        this.fight_items_all.add(steelArmor);
        this.fight_items_all.add(superSword);
        this.monster_items_all.add(puti_slimemerchandise);
    }

    public void gameTurn() throws Finish {
        Store store = new Store(this.p.money);
        Random random = new Random();
        Ship ship = new Ship();
        RamdomMonster ramdomMonster = new RamdomMonster();
        Ladder ladder = new Ladder();
        System.out.println("人間がいる位置はⅹ座標" + p.position.x + "、Y座標" + p.position.y + "です");
        System.out.println();
        System.out.println("モンスターがいる位置はⅹ座標" + enemeyMonster.position.x + "、Y座標" + enemeyMonster.position.y + "です");
        System.out.println();
        Monster2 enemeymonster = ramdomMonster.randomMonsters(enemy_monsters);
        while (true) {
            int i = 0;
            while (i == 0) {
                int serveget_map_code = map.getMapCode(p.position.x, p.position.y);
                Scanner scanner =new Scanner(System.in);
                String plice = scanner.next();
                if (plice.equals("a") || plice.equals("d")) {
                    p.position.x = p.walkX(p.position.x, plice);
                    i++;
                } else if (plice.equals("w") || plice.equals("s")) {
                    p.position.y = p.walkY(p.position.y, plice);
                    i++;
                } else if (plice.equals("fini")) {
                    SaveLoadManager sl = new SaveLoadManager();
                    System.out.println("saveします。");
                    sl.save(this);
                } else {
                    System.out.println("a,w,s,dのどれかを選んでください");
                }
                //これをmapに送って二つメソッド動かす
                int get_map_code = map.getMapCode(p.position.x, p.position.y);
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
                    store.shoppingStore(p.monsters2, items_all, missionDragon_king,p,monster_items_all);
                    p.position.x = servex;
                    p.position.y = servey;
                } else if (get_map_code == -1) {
                    System.out.println("画面外なので、再度選んでください");
                    i--;
                    p.position.x = servex;
                    p.position.y = servey;
                }
            }
            this.servex = p.position.x;
            this.servey = p.position.y;
            p.position = new Position(p.position.x, p.position.y);
            int monsteri = 0;
            while (monsteri == 0) {
                if (random.nextBoolean()) {
                    enemeyMonster.position.x = enemeyMonster.walk(enemeyMonster.position.x);
                    monsteri++;
                } else {
                    enemeyMonster.position.y = enemeyMonster.walk(enemeyMonster.position.y);
                    monsteri++;
                }
                int monster_get_map_code = map.getMapCode(enemeyMonster.position.x, enemeyMonster.position.y);
                if (monster_get_map_code == -1) {
                    monsteri--;
                    enemeyMonster.position.x = monsterservex;
                    enemeyMonster.position.y = monsterservey;
                }
            }
            this.monsterservex = enemeyMonster.position.x;
            this.monsterservey = enemeyMonster.position.y;
            enemeyMonster.position = new Position(enemeyMonster.position.x, enemeyMonster.position.y);
            System.out.println("人間がいる位置はⅹ座標" + p.position.x + "、Y座標" + p.position.y + "です");
            System.out.println();
            System.out.println("モンスターがいる位置はⅹ座標" + enemeyMonster.position.x + "、Y座標" + enemeyMonster.position.y + "です");
            System.out.println();
            if (p.position.x == enemeyMonster.position.x && p.position.y == enemeyMonster.position.y) {
                System.out.println();
                System.out.println("モンスターと出会った！！");
                if (random.nextBoolean()) {
                    p.battle(enemeymonster, dragon_king, missionDragon_king);
                    enemeymonster = ramdomMonster.randomMonsters(enemy_monsters);
                    ramdomMonster.randomNewEnemeyMonster(enemeyMonster);
                    enemeyMonster.position = new Position(enemeyMonster.position.x, enemeyMonster.position.y);
                } else {
                    System.out.println("仲間になった！！");
                    monsters2_have_person.add(enemeymonster);
                    System.out.println(enemeymonster.name + "(性別." + enemeymonster.seibetu + ")" + "  レベルは" + enemeymonster.leberu + "です");
                    enemeymonster = ramdomMonster.randomMonsters(enemy_monsters);
                    ramdomMonster.randomNewEnemeyMonster(enemeyMonster);
                    enemeyMonster.position = new Position(enemeyMonster.position.x, enemeyMonster.position.y);
                }
            }
        }
    }

    public int notPoint(Item item, int servex, int servey, int i, String point) throws Finish {
        //map.oceanxそれかyの中の数字に該当する数字だった場合tureを返す
        System.out.print("ここには" + point + "があります。　");
        int endflg = 0;
        Scanner scanner =new Scanner(System.in);
        while (item.have && endflg == 0) {
            System.out.println(item.name + "を使いますか？ 使う「ture」 使わない「false」");
            if (scanner.next().equals("ture")) {
                System.out.println(item + "を使った！");
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
    public int openTreasureChest(int i,Item item,int servex,int servey) throws Finish{
        int endflg = 0;
        Scanner scanner =new Scanner(System.in);
        while (endflg == 0) {
            System.out.println("これは"+itembox+"を開けますか？ 開ける「ture」 開けない「false」");
            if (scanner.next().equals("ture")) {
                if (item.havenumber>=1){
                    System.out.println(itembox+"はすでに空っぽだ。再度選んでください");
                    i--;
                    endflg++;
                }else {
                    System.out.println(itembox+"を開けた！,"+item.name+"を手に入れた");
                    item.havenumber++;
                    item.have=true;
                    if (item.itemsclass == "fightitem"){
                        this.p.fight_items.add((FightItem) item);
                    }else if (item.itemsclass == "fielditem"){
                        this.p.field_items.add((FieldItem) item);
                    }else if (item.itemsclass == "monsteritem"){
                        this.p.monster_items.add((MonsterItem) item);
                    }
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