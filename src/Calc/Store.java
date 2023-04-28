package Calc;

import Calc.Item.*;
import Calc.Mission.Mission;
import Calc.Mission.MissionDragon_king;
import Calc.Mission.MissionSab;
import Monsters.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    public int storeLV=1;
    public int personkey=0;
    public int money;
    public SuperSword superSword =new SuperSword();
    public HealGlass healGlass =new HealGlass();
    public Puti_slimemerchandise puti_slimemerchandise =new Puti_slimemerchandise();
    public SteelArmor steelArmor =new SteelArmor();
    public Store(int money) {
        this.money = money;
    }

    public Boolean playstore(ArrayList<Item> items, ArrayList<Monster2> monsters, String namae, String seibetu,ArrayList<Item> itemAll) {
        MissionDragon_king missionDragon_king =new MissionDragon_king();
        System.out.println(monsters);
        Store store = new Store(money);
        Person2 p = new Person2(namae, seibetu, monsters, items,personkey);
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
                    store.buy(p, scanner,store,namae,items,itemAll,monsters);
                    System.out.println("ほかには何かあるか？");
                } else {
                    if (shoppingcode.equals("sell")) {
                        store.sell(p, scanner,namae,items,store);
                        System.out.println("ほかには何かあるか？");
                    } else {
                        if (shoppingcode.equals("mission")) {
                            Boolean progres =store.mission(p,scanner);
                            System.out.println("ほかには何かあるか？");
                            missionDragon_king.progress = progres;
                        } else {
                            if (shoppingcode.equals("talk")) {
                                store.talk();
                                System.out.println("ほかには何かあるか？");
                            } else {
                                if (shoppingcode.equals("go")) {
                                    store.go(p);
                                    i++;
                                } else {
                                    System.out.println("buy,sell,mission,talk,goで選んでください");
                                }
                            }
                        }
                    }
                }
            }
        return missionDragon_king.progress;
        }
    public void buy(Person2 p, Scanner scanner,Store store,String name,ArrayList<Item> items,ArrayList<Item> itemAll,ArrayList<Monster2> monster2s) {
        int i = 0;
        int endflg = 0;
        ArrayList<Item> buyitems =new ArrayList<Item>();
        System.out.println("買うんだな、この中から選びな");
        while (i == 0) {
            buyitems.clear();
            for (Item item : itemAll){
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
                    store.buymath(item,name,items,itemAll,store,monster2s);
                    System.out.println("他はどうだ？");
                }
            }
            if (shoppingcode.equals("goback")) {
                System.out.println("そうか");
                i++;
            }else {
                if (!(endflg==1)){
                    System.out.println("メニューから選んでくれ");
                }
            }
        }
    }
    public void sell (Person2 p, Scanner scanner,String name,ArrayList<Item> items,Store store){
        System.out.println("売るんだな、何を売るんだ？");
        int i=0;
        int endflg = 0;
        while (i==0){
            for (Item item : items){
                endflg=1;
                System.out.println(item.name+" "+item.sellprice+"$ ["+item.code+"]");
            }
            if (endflg==0) {
                System.out.println("ってお前アイテム持ってねえじゃねえか!");
                System.out.println("じゃあ売れねえな");
                break;
            }else {
                if (endflg==2){
                    break;
                }
            }
                System.out.println("売らない [goback]");
                String sellcode = scanner.next();
            for (Item item : items){
                if (sellcode.equals(item.code)){
                    endflg=2;
                    store.sellmath(item,name,items);
                    System.out.println("他はどうする？");
                    break;
                }
            }
            if (sellcode.equals("goback")) {
                System.out.println("そうか");
                i++;
            }else {
                if (!(endflg==2)) {
                    System.out.println("メニューから選んでくれ");
                }
            }
        }
    }
    public Boolean mission (Person2 p,Scanner scanner){
        Boolean endflg = false;
        Boolean repert = false;
        MissionSab missionSab =new MissionSab();
        MissionDragon_king missionDragon_king =new MissionDragon_king();
        ArrayList<Mission> missions =new ArrayList<Mission>();
        missions.add(missionDragon_king);
        for (Mission mission : missions){
            if (mission.getreward == true && repert==false){
                endflg = true;
                repert = true;
                mission.getreward = false;
                System.out.println("お！、お前"+mission.name+"のミッションを達成しているな");
                System.out.println("ほら報酬だ！");
                 this.money=mission.reward;
            }else {
                if (mission.getreward == true){
                    mission.getreward = false;
                    System.out.println("お！、お前"+mission.name+"のミッションも達成しているな");
                    System.out.println("ほら報酬だ！");
                    this.money=mission.reward;
                }
            }
        }
        if (endflg==false){
            System.out.println("ミッションを受けるんだな");
            Boolean progres=missionSab.receive(p,scanner);
            missionDragon_king.progress = progres;
        }
        return missionDragon_king.progress;
    }
    public void talk (){
        System.out.println("いい天気ですね");
    }
    public void go (Person2 p){
        System.out.println("じゃあな");
        p.money = this.money;
    }
    public void buymath (Item item,String name,ArrayList<Item> items, ArrayList<Item> itemAll,Store store,ArrayList<Monster2> monster2s) {
        if (this.money >= item.buyprice && !(item.have == true)) {
            this.money -= item.buyprice;
            System.out.println(name + "は" + item.name + "を買った");
            item.have = true;
            for (Item alive_item : itemAll) {
                if (alive_item.isalive) {
                    if (alive_item==item){
                        monster2s.add(store.in_monster(alive_item));
                    }
                }
            }
            items.add(item);
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
    public void sellmath (Item item,String name,ArrayList<Item> items) {
            this.money+=item.sellprice;
            System.out.println(name+"は"+item.name+"を売った");
            item.have=false;
            items.remove(items.indexOf(item));
    }
    public Monster2 in_monster(Item item){
        Monster2 monster2 = null;
        Puti_slime puti_slime =new Puti_slime();
        Metal_slime metal_slime =new Metal_slime();
        Gorlem gorlem =new Gorlem();
        Dragon_king dragon_king =new Dragon_king();
        if (item.name.equals("プチスライム")){
            monster2=puti_slime;
        }else {
            if (item.name.equals("ゴーレム")){
                monster2=gorlem;
            }else {
                if (item.name.equals("竜王")){
                    monster2=dragon_king;
                }else {
                    if (item.name.equals("メタルスライム")){
                        monster2=metal_slime;
                    }
                }
            }
        }
        return monster2;
    }
}
