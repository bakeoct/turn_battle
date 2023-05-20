package Calc;

import Calc.Error.Finish;
import Calc.Item.*;
import Calc.Mission.Mission;
import Calc.Mission.MissionDragon_king;
import Calc.Mission.MissionSab;
import Calc.save.SaveLoadManager;
import Monsters.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    public int storeLV=1;
    public int personkey=0;
    public int money;
    public Store(int money) {
        this.money = money;
    }

    public void shoppingStore(ArrayList<Monster2> monsters,ArrayList<Item> items_all,MissionDragon_king missionDragon_king,Person2 p,ArrayList<MonsterItem> monster_items_all) throws Finish {
        System.out.println(monsters);
        Scanner scanner = new Scanner(System.in);
        System.out.println("いらっしゃい、ここは雑貨屋だよアイテムからモンスターまで幅広く取り扱ってるよ");
        System.out.println("何の用かな？");
        int i = 0;
        while (i == 0) {
            System.out.println("買う[buy]");
            System.out.println("売る[sell]");
            System.out.println("ミッション[mission]");
            System.out.println("話す[talk]");
            System.out.println("出る[go]");
            String shoppingcode = scanner.next();
                if (shoppingcode.equals("buy")) {
                    buy(p,scanner,items_all,monsters,monster_items_all);
                    System.out.println("ほかには何かあるか？");
                } else if (shoppingcode.equals("sell")) {
                    sell(p,scanner,monsters,monster_items_all);
                    System.out.println("ほかには何かあるか？");
                } else if (shoppingcode.equals("mission")) {
                    mission(p,scanner,missionDragon_king);
                    System.out.println("ほかには何かあるか？");
                } else if (shoppingcode.equals("talk")) {
                    talk();
                    System.out.println("ほかには何かあるか？");
                } else if (shoppingcode.equals("go")) {
                    go(p);
                    i++;
                } else{
                    System.out.println("buy,sell,mission,talk,goで選んでください");
                }
        }
    }
    public void buy(Person2 p, Scanner scanner,ArrayList<Item> items_all,ArrayList<Monster2> monster2s,ArrayList<MonsterItem> monster_items_all) throws Finish {
        int i = 0;
        int endflg = 0;
        ArrayList<Item> buyitems =new ArrayList<Item>();
        System.out.println("買うんだな、この中から選びな");
        System.out.println("お金を追加");
        p.money++;
        while (i == 0) {
            buyitems.clear();
            for (Item item : items_all){
                if (item.itemLV<=storeLV){
                    System.out.println(item.name+"　"+item.buyprice+"$ ["+item.code+"]");
                    buyitems.add(item);
                }
            }
            System.out.println("買わない [goback]");
            String shoppingcode = scanner.next();
            for (Item item : buyitems){
                if (shoppingcode.equals(item.code)){
                    endflg=1;
                    buyMath(item,p,monster_items_all,monster2s);
                    System.out.println("他はどうだ？");
                }
            }
            if (shoppingcode.equals("goback")) {
                System.out.println("そうか");
                i++;
            }else if (shoppingcode.equals("finish")) {
                throw new Finish();
            } else if (!(endflg==1)){
                System.out.println("メニューから選んでくれ");
                }
            }
        }
    public void sell (Person2 p, Scanner scanner,ArrayList<Monster2> monster2s,ArrayList<MonsterItem> monster_items_all) throws Finish {
        System.out.println("売るんだな、何を売るんだ？");
        int i = 0;
        int endflg = 0;
        while (i == 0) {
            for (Item item : p.field_items) {
                endflg = 1;
                System.out.println(item.name + " " + item.sellprice + "$ [" + item.code + "]");
            }
            for (Item item : p.fight_items) {
                endflg = 1;
                System.out.println(item.name + " " + item.sellprice + "$ [" + item.code + "]");
            }
            for (Item item : p.monster_items) {
                endflg = 1;
                System.out.println(item.name + " " + item.sellprice + "$ [" + item.code + "]");
            }
            if (endflg == 0) {
                System.out.println("ってお前アイテム持ってねえじゃねえか!");
                System.out.println("じゃあ売れねえな");
                break;
            } else if (endflg == 2) {
                break;
            }
            System.out.println("売らない [goback]");
            String sellcode = scanner.next();
            for (Item item : p.monster_items) {
                if (sellcode.equals(item.code)) {
                    endflg = 2;
                    sellMath(item, p,monster2s,monster_items_all);
                    System.out.println("他はどうする？");
                    break;
                }
            }
            for (Item item : p.field_items) {
                if (sellcode.equals(item.code)) {
                    endflg = 2;
                    sellMath(item, p,monster2s,monster_items_all);
                    System.out.println("他はどうする？");
                    break;
                }
            }
            for (Item item : p.fight_items) {
                if (sellcode.equals(item.code)) {
                    endflg = 2;
                    sellMath(item,p,monster2s,monster_items_all);
                    System.out.println("他はどうする？");
                    break;
                }
            }
            if (sellcode.equals("goback")) {
                System.out.println("そうか");
                i++;
            } else if (!(endflg == 2)) {
                System.out.println("メニューから選んでくれ");
            }
        }
    }
    public void mission (Person2 p,Scanner scanner,MissionDragon_king missionDragon_king) throws Finish {
        Boolean endflg = false;
        Boolean repert = false;
        MissionSab missionSab =new MissionSab();
        ArrayList<Mission> missions =new ArrayList<Mission>();
        missions.add(missionDragon_king);
        for (Mission mission : missions){
            if (mission.getreward && repert==false){
                endflg = true;
                repert = true;
                mission.getreward = false;
                System.out.println("お！、お前"+mission.name+"のミッションを達成しているな");
                System.out.println("ほら報酬だ！");
                 this.money+=mission.reward;
            }else if (mission.getreward){
                    mission.getreward = false;
                    System.out.println("お！、お前"+mission.name+"のミッションも達成しているな");
                    System.out.println("ほら報酬だ！");
                    this.money+=mission.reward;
                }
            }
        if (endflg==false){
            System.out.println("ミッションを受けるんだな");
            missionSab.receive(p,scanner,missionDragon_king);
        }
    }
    public void talk (){
        System.out.println("いい天気ですね");
    }
    public void go (Person2 p){
        System.out.println("じゃあな");
        p.money = this.money;
    }
    public void buyMath (Item item,Person2 p,ArrayList<MonsterItem> monster_items_all,ArrayList<Monster2> monster2s) {
        if (this.money >= item.buyprice && !(item.have == true)) {
            this.money -= item.buyprice;
            System.out.println(p.name + "は" + item.name + "を買った");
            item.have = true;
                for (MonsterItem alive_item : monster_items_all) {
                        if (alive_item == item) {
                            monster2s.add(inMonster(item));
                        }
                }
                System.out.println(item.itemsclass);
            if (item.itemsclass.equals("fightitem")){
                p.fight_items.add((FightItem) item);
            }else if (item.itemsclass.equals("fielditem")){
                p.field_items.add((FieldItem) item);
            }else {
                p.monster_items.add((MonsterItem) item);
            }
        }else {
            if (this.money<item.buyprice) {
                System.out.println("金が足んねえ");
                System.out.println("、、、出直して来な");
            }else {
                System.out.println("もう同じの持っているじゃねえか");
                System.out.println("なら必要ないな");
            }
        }
    }
    public void sellMath (Item item,Person2 p,ArrayList<Monster2> monster2s,ArrayList<MonsterItem> monster_items_all) {
            this.money += item.sellprice;
            System.out.println(p.name + "は" + item.name + "を売った");
            item.have = false;
        for (MonsterItem alive_item : monster_items_all) {
                if (alive_item == item) {
                    monster2s.remove(inMonster(item));
                }
        }
        if (item.itemsclass == "fightitem"){
            p.fight_items.remove(p.fight_items.indexOf(item));
        }else if (item.itemsclass == "fielditem"){
            p.field_items.remove(p.field_items.indexOf(item));
        }else {
            p.monster_items.remove(p.monster_items.indexOf(item));
        }

    }
    public Monster2 inMonster(Item item){
        Monster2 monster2 = null;
        Puti_slime puti_slime =new Puti_slime();
        Metal_slime metal_slime =new Metal_slime();
        Gorlem gorlem =new Gorlem();
        Dragon_king dragon_king =new Dragon_king();
        if (item.name.equals("プチスライム")){
            monster2=puti_slime;
        }else if (item.name.equals("ゴーレム")){
            monster2=gorlem;
        }else if (item.name.equals("竜王")){
            monster2=dragon_king;
        }else if (item.name.equals("メタルスライム")){
            monster2=metal_slime;
                    }
        return monster2;
    }
}
