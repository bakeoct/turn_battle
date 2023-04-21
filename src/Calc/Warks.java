package Calc;

import Calc.Item.Item;
import Calc.Item.Ladder;
import Calc.Item.Ship;
import Monsters.Dragon_king;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Warks {
    public Position position;
    public Position monsterposition;
    public Scanner scanner;
    public Notgo notgo;
    public Ladder ladder;
    public Dragon_king dragon_king;
    public Person2 p;
    public Warks(Position position, Position monsterposition, Scanner scanner, Notgo notgo, Dragon_king dragon_king,Person2 person2){
        this.position = position;
        this.monsterposition = monsterposition;
        this.scanner = scanner;
        this.notgo =notgo;
        this.dragon_king = dragon_king;
        this.p = person2;
    }

    public void turnwalk(){
        ArrayList<Item> items =new ArrayList<Item>();
        Random random =new Random();
        Ship ship =new Ship();
        Ladder ladder =new Ladder();
        int servex=0;
        int servey=0;
        System.out.println("人間がいる位置はⅹ座標" + position.x + "、Y座標" + position.y + "です");
        System.out.println();
        System.out.println("モンスターがいる位置はⅹ座標" + monsterposition.x + "、Y座標" + monsterposition.y + "です");
        System.out.println();
        while (!(position.x==monsterposition.x) || !(position.y==monsterposition.y)) {
            int i=0;
            while (i==0) {
                String plice = scanner.next();
                if (plice.equals("a") || plice.equals("d")) {
                    position.x = p.walkx(position.x, plice);
                    i++;
                } else {
                    if (plice.equals("w") || plice.equals("s")) {
                        position.y = p.walky(position.y, plice);
                        i++;
                    } else {
                        System.out.println("a,w,s,dのどれかを選んでください");
                    }
                }
                //これをnotgoに送って二つメソッド動かす
                Boolean notgox=notgo.notpoint(notgo.oceanx,position.x);
                Boolean notgoy=notgo.notpoint(notgo.oceany,position.y);
                //notgo.oceanxそれかyの中の数字に該当する数字だった場合tureを返す
                if (notgox && notgoy){
                    System.out.print("ここには海があります。　");
                    int endflg=0;
                    while (ship.have && endflg==0){
                        System.out.println("船を使いますか？ 使う「ture」 使わない「false」");
                        if (scanner.next().equals("ture")){
                            System.out.println("船を使った！");
                            endflg++;
                        }else {
                            if (scanner.next().equals("false")){
                                System.out.println("再度選んでください");
                                position.x=servex;
                                position.y=servey;
                                i--;
                                endflg++;
                            }else {
                                System.out.println("tureかfalseを選んでください");
                            }
                        }
                    }
                    if (endflg==0){
                        System.out.println("再度選んでください");
                        position.x=servex;
                        position.y=servey;
                        i--;
                    }
                }
                servex=position.x;
                servey=position.y;
            }
            position =new Position(position.x,position.y);
            if (random.nextBoolean()) {
                dragon_king.position.x = dragon_king.walk(monsterposition.x);
            }else {
                dragon_king.position.y = dragon_king.walk(monsterposition.y);
            }
            monsterposition =new Position(dragon_king.position.x,dragon_king.position.y);
            System.out.println("人間がいる位置はⅹ座標" + position.x + "、Y座標" + position.y + "です");
            System.out.println();
            System.out.println("モンスターがいる位置はⅹ座標" + monsterposition.x + "、Y座標" + monsterposition.y + "です");
            System.out.println();
        }
    }
}