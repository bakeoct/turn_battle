package Calc;

import Calc.Error.Finish;
import Calc.Item.Item;
import Calc.Item.Ladder;
import Calc.Item.Ship;
import Calc.Mission.MissionDragon_king;
import Monsters.Dragon_king;
import Monsters.EnemeyMonster;
import Monsters.Monster2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
//敵を一回倒したらその敵をエラーの場所以外のどこかへ飛ばしまた倒されたら別の場所にまた飛ばす
public class Warks {
    public Position position;
    public Position monsterposition;
    public Scanner scanner;
    public Map map;
    public Dragon_king dragon_king;
    public Person2 p;
    public String point;
    public String item;
    public int servex = 6;
    public int servey = 6;
    public int monsterservex = 6;
    public int monsterservey = 3;
    public String itembox = "宝箱";
    public ArrayList<Item> items;
    public int money;
    public ArrayList<Monster2> monsters;
    public String namae;
    public String seibetu;
    public ArrayList<Item> items_all;
    public MissionDragon_king missionDragon_king;
    public ArrayList<Item> fight_items = new ArrayList<Item>();
    public ArrayList<Monster2> enemy_monsters = new ArrayList<Monster2>();
    public ArrayList<Monster2> monsters2_have_person = new ArrayList<>();
    public EnemeyMonster enemeyMonster = new EnemeyMonster();

    public Warks(ArrayList<Monster2> enemy_monsters, Position position, Position monsterposition, Scanner scanner, Map map, Dragon_king dragon_king, Person2 person2, ArrayList<Item> items, int money, ArrayList<Monster2> monsters, String namae, String seibetu, ArrayList<Item> items_all, MissionDragon_king missionDragon_king, ArrayList<Item> fight_items, ArrayList<Monster2> monsters2_have_person, EnemeyMonster enemeyMonster) {
        this.position = position;
        this.monsterposition = monsterposition;
        this.scanner = scanner;
        this.map = map;
        this.dragon_king = dragon_king;
        this.p = person2;
        this.items = items;
        this.money = money;
        this.monsters = monsters;
        this.namae = namae;
        this.seibetu = seibetu;
        this.items_all = items_all;
        this.missionDragon_king = missionDragon_king;
        this.fight_items = fight_items;
        this.enemy_monsters = enemy_monsters;
        this.monsters2_have_person = monsters2_have_person;
        this.enemeyMonster = enemeyMonster;
    }

    public void warkTurn() throws Finish {
        Store store = new Store(this.money);
        Random random = new Random();
        Ship ship = new Ship();
        RamdomMonster ramdomMonster = new RamdomMonster();
        Ladder ladder = new Ladder();
        System.out.println("人間がいる位置はⅹ座標" + p.position.x + "、Y座標" + p.position.y + "です");
        System.out.println();
        System.out.println("モンスターがいる位置はⅹ座標" + monsterposition.x + "、Y座標" + monsterposition.y + "です");
        System.out.println();
        Monster2 enemeymonster = ramdomMonster.randomMonsters(enemy_monsters);
        while (true) {
            int i = 0;
            while (i == 0) {
                int serveget_map_code = map.getMapCode(p.position.x, p.position.y);
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
                int get_map_code = map.getMapCode(p.position.x, p.position.y);
                if (get_map_code == 1 && !(get_map_code == serveget_map_code)) {
                    point = "崖";
                    item = "梯子";
                    i = notPoint(ladder, servex, servey, i, point, item);
                } else if (get_map_code == 2 && !(get_map_code == serveget_map_code)) {
                    point = "山";
                    item = "梯子";
                    i = notPoint(ladder, servex, servey, i, point, item);
                } else if (get_map_code == 3 && !(get_map_code == serveget_map_code)) {
                    point = "海";
                    item = "船";
                    i = notPoint(ship, servex, servey, i, point, item);
                } else if (get_map_code == 4) {
                    i = openTreasureChest(i, ship, servex, servey);
                } else if (get_map_code == 5) {
                    i = openTreasureChest(i, ladder, servex, servey);
                } else if (get_map_code == 6) {
                    store.shoppingStore(items, monsters, namae, seibetu, items_all, missionDragon_king);
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
                    enemeyMonster.position.x = enemeyMonster.walk(monsterposition.x);
                    monsteri++;
                } else {
                    enemeyMonster.position.y = enemeyMonster.walk(monsterposition.y);
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
            monsterposition = new Position(enemeyMonster.position.x, enemeyMonster.position.y);
            System.out.println("人間がいる位置はⅹ座標" + p.position.x + "、Y座標" + p.position.y + "です");
            System.out.println();
            System.out.println("モンスターがいる位置はⅹ座標" + monsterposition.x + "、Y座標" + monsterposition.y + "です");
            System.out.println();
            if (p.position.x == monsterposition.x && p.position.y == monsterposition.y) {
                System.out.println();
                System.out.println("モンスターと出会った！！");
                if (random.nextBoolean()) {
                    p.battle(enemeymonster, dragon_king, missionDragon_king, fight_items);
                    enemeymonster = ramdomMonster.randomMonsters(enemy_monsters);
                    ramdomMonster.randomNewEnemeyMonster(enemeyMonster);
                    monsterposition = new Position(enemeyMonster.position.x, enemeyMonster.position.y);
                } else {
                    System.out.println("仲間になった！！");
                    monsters2_have_person.add(enemeymonster);
                    System.out.println(enemeymonster.name + "(性別." + enemeymonster.seibetu + ")" + "  レベルは" + enemeymonster.leberu + "です");
                    enemeymonster = ramdomMonster.randomMonsters(enemy_monsters);
                    ramdomMonster.randomNewEnemeyMonster(enemeyMonster);
                    monsterposition = new Position(enemeyMonster.position.x, enemeyMonster.position.y);
                }
            }
        }
    }

    public int notPoint(Item items, int servex, int servey, int i, String point, String item) throws Finish {
        //map.oceanxそれかyの中の数字に該当する数字だった場合tureを返す
        System.out.print("ここには" + point + "があります。　");
        int endflg = 0;
        while (items.have && endflg == 0) {
            System.out.println(item + "を使いますか？ 使う「ture」 使わない「false」");
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
                    this.items.add(item);
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