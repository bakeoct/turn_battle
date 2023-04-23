package Calc;

import Calc.Item.Item;
import Calc.Item.Ladder;
import Calc.Item.Ship;
import Monsters.Dragon_king;

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
    public Warks(Position position, Position monsterposition, Scanner scanner, Map map, Dragon_king dragon_king,Person2 person2){
        this.position = position;
        this.monsterposition = monsterposition;
        this.scanner = scanner;
        this.map =map;
        this.dragon_king = dragon_king;
        this.p = person2;
    }

    public void turnwalk() {
        Warks warks =new Warks(position,monsterposition,scanner,map,dragon_king,p);
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
                int servenogo = map.notpoint(p.position.x, p.position.y);
                String plice = scanner.next();
                if (plice.equals("a") || plice.equals("d")) {
                    p.position.x = p.walkx(p.position.x, plice);
                    i++;
                } else {
                    if (plice.equals("w") || plice.equals("s")) {
                        p.position.y = p.walky(p.position.y, plice);
                        i++;
                    } else {
                        System.out.println("a,w,s,dのどれかを選んでください");
                    }
                }
                //これをmapに送って二つメソッド動かす
                int nogo = map.notpoint(p.position.x, p.position.y);
                if (nogo == 1 && !(nogo == servenogo)) {
                    point = "崖";
                    item = "梯子";
                    i = warks.notpoint(ladder, servex, servey, i, point, item);
                } else {
                    if (nogo == 2 && !(nogo == servenogo)) {
                        point = "山";
                        item = "梯子";
                        i = warks.notpoint(ladder, servex, servey, i, point, item);
                    } else {
                        if (nogo == 3 && !(nogo == servenogo)) {
                            point = "海";
                            item = "船";
                            i = warks.notpoint(ship, servex, servey, i, point, item);
                        } else {
                            if (nogo == 4) {
                                i = warks.treasureChest(i, ship, servex, servey);
                            } else {
                                if (nogo == 5) {
                                    i = warks.treasureChest(i, ladder, servex, servey);
                                } else {
                                    if (nogo == -1) {
                                        System.out.println("画面外なので、再度選んでください");
                                        i--;
                                        p.position.x = servex;
                                        p.position.y = servey;
                                    }
                                }
                            }
                        }
                    }
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
                int monsternogo = map.notpoint(dragon_king.position.x, dragon_king.position.y);
                if (monsternogo == -1) {
                    monsteri--;
                    dragon_king.position.x = monsterservex;
                    dragon_king.position.y = monsterservey;
                }
            }
            this.monsterservex = dragon_king.position.x;
            this.monsterservey = dragon_king.position.y;
            System.out.println(monsterservex+","+monsterservey);
            monsterposition = new Position(dragon_king.position.x, dragon_king.position.y);
            System.out.println("人間がいる位置はⅹ座標" + p.position.x + "、Y座標" + p.position.y + "です");
            System.out.println();
            System.out.println("モンスターがいる位置はⅹ座標" + monsterposition.x + "、Y座標" + monsterposition.y + "です");
            System.out.println();
        }
    }
    public int notpoint(Item items,int servex,int servey,int i,String point,String item){
        //map.oceanxそれかyの中の数字に該当する数字だった場合tureを返す
        System.out.print("ここには"+point+"があります。　");
        int endflg = 0;
        while (items.have && endflg == 0) {
            System.out.println(item+"を使いますか？ 使う「ture」 使わない「false」");
            if (scanner.next().equals("ture")) {
                System.out.println(item+"を使った！");
                endflg++;
            } else {
                if (scanner.next().equals("false")) {
                    System.out.println("再度選んでください");
                    p.position.x = servex;
                    p.position.y = servey;
                    i--;
                    endflg++;
                } else {
                    System.out.println("tureかfalseを選んでください");
                }
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
    public int treasureChest(int i,Item item,int servex,int servey){
        int endflg = 0;
        while (endflg == 0) {
            System.out.println("これは"+itembox+"を開けますか？ 開ける「ture」 開けない「false」");
            if (scanner.next().equals("ture")) {
                if (item.have){
                    System.out.println(itembox+"はすでに空っぽだ。再度選んでください");
                    i--;
                    endflg++;
                }else {
                    System.out.println(itembox+"を開けた！,"+item.name+"を手に入れた");
                    item.have=true;
                    endflg++;
                }
            } else {
                if (scanner.next().equals("false")) {
                    System.out.println("再度選んでください");
                    i--;
                    endflg++;
                } else {
                    System.out.println("tureかfalseを選んでください");
                }
            }
        }
        p.position.x = servex;
        p.position.y = servey;
        return i;
    }
}