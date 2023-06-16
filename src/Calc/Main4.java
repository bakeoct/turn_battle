package Calc;

import Calc.Error.Finish;
import Calc.Mission.MissionDragonKing;
import Calc.save.SaveWriteAndRead;
import Monsters.*;

import java.util.ArrayList;

public class Main4 {
    public static void main(String[] ares) throws Finish {
        Gorlem gorlem =new Gorlem();
        DragonKing dragon_king =new DragonKing();
        MetalSlime metal_slime =new MetalSlime();
        PutiSlime puti_slime=new PutiSlime();
        EnemeyMonster enemeyMonster =new EnemeyMonster();
        ArrayList<Monster2> enemy_monsters = new ArrayList<>();
        enemy_monsters.add(dragon_king);
        enemy_monsters.add(metal_slime);
        enemy_monsters.add(puti_slime);
        enemy_monsters.add(gorlem);
        Person2 p = new Person2("takumi","dannsei",new MetalSlime(),new Gorlem());
        Game game =new Game(p,enemeyMonster,enemy_monsters,dragon_king);
        SaveWriteAndRead saveWriteAndRead =new SaveWriteAndRead(game);
        game = saveWriteAndRead.read();
        //gameの中のpについて数値を変更しているから実際のpには何も影響がない.
        System.out.println(MetalSlime.look(dragon_king));
        for (Monster2 mons : p.monsters2){
            System.out.println(mons.Name()+"(性別."+mons.Seibetu()+")"+"  レベルは"+mons.LV()+"です");
        }
        try {
            game.gameTurn();
        }
        catch (Finish e){
            saveWriteAndRead.write();
        }
    }
}
