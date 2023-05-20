package Calc;

import Calc.Error.Finish;
import Calc.Item.*;
import Calc.Mission.MissionDragon_king;
import Calc.save.SaveLoadManager;
import Calc.save.SaveWriteAndRead;
import Monsters.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] ares) throws Finish {
        Gorlem gorlem =new Gorlem();
        Dragon_king dragon_king =new Dragon_king();
        Metal_slime metal_slime =new Metal_slime();
        Puti_slime puti_slime=new Puti_slime();
        int personkey=1;
        ArrayList<String> string_memory =new ArrayList<String>();
        MissionDragon_king missionDragon_king =new MissionDragon_king();
        EnemeyMonster enemeyMonster =new EnemeyMonster();
        ArrayList<Monster2> enemy_monsters = new ArrayList<>();
        enemy_monsters.add(dragon_king);
        enemy_monsters.add(metal_slime);
        enemy_monsters.add(puti_slime);
        enemy_monsters.add(gorlem);
        Finish finish =new Finish();
        finish.Read(string_memory);
        SaveLoadManager sl = new SaveLoadManager();
        Game game = sl.restore();
        System.out.println(game.p.money);
        System.out.println(game.p.money);
        System.out.println(game.p.money);
        System.out.println(game.p.money);
        Map map =new Map();
        Person2 p = game.p;
        finish.saveWriteAndRead.InSave(string_memory,enemeyMonster,p,p.monsters2);
        System.out.println(Metal_slime.look(dragon_king));
        for (Monster2 mons : p.monsters2){
            System.out.println(mons.Name()+"(性別."+mons.Seibetu()+")"+"  レベルは"+mons.LV()+"です");
        }
        try {
            game.gameTurn();
        }
        catch (Finish e){
            ArrayList<String> write_memory =new ArrayList<String>();
            write_memory.add(p.name);
            write_memory.add(p.seibetu);
            write_memory.add(String.valueOf(p.position.x));
            write_memory.add(String.valueOf(p.position.y));
            write_memory.add(String.valueOf(p.LV));
            write_memory.add(String.valueOf(p.money));
            finish.write(write_memory,p,enemeyMonster);
        }
    }
}
