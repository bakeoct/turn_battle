package Calc;

import java.util.ArrayList;

public class Main4 {
    public static void main(String[] ares){
        int metal_slime_lv = 0;
        int puti_slime_lv = 300;
        int dragon_king_lv = 1;
        int gorlem_lv = 30;
        int metal_slime_hp = 500;
        int puti_slime_hp = 398;
        int gorlem_hp=9000;
        int dragon_king_hp=20000000;
        int metal_slime_attack=6000;
        int puti_slime_attack=50000000;
        int gorlem_attack=70000;
        int dragon_king_attack=100000;
        int metal_slime_mp=80000;
        int puti_slime_mp=700000000;
        int gorlem_mp=300;
        int dragon_king_mp=2000000;
        int position=0;
        int metal_slime_speed=20;
        int puti_slime_speed=70;
        int gorlem_speed=10;
        int dragon_king_speed=7;
        String golem="ゴ－レム";
        String metal_sraime="メタルスライム";
        String puti_sraime="プチスライム";
        String doragon_king="竜王";
        Main4 battle =new Main4();
        Monster2 gorlem =new Monster2(golem,"なし",gorlem_lv,gorlem_hp,gorlem_attack,gorlem_mp,gorlem_speed);
        Monster2 dragon_king =new Monster2(doragon_king,"男性",dragon_king_lv,dragon_king_hp,dragon_king_attack,dragon_king_mp,dragon_king_speed);
        Monster2 metal_slime =new Monster2(metal_sraime,"無し",metal_slime_lv,metal_slime_hp, metal_slime_attack,metal_slime_mp,metal_slime_speed);
        Monster2 puti_slime= new Monster2(puti_sraime,"？",puti_slime_lv,puti_slime_hp,puti_slime_attack,puti_slime_mp,puti_slime_speed);
        ArrayList<Monster2> monsters2 =new ArrayList<Monster2>();
        monsters2.add(new Monster2(doragon_king,"男性",dragon_king_lv,dragon_king_hp,dragon_king_attack,dragon_king_mp,dragon_king_speed));
        Person2 p = new Person2("takumi","dannsei",monsters2,metal_slime,gorlem);
        for(int i=0;i< monsters2.size(); i++){
            position+=p.walk();
        }
        System.out.println(metal_slime.look(dragon_king));
        for (Monster2 mons : p.monsters2){
            System.out.print(mons.Name()+"(性別."+mons.Seibetu()+")"+"  レベルは"+mons.LV()+"です");
        }
        System.out.println(p.name+p.seibetu+position);
        System.out.println();
        p.battle(dragon_king);
    }
}
