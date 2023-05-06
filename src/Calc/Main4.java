package Calc;

import Calc.Item.*;
import Calc.Mission.MissionDragon_king;
import Monsters.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] ares){
        int personkey=1;
        Random random =new Random();
        SuperSword superSword =new SuperSword();
        Puti_slimemerchandise puti_slimemerchandise =new Puti_slimemerchandise();
        HealGlass healGlass =new HealGlass();
        SteelArmor steelArmor =new SteelArmor();
        Scanner scanner =new Scanner(System.in);
        Gorlem gorlem =new Gorlem();
        Dragon_king dragon_king =new Dragon_king();
        Metal_slime metal_slime =new Metal_slime();
        Puti_slime puti_slime=new Puti_slime();
        MissionDragon_king missionDragon_king =new MissionDragon_king();
        Ship ship =new Ship();
        Ladder ladder =new Ladder();
        ArrayList<Item> items =new ArrayList<Item>();
        ArrayList<Item> itemsAll =new ArrayList<Item>();
        itemsAll.add(ship);
        itemsAll.add(ladder);
        itemsAll.add(puti_slimemerchandise);
        itemsAll.add(healGlass);
        itemsAll.add(steelArmor);
        itemsAll.add(superSword);
        ArrayList<Monster2> monsters2 =new ArrayList<Monster2>();
        //このモンスターを手に入れたときにaddです
        monsters2.add(metal_slime);
        monsters2.add(gorlem);
        String name = "takumi";
        String seibetu = "dannsei";
        Person2 p = new Person2("takumi","dannsei",monsters2,items,personkey);
        Position position =new Position(p.position.x,p.position.y);
        Position monsterposition =new Position(dragon_king.position.x,dragon_king.position.y);
        Map map =new Map();
        Warks warks =new Warks(position,monsterposition,scanner,map,dragon_king,p,p.items,p.money,monsters2,name,seibetu,itemsAll,missionDragon_king);
        System.out.println(Metal_slime.look(dragon_king));
        for (Monster2 mons : p.monsters2){
            System.out.println(mons.Name()+"(性別."+mons.Seibetu()+")"+"  レベルは"+mons.LV()+"です");
        }
        warks.turnwalk();
        System.out.println();
        System.out.println("モンスターと出会った！！");
        if(random.nextBoolean()){
            p.battle(dragon_king,dragon_king,missionDragon_king);
        }else {
            System.out.println("仲間になった！！");
            monsters2.add(dragon_king);
            System.out.println(dragon_king.name + "(性別." + dragon_king.seibetu + ")" + "  レベルは" + dragon_king.leberu + "です");
        }
    }
}
