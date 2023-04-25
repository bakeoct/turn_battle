package Calc;

import Calc.Item.*;
import Monsters.Monster2;

import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    public int personkey=0;
    public int money;
    public SuperSword superSword =new SuperSword();
    public HealGlass healGlass =new HealGlass();
    public Puti_slimemerchandise puti_slimemerchandise =new Puti_slimemerchandise();
    public SteelArmor steelArmor =new SteelArmor();
    public Store(int money) {
        this.money = money;
    }

    public void playstore(ArrayList<Item> items, ArrayList<Monster2> monsters, String namae, String seibetu) {
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
                    store.buy(p, scanner,store,namae,items);
                    System.out.println("ほかには何かあるか？");
                } else {
                    if (shoppingcode.equals("sell")) {
                        store.sell(p, scanner,namae,items,store);
                        System.out.println("ほかには何かあるか？");
                    } else {
                        if (shoppingcode.equals("mission")) {
                            store.mission(p);
                            System.out.println("ほかには何かあるか？");
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
        }

    public void buy(Person2 p, Scanner scanner,Store store,String name,ArrayList<Item> items) {
        int i = 0;
        int endflg = 0;
        ArrayList<Item> buyitems =new ArrayList<Item>();
        System.out.println("買うんだな、この中から選びな");
        while (i == 0) {
            buyitems.clear();
            System.out.println(superSword.name+"　"+superSword.buyprice+"$ ["+superSword.code+"]");
            buyitems.add(superSword);
            System.out.println(healGlass.name+"　"+healGlass.buyprice+"＄ ["+healGlass.code+"]");
            buyitems.add(healGlass);
            System.out.println(steelArmor.name+"　"+steelArmor.buyprice+"$ ["+steelArmor.code+"]");
            buyitems.add(steelArmor);
            System.out.println(puti_slimemerchandise.name+"　"+puti_slimemerchandise.buyprice+"$ ["+puti_slimemerchandise.code+"]");
            buyitems.add(puti_slimemerchandise);
            System.out.println("買わない [goback]");
            String shoppingcode = scanner.next();
            for (Item item : buyitems){
                if (shoppingcode.equals(item.code)){
                    endflg=1;
                    store.buymath(item,name,items);
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
    public void mission (Person2 p){

    }
    public void talk (){
        System.out.println("いい天気ですね");
    }
    public void go (Person2 p){
        System.out.println("じゃあな");
        p.money = this.money;
    }
    public void buymath (Item item,String name,ArrayList<Item> items) {
        if (this.money>=item.buyprice && !(item.have==true)){
            this.money-=item.buyprice;
            System.out.println(name+"は"+item.name+"を買った");
            item.have=true;
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
}
