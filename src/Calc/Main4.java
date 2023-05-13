package Calc;

import Calc.Error.Finish;
import Calc.Item.*;
import Calc.Mission.MissionDragon_king;
import Monsters.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] ares) throws Finish {
        int personkey=1;
        ArrayList<String> string_memory =new ArrayList<String>();
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
        ArrayList<Item> items_all =new ArrayList<Item>();
        items_all.add(ship);
        items_all.add(ladder);
        items_all.add(puti_slimemerchandise);
        items_all.add(healGlass);
        items_all.add(steelArmor);
        items_all.add(superSword);
        ArrayList<Item> fight_items =new ArrayList<Item>();
        fight_items.add(healGlass);
        fight_items.add(steelArmor);
        fight_items.add(superSword);
        ArrayList<Monster2> enemy_monsters =new ArrayList<Monster2>();
        enemy_monsters.add(dragon_king);
        enemy_monsters.add(metal_slime);
        enemy_monsters.add(puti_slime);
        enemy_monsters.add(gorlem);
        EnemeyMonster enemeyMonster =new EnemeyMonster();
        ArrayList<Monster2> monsters2 =new ArrayList<Monster2>();
        //このモンスターを手に入れたときにaddです
        monsters2.add(metal_slime);
        monsters2.add(gorlem);
        String name = "takumi";
        String seibetu = "dannsei";
        Finish finish =new Finish();
        finish.Read(string_memory);
        Person2 p = new Person2("takumi","dannsei",monsters2,items,personkey);
        Position position =new Position(p.position.x,p.position.y);
        Position monsterposition =new Position(enemeyMonster.position.x,enemeyMonster.position.y);
        Map map =new Map();
        finish.saveWriteAndRead.InSave(string_memory,monsterposition,position,p,monsters2);
        Warks warks =new Warks(enemy_monsters,position,monsterposition,scanner,map,dragon_king,p,items_all,missionDragon_king,fight_items,monsters2,enemeyMonster);
        System.out.println(Metal_slime.look(dragon_king));
        for (Monster2 mons : p.monsters2){
            System.out.println(mons.Name()+"(性別."+mons.Seibetu()+")"+"  レベルは"+mons.LV()+"です");
        }
        try {
            warks.warkTurn();
        }
        catch (Finish e){

        }
    }
}
