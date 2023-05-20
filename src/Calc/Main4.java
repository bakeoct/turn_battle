package Calc;

import All.AllClass;
import Calc.Error.Finish;
import Calc.Mission.MissionDragonKing;
import Calc.save.SaveWriteAndRead;
import Monsters.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] ares) throws Finish {
        Gorlem gorlem =new Gorlem();
        DragonKing dragon_king =new DragonKing();
        MetalSlime metal_slime =new MetalSlime();
        PutiSlime puti_slime=new PutiSlime();
        int personkey=1;
        Scanner scanner =new Scanner(System.in);
        MissionDragonKing missionDragon_king =new MissionDragonKing();
        EnemeyMonster enemeyMonster =new EnemeyMonster();
        ArrayList<Monster2> enemy_monsters = new ArrayList<>();
        enemy_monsters.add(dragon_king);
        enemy_monsters.add(metal_slime);
        enemy_monsters.add(puti_slime);
        enemy_monsters.add(gorlem);
        Map map =new Map();
        Person2 p = new Person2("takumi","dannsei",metal_slime,gorlem);
        Game game =new Game(scanner,map,p,missionDragon_king,enemeyMonster,enemy_monsters,dragon_king);
        SaveWriteAndRead saveWriteAndRead =new SaveWriteAndRead(p,enemeyMonster,new Position(1,1));
        saveWriteAndRead.read();
        System.out.println(MetalSlime.look(dragon_king));
        for (Monster2 mons : p.monsters2){
            System.out.println(mons.Name()+"(性別."+mons.Seibetu()+")"+"  レベルは"+mons.LV()+"です");
        }
        try {
            game.gameTurn();
        }
        catch (Finish e){
            ArrayList<String> string_write_memory =new ArrayList<>();
            ArrayList<Integer> int_write_memory =new ArrayList<>();
            string_write_memory.add(p.name);
            string_write_memory.add(p.seibetu);
            int_write_memory.add(p.position.x);
            int_write_memory.add(p.position.y);
            int_write_memory.add(p.LV);
            int_write_memory.add(p.money);
            saveWriteAndRead.write();
        }
    }
}
