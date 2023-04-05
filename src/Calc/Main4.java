package Calc;

import Monsters.*;

import java.util.ArrayList;
import java.util.Random;

public class Main4 {
    public static void main(String[] ares){
        Random random =new Random();
        Boolean fellow;
        int[] position;
        int[] monsterposition;
        Gorlem gorlem =new Gorlem();
        Dragon_king dragon_king =new Dragon_king();
        Metal_slime metal_slime =new Metal_slime();
        Puti_slime puti_slime=new Puti_slime();
        Main4 battle =new Main4();
        ArrayList<Monster2> monsters2 =new ArrayList<Monster2>();
        monsters2.add(metal_slime);
        monsters2.add(gorlem);
        Person2 p = new Person2("takumi","dannsei",monsters2);
        System.out.println(Metal_slime.look(dragon_king));
        for (Monster2 mons : p.monsters2){
            System.out.println(mons.Name()+"(性別."+mons.Seibetu()+")"+"  レベルは"+mons.LV()+"です");
        }
        position = p.walk();
        monsterposition = dragon_king.walk();
        System.out.println("人間がいる位置はⅹ座標" + position[0] + "、Y座標" + position[1] + "です");
        System.out.println();
        System.out.println("モンスターがいる位置はⅹ座標" + monsterposition[0] + "、Y座標" + monsterposition[1] + "です");
        System.out.println();
        while (!(position[0]==monsterposition[0]) || !(position[1]==monsterposition[1])) {
            position = p.walk();
            monsterposition = dragon_king.walk();
            System.out.println("人間がいる位置はⅹ座標" + position[0] + "、Y座標" + position[1] + "です");
            System.out.println();
            System.out.println("モンスターがいる位置はⅹ座標" + monsterposition[0] + "、Y座標" + monsterposition[1] + "です");
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
        p.battle(dragon_king);
    }
}
