package Calc;

import Calc.Error.Finish;
import Calc.Item.*;
import Calc.Item.monsteritem.DragonKingMerchandise;
import Calc.Item.monsteritem.GorlemMerchandise;
import Calc.Item.monsteritem.MetalSlimeMerchandise;
import Calc.Item.monsteritem.PutiSlimeMerchandise;
import Calc.Mission.Mission;
import Calc.Mission.MissionDragonKing;
import Calc.Mission.MissionSab;
import Monsters.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Store implements Serializable {
    public int store_lv=1;
    public int money;
    public ArrayList<Item> items_all =new ArrayList<>();
    public ArrayList<MonsterItem> monster_items_all =new ArrayList<>();
    public ArrayList<FightItem> fight_items_all = new ArrayList<FightItem>();
    public SuperSword super_sword = new SuperSword();
    public PutiSlimeMerchandise puti_slime_merchandise = new PutiSlimeMerchandise();
    public DragonKingMerchandise dragon_king_merchandise =new DragonKingMerchandise();
    public MetalSlimeMerchandise metal_slime_merchandise =new MetalSlimeMerchandise();
    public GorlemMerchandise gorlem_merchandise =new GorlemMerchandise();
    public HealGlass heal_glass = new HealGlass();
    public SteelArmor steel_armor = new SteelArmor();
    public ArrayList<Mission> mission_all =new ArrayList<>();
    public Store(int money,Ship ship,Ladder ladder,MissionDragonKing missionDragonKing) {
        this.money = money;
        this.items_all.add(ship);
        this.items_all.add(ladder);
        this.items_all.add(puti_slime_merchandise);
        this.items_all.add(dragon_king_merchandise);
        this.items_all.add(metal_slime_merchandise);
        this.items_all.add(gorlem_merchandise);
        this.items_all.add(heal_glass);
        this.items_all.add(steel_armor);
        this.items_all.add(super_sword);
        this.fight_items_all.add(heal_glass);
        this.fight_items_all.add(steel_armor);
        this.fight_items_all.add(super_sword);
        this.monster_items_all.add(puti_slime_merchandise);
        this.monster_items_all.add(dragon_king_merchandise);
        this.monster_items_all.add(metal_slime_merchandise);
        this.monster_items_all.add(gorlem_merchandise);
        this.mission_all.add(missionDragonKing);
    }
    public void shoppingStore(Person2 p) throws Finish {
        System.out.println(p.monsters2.get(0).name);
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
                    buy(p,scanner,p.monsters2);
                    System.out.println("ほかには何かあるか？");
                } else if (shoppingcode.equals("sell")) {
                    sell(p,scanner);
                    System.out.println("ほかには何かあるか？");
                } else if (shoppingcode.equals("mission")) {
                    mission(p,scanner);
                    System.out.println("ほかには何かあるか？");
                } else if (shoppingcode.equals("talk")) {
                    talk();
                    System.out.println("ほかには何かあるか？");
                } else if (shoppingcode.equals("go")) {
                    go(p);
                    i++;
                } else if (shoppingcode.equals("finish")) {
                    throw new Finish();
                } else{
                    System.out.println("buy,sell,mission,talk,goで選んでください");
                }
        }
    }
    public void buy(Person2 p, Scanner scanner,ArrayList<Monster2> monster2s) throws Finish {
        int i = 0;
        int endflg = 0;
        ArrayList<Item> buyitems =new ArrayList<>();
        System.out.println("買うんだな、この中から選びな");
        while (i == 0) {
            buyitems.clear();
            for (Item item : items_all){
                if (item.item_lv<=store_lv){
                    System.out.println(item.name+"　"+item.buy_price+"$ ["+item.code+"]");
                    buyitems.add(item);
                }
            }
            System.out.println("買わない [goback]");
            String shoppingcode = scanner.next();
            for (Item item : buyitems){
                if (shoppingcode.equals(item.code)){
                    endflg=1;
                    System.out.println("何個買いたいんだ？");
                    int buy_point = scanner.nextInt();
                    buyMath(item,p,monster_items_all,monster2s,buy_point);
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
    public void sell (Person2 p, Scanner scanner) throws Finish {
        int sell_point = 1;
        System.out.println("売るんだな、何を売るんだ？");
        int i = 0;
        int endflg = 0;
        while (i == 0) {
            for (Item item : p.items) {
                endflg = 1;
                System.out.println(item.name + " " + item.sell_price + "$ [" + item.code + "]" + item.have_point + "個");
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
            for (Item item : p.items) {
                if (sellcode.equals(item.code)) {
                    int sell_endflg = 0;
                    endflg = 2;
                    if (item.have_point>=2){
                        System.out.println("何個売るんだ？");
                        while (sell_endflg == 0) {
                            sell_point = scanner.nextInt();
                            sell_endflg++;
                            if (sell_point>item.have_point){
                                System.out.println("お前はそんなに持ってねーぞ");
                                sell_endflg--;
                            }
                            if (sell_point<=0){
                                System.out.println("1個以上で注文してくれ");
                                sell_endflg--;
                            }
                        }
                    }else {
                        sell_point = 1;
                    }
                    sellMath(item,p,sell_point);
                    System.out.println("他はどうする？");
                    break;
                }
            }
            if (sellcode.equals("goback")) {
                System.out.println("そうか");
                i++;
            } else if (sellcode.equals("finish")) {
                throw new Finish();
            } else if (!(endflg == 2)) {
                System.out.println("メニューから選んでくれ");
            }
        }
    }
    public void mission (Person2 p, Scanner scanner) throws Finish {
        Boolean endflg = false;
        MissionSab missionSab =new MissionSab();
        for (Mission mission : this.mission_all){
            if (mission.get_reward){
                endflg = true;
                mission.get_reward = false;
                System.out.println("お！、お前"+mission.name+"のミッションを達成しているな");
                System.out.println("ほら報酬だ！");
                 this.money+=mission.reward;
            }
        }
        if (!endflg){
            System.out.println("ミッションを受けるんだな");
            missionSab.receive(p,scanner,this.mission_all);
            System.out.println(this.mission_all.get(0).progress);
        }
    }
    public void talk (){
        System.out.println("いい天気ですね");
    }
    public void go (Person2 p){
        System.out.println("じゃあな");
        p.money = this.money;
    }
    public void buyMath (Item item,Person2 p,ArrayList<MonsterItem> monster_items_all,ArrayList<Monster2> monster2s,int buy_point) {
        if (this.money >= item.buy_price*buy_point) {
            this.money -= item.buy_price*buy_point;
            System.out.println(p.name + "は" + item.name +"を" + buy_point + "個" + "買った");
            if (item.have_point == 0) {
                item.have = true;
                for (MonsterItem alive_item : monster_items_all) {
                    if (alive_item == item) {
                        monster2s.add(inMonster(item));
                    }
                }
                if (item instanceof FightItem) {
                    p.fight_items.add((FightItem) item);
                } else if (item instanceof FieldItem) {
                    p.field_items.add((FieldItem) item);
                } else {
                    p.monster_items.add((MonsterItem) item);
                }
                p.items.add(item);
            }
            item.have_point += buy_point;
        }else {
            System.out.println("金が足んねえ");
            System.out.println("、、、出直して来な");
        }
    }
    public void sellMath (Item item,Person2 p,int sell_point) {
        this.money += item.sell_price * sell_point;
        item.have_point -= sell_point;
        System.out.println(p.name + "は" + item.name+ "を" + sell_point + "個" + "売った");
        if (item.have_point == 0) {
            item.have = false;
            for (int i = 0; i < p.monsters2.size(); i++) {
                if (p.monsters2.get(i).name.equals(item.name)) {
                    p.monsters2.remove(i);
                }
            }
            for (int i = 0; i < p.items.size(); i++) {
                if (p.items.get(i) == item) {
                    p.items.remove(i);
                }
            }
        }
    }
    public Monster2 inMonster(Item item){
        Monster2 monster2 = null;
        PutiSlime puti_slime =new PutiSlime();
        MetalSlime metal_slime =new MetalSlime();
        Gorlem gorlem =new Gorlem();
        DragonKing dragon_king =new DragonKing();
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
