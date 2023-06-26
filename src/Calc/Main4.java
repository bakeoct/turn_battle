package Calc;

import Calc.Error.Finish;
import Calc.Mission.MissionDragonKing;
import Calc.save.SaveWriteAndRead;
import Monsters.*;

import java.util.ArrayList;

public class Main4 {
    public static void main(String[] ares) throws Finish {
        EnemeyMonster enemeyMonster =new EnemeyMonster();
        Person2 p = new Person2("takumi","dannsei",new MetalSlime(),new Gorlem());
        Game game =new Game(p,enemeyMonster);
        SaveWriteAndRead saveWriteAndRead =new SaveWriteAndRead(game);
        game = saveWriteAndRead.read();
        //gameの中のpについて数値を変更しているから実際のpには何も影響がない.
        for (Monster2 mons : p.monsters2){
            System.out.println(mons.name()+"(性別."+mons.seibetu()+")"+"  レベルは"+mons.lv()+"です");
        }
        try {
            game.gameTurn();
        }
        catch (Finish e){
            saveWriteAndRead.write();
        }
    }
}
