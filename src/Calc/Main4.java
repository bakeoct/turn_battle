package Calc;

import Calc.Item.Item;
import Calc.Item.Ladder;
import Calc.Item.Ship;
import Monsters.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] ares){
        Random random =new Random();
        int servex=0;
        int servey=0;
        int endflg=0;
        Boolean fellow;
        Scanner scanner =new Scanner(System.in);
        Notgo notgo =new Notgo();
        Gorlem gorlem =new Gorlem();
        Dragon_king dragon_king =new Dragon_king();
        Metal_slime metal_slime =new Metal_slime();
        Puti_slime puti_slime=new Puti_slime();
        Ship ship =new Ship();
        Ladder ladder =new Ladder();
        Main4 battle =new Main4();
        ArrayList<Item> items =new ArrayList<Item>();
        //このあいてむをてにいれたときにaddする
        items.add(ladder);
        items.add(ship);
        ArrayList<Monster2> monsters2 =new ArrayList<Monster2>();
        //個のモンスターを手に入れたときにaddです
        monsters2.add(metal_slime);
        monsters2.add(gorlem);
        Person2 p = new Person2("takumi","dannsei",monsters2,items);
        Position position =new Position(p.position.x,p.position.y);
        Position monsterposition =new Position(dragon_king.position.x,dragon_king.position.y);
        System.out.println(Metal_slime.look(dragon_king));
        for (Monster2 mons : p.monsters2){
            System.out.println(mons.Name()+"(性別."+mons.Seibetu()+")"+"  レベルは"+mons.LV()+"です");
        }
        System.out.println("人間がいる位置はⅹ座標" + position.x + "、Y座標" + position.y + "です");
        System.out.println();
        System.out.println("モンスターがいる位置はⅹ座標" + monsterposition.x + "、Y座標" + monsterposition.y + "です");
        System.out.println();
        while (!(position.x==monsterposition.x) || !(position.y==monsterposition.y)) {
            int i=0;
            while (i==0) {
            String plice = scanner.next();
            //これをgitに挙げる、ｗを押した後で船のやつで戻ってきてからa押したら二つ進んでしまう
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
                if (notgo.oceanx.get(0) == p.position.x && notgo.oceany.get(0) == p.position.y){
                    System.out.print("ここには海があります。　");
                    while (items.get(1).have && endflg==0){
                        System.out.println("船を使いますか？ 使う「ture」 使わない「false」");
                        if (scanner.next().equals("ture")){
                            System.out.println("船を使った！");
                            endflg++;
                        }else {
                            if (scanner.next().equals("false")){
                                System.out.println("再度選んでください");
                                p.position.x=servex;
                                p.position.y=servey;
                                i--;
                                endflg++;
                            }else {
                                System.out.println("tureかfalseを選んでください");
                            }
                        }
                    }
                    if (endflg==0){
                        System.out.println("再度選んでください");
                        p.position.x=servex;
                        p.position.y=servey;
                        i--;
                    }
                }
                servex=p.position.x;
                servey=p.position.y;
        }
            position =new Position(p.position.x,p.position.y);
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
        System.out.println();
        System.out.println("モンスターと出会った！！");
        if(random.nextBoolean()){
            p.battle(dragon_king);
        }else {
            System.out.println("仲間になった！！");
            monsters2.add(dragon_king);
            System.out.println(dragon_king.name + "(性別." + dragon_king.seibetu + ")" + "  レベルは" + dragon_king.leberu + "です");
        }
    }
}
