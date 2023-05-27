package Calc;

import Calc.Error.Finish;
import Calc.Item.*;
import Calc.Mission.MissionDragonKing;
import Monsters.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
//敵を一回倒したらその敵をエラーの場所以外のどこかへ飛ばしまた倒されたら別の場所にまた飛ばす
public class Game implements Serializable {
    public SuperSword superSword = new SuperSword();
    public PutiSlimeMerchandise puti_slimeMerchandise = new PutiSlimeMerchandise();
    public DragonKingMerchandise dragonKingMerchandise =new DragonKingMerchandise();
    public MetalSlimeMerchandise metalSlimeMerchandise =new MetalSlimeMerchandise();
    public GorlemMerchandise gorlemMerchandise =new GorlemMerchandise();
    public HealGlass healGlass = new HealGlass();
    public SteelArmor steelArmor = new SteelArmor();
    public Ship ship = new Ship();
    public Ladder ladder = new Ladder();
    public Map map =new Map();
    public Person2 p;
    public String point;
    public int servex = 6;
    public int servey = 6;
    public int monsterservex = 6;
    public int monsterservey = 3;
    public String itembox = "宝箱";
    public ArrayList<Item> items_all = new ArrayList<>();
    public MissionDragonKing missionDragon_king;
    public ArrayList<FightItem> fight_items_all = new ArrayList<FightItem>();
    public ArrayList<MonsterItem> monster_items_all = new ArrayList<MonsterItem>();
    public EnemeyMonster enemeyMonster;
    public ArrayList<Monster2> enemy_monsters;
    public DragonKing dragon_king;

    public Game(Person2 person2, MissionDragonKing missionDragon_king, EnemeyMonster enemeyMonster, ArrayList<Monster2> enemy_monsters, DragonKing dragon_king) {
        this.p = person2;
        this.dragon_king = dragon_king;
        this.missionDragon_king = missionDragon_king;
        this.enemeyMonster = enemeyMonster;
        this.enemy_monsters = enemy_monsters;
        this.items_all.add(ship);
        this.items_all.add(ladder);
        this.items_all.add(puti_slimeMerchandise);
        this.items_all.add(dragonKingMerchandise);
        this.items_all.add(metalSlimeMerchandise);
        this.items_all.add(gorlemMerchandise);
        this.items_all.add(healGlass);
        this.items_all.add(steelArmor);
        this.items_all.add(superSword);
        this.fight_items_all.add(healGlass);
        this.fight_items_all.add(steelArmor);
        this.fight_items_all.add(superSword);
        this.monster_items_all.add(puti_slimeMerchandise);
        this.monster_items_all.add(dragonKingMerchandise);
        this.monster_items_all.add(metalSlimeMerchandise);
        this.monster_items_all.add(puti_slimeMerchandise);
    }

    public void gameTurn() throws Finish {
        Store store = new Store(this.p.money);
        Random random = new Random();
        RamdomMonster ramdomMonster = new RamdomMonster();
        Monster2 enemeymonster = ramdomMonster.randomMonsters(enemy_monsters);
        ArrayList<Monster2> serve_enemey_monster = enemy_monsters;
        System.out.println("人間がいる位置は"+p.area+"でⅹ座標" + p.position.x + "、Y座標" + p.position.y + "です");
        System.out.println();
        System.out.println("モンスターがいる位置は"+enemeyMonster.area+"でⅹ座標" + enemeyMonster.position.x + "、Y座標" + enemeyMonster.position.y + "です");
        System.out.println();
        while (true) {
            int i = 0;
            while (i == 0) {
                int serveget_map_code = map.getMapCode(p.position.x, p.position.y,p.area);
                Scanner scanner =new Scanner(System.in);
                String plice = scanner.next();
                if (plice.equals("a") || plice.equals("d")) {
                    p.position.x = p.walkX(p.position.x, plice);
                    i++;
                } else if (plice.equals("w") || plice.equals("s")) {
                    p.position.y = p.walkY(p.position.y, plice);
                    i++;
                } else if (plice.equals("finish")) {
                    throw new Finish();
                } else {
                    System.out.println("a,w,s,dのどれかを選んでください");
                }
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
                    store.shoppingStore(p.monsters2, items_all, missionDragon_king,p,monster_items_all);
                    p.position.x = servex;
                    p.position.y = servey;
                } else if (get_map_code == 7) {
                    if (p.area.equals("民家1")){
                        System.out.println("人間は"+p.area+"から出て行った");
                        p.position.x = 4;
                        p.position.y = 9;
                    }
                    p.area = "メインマップ";
                } else if (get_map_code == 9) {
                    p.area = "民家1";
                    System.out.println("人間は"+p.area+"へ入った");
                    p.position.x = 4;
                    p.position.y = 7;
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
                    }
                    enemeyMonster.area = "メインマップ";
                }else if (monster_get_map_code == 9){
                    enemeyMonster.area = "民家１";
                    System.out.println("モンスターは"+enemeyMonster.area+"へ入った");
                    enemeyMonster.position.x = 4;
                    enemeyMonster.position.y = 7;
                }
            }
            this.monsterservex = enemeyMonster.position.x;
            this.monsterservey = enemeyMonster.position.y;
            enemeyMonster.position = new Position(enemeyMonster.position.x, enemeyMonster.position.y);
            System.out.println("人間がいる位置は"+p.area+"でⅹ座標" + p.position.x + "、Y座標" + p.position.y + "です");
            System.out.println();
            System.out.println("モンスターがいる位置は"+enemeyMonster.area+"でⅹ座標" + enemeyMonster.position.x + "、Y座標" + enemeyMonster.position.y + "です");
            System.out.println();
            if (p.position.x == enemeyMonster.position.x && p.position.y == enemeyMonster.position.y && p.area.equals(enemeyMonster.area)) {
                System.out.println();
                System.out.println("モンスターと出会った！！");
                p.battle(enemeymonster,dragon_king, missionDragon_king);
                enemy_monsters = ramdomMonster.initialization(enemy_monsters);
                System.out.println("h");
                enemeymonster = ramdomMonster.randomMonsters(enemy_monsters);
                System.out.println("i");
                ramdomMonster.randomNewEnemeyMonster(enemeyMonster);
                System.out.println("j");
                enemeyMonster.position = new Position(enemeyMonster.position.x, enemeyMonster.position.y);
                System.out.println("g");
            }
        }
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