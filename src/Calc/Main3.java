package Calc;

import java.util.ArrayList;

public class Main3 {
        public static void main(String[] ares){
            int metal_slime_hp = 500000000;
            int puti_slime_hp = 398;
            int gorlem_hp=9000;
            int dragon_king_hp=20;
            int metal_slime_attack=1;
            int puti_slime_attack=50000000;
            int gorlem_attack=700;
            int dragon_king_attack=300;
            int metal_slime_mp=80;
            int puti_slime_mp=700000000;
            int gorlem_mp=300;
            int dragon_king_mp=200;
            int position=0;
            int metal_slime_speed=20;
            int puti_slime_speed=70;
            int gorlem_speed=10;
            int dragon_king_speed=700;
            String golem="ゴ－レム";
            String metal_sraime="メタルスライム";
            String puti_sraime="プチスライム";
            String doragon_king="竜王";
            Main3 battle =new Main3();
            Monster gorlem =new Monster(golem,"なし",30,gorlem_hp,gorlem_attack,gorlem_mp,gorlem_speed);
            Monster dragon_king =new Monster(doragon_king,"男性",1,dragon_king_hp,dragon_king_attack,dragon_king_mp,dragon_king_speed);
            Monster metal_slime =new Monster(metal_sraime,"無し",0,metal_slime_hp, metal_slime_attack,metal_slime_mp,metal_slime_speed);
            Monster puti_slime= new Monster(puti_sraime,"？",300,puti_slime_hp,puti_slime_attack,puti_slime_mp,puti_slime_speed);
            ArrayList<Monster> monsters =new ArrayList<Monster>();
            monsters.add(new Monster("スライム","？",500,50000,300000,9999,20));
            monsters.add(new Monster("キングスライム","？",1,1,1,0,30));
            Person p = new Person("takumi","dannsei",monsters);
            for(int i=0;i< monsters.size(); i++){
                position+=p.walk();
            }
            System.out.println(gorlem.look(dragon_king));
            System.out.println(metal_slime.look(puti_slime));
            for (Monster mons : p.monsters){
                System.out.print(mons.Name()+"(性別."+mons.Seibetu()+")"+"  レベルは"+mons.LV()+"です");
            }
            System.out.println(p.name+p.seibetu+position);
            System.out.println();
            metal_slime.battle(puti_slime);
            dragon_king.battle(gorlem);
        }
}
