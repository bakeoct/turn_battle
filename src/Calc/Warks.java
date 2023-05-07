package Calc;

import Calc.Item.Item;
import Calc.Item.Ladder;
import Calc.Item.Ship;
import Calc.Mission.MissionDragon_king;
import Monsters.Dragon_king;
import Monsters.Monster2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
//宝箱のマップを追加
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
    public int monsterservey = 1;
    public String itembox = "宝箱";
    public ArrayList<Item> items;
    public int money;
    public ArrayList<Monster2> monsters;
    public String namae;
    public String seibetu;
    public ArrayList<Item> items_all;
    public MissionDragon_king missionDragon_king;
    public Warks(Position position, Position monsterposition, Scanner scanner, Map map, Dragon_king dragon_king, Person2 person2, ArrayList<Item> items, int money, ArrayList<Monster2> monsters,String namae,String seibetu,ArrayList<Item> items_all,MissionDragon_king missionDragon_king){
        this.position = position;
        this.monsterposition = monsterposition;
        this.scanner = scanner;
        this.map =map;
        this.dragon_king = dragon_king;
        this.p = person2;
        this.items = items;
        this.money = money;
        this.monsters = monsters;
        this.namae = namae;
        this.seibetu = seibetu;
        this.items_all = items_all;
        this.missionDragon_king = missionDragon_king;
    }

    public void warkTurn() {
        Warks warks =new Warks(position,monsterposition,scanner,map,dragon_king,p,items,money,monsters,namae,seibetu,items_all,missionDragon_king);
        Store store =new Store(this.money);
        Random random = new Random();
        Ship ship = new Ship();
        Ladder ladder = new Ladder();
        System.out.println("人間がいる位置はⅹ座標" + p.position.x + "、Y座標" + p.position.y + "です");
        System.out.println();
        System.out.println("モンスターがいる位置はⅹ座標" + monsterposition.x + "、Y座標" + monsterposition.y + "です");
        System.out.println();
        while (!(p.position.x == monsterposition.x) || !(p.position.y == monsterposition.y)) {
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
                } else {
                    System.out.println("a,w,s,dのどれかを選んでください");
                }
                //これをmapに送って二つメソッド動かす
                int get_map_code = map.getMapCode(p.position.x, p.position.y);
                if (get_map_code == 1 && !(get_map_code == serveget_map_code)) {
                    point = "崖";
                    item = "梯子";
                    i = warks.notPoint(ladder, servex, servey, i, point, item);
                } else if (get_map_code == 2 && !(get_map_code == serveget_map_code)) {
                    point = "山";
                    item = "梯子";
                    i = warks.notPoint(ladder, servex, servey, i, point, item);
                } else if (get_map_code == 3 && !(get_map_code == serveget_map_code)) {
                    point = "海";
                    item = "船";
                    i = warks.notPoint(ship, servex, servey, i, point, item);
                } else if (get_map_code == 4) {
                    i = warks.openTreasureChest(i, ship, servex, servey);
                } else if (get_map_code == 5) {
                    i = warks.openTreasureChest(i, ladder, servex, servey);
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
                    dragon_king.position.x = dragon_king.walk(monsterposition.x);
                    monsteri++;
                } else {
                    dragon_king.position.y = dragon_king.walk(monsterposition.y);
                    monsteri++;
                }
                int monster_get_map_code = map.getMapCode(dragon_king.position.x, dragon_king.position.y);
                if (monster_get_map_code == -1) {
                    monsteri--;
                    dragon_king.position.x = monsterservex;
                    dragon_king.position.y = monsterservey;
                }
            }
            this.monsterservex = dragon_king.position.x;
            this.monsterservey = dragon_king.position.y;
            monsterposition = new Position(dragon_king.position.x, dragon_king.position.y);
            System.out.println("人間がいる位置はⅹ座標" + p.position.x + "、Y座標" + p.position.y + "です");
            System.out.println();
            System.out.println("モンスターがいる位置はⅹ座標" + monsterposition.x + "、Y座標" + monsterposition.y + "です");
            System.out.println();
        }
    }
    public int notPoint(Item items,int servex,int servey,int i,String point,String item){
        //map.oceanxそれかyの中の数字に該当する数字だった場合tureを返す
        System.out.print("ここには"+point+"があります。　");
        int endflg = 0;
        while (items.have && endflg == 0) {
            System.out.println(item+"を使いますか？ 使う「ture」 使わない「false」");
            if (scanner.next().equals("ture")) {
                System.out.println(item+"を使った！");
                endflg++;
            } else if (scanner.next().equals("false")) {
                System.out.println("再度選んでください");
                p.position.x = servex;
                p.position.y = servey;
                i--;
                endflg++;
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
    public int openTreasureChest(int i,Item item,int servex,int servey){
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
                } else {
                System.out.println("tureかfalseを選んでください");
                }
            }
        p.position.x = servex;
        p.position.y = servey;
        return i;
    }
}