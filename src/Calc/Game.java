package Calc;

import Calc.Error.Finish;
import Calc.Item.*;
import Calc.Mission.MissionDragonKing;
import Calc.map.Map;
import Monsters.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
//敵を一回倒したらその敵をエラーの場所以外のどこかへ飛ばしまた倒されたら別の場所にまた飛ばす
public class Game implements Serializable {
    public Ship ship = new Ship();
    public Ladder ladder = new Ladder();
    public Map map =new Map();
    public Person2 p;
    public String point;
    public EnemeyMonster enemeyMonster;
    public MissionDragonKing missionDragonKing =new MissionDragonKing();
    public Game(Person2 person2, EnemeyMonster enemeyMonster) {
        this.p = person2;
        this.enemeyMonster = enemeyMonster;
    }

    public void gameTurn() throws Finish {
        Store store = new Store(this.p.money,ship,ladder,missionDragonKing);
        Event event =new Event(p,map,ladder,ship,missionDragonKing,enemeyMonster);
        Random random = new Random();
        RamdomMonster ramdomMonster = new RamdomMonster();
        Monster2 enemeymonster = ramdomMonster.getMonsterRandomly();
        System.out.println("人間がいる位置は"+p.area+"でⅹ座標" + p.x + "、Y座標" + p.y + "です");
        System.out.println();
        System.out.println("モンスターがいる位置は"+enemeyMonster.area+"でⅹ座標" + enemeyMonster.x + "、Y座標" + enemeyMonster.y + "です");
        System.out.println();
        while (true) {
            int i = 0;
            while (i == 0) {
                String serve_get_map_code = map.getMapCode(p.x, p.y, p.area);
                Scanner scanner = new Scanner(System.in);
                String plice = scanner.next();
                if (plice.equals("a") || plice.equals("d")) {
                    p.x = p.walkX(p.x, plice);
                    i++;
                } else if (plice.equals("w") || plice.equals("s")) {
                    p.y = p.walkY(p.y, plice);
                    i++;
                } else if (plice.equals("finish")) {
                    throw new Finish();
                } else {
                    System.out.println("a,w,s,dのどれかを選んでください");
                }
                i = event.eventPerson(serve_get_map_code, i, p.servex, p.servey, store);
                System.out.println(missionDragonKing.progress);
            }
            p.servex = p.x;
            p.servey = p.y;
            int monsteri = 0;
            while (monsteri == 0) {
                if (random.nextBoolean()) {
                    enemeyMonster.x = enemeyMonster.walk(enemeyMonster.x);
                    monsteri++;
                } else {
                    enemeyMonster.y = enemeyMonster.walk(enemeyMonster.y);
                    monsteri++;
                }
                monsteri = event.eventMonster(monsteri,enemeyMonster.monsterservex,enemeyMonster.monsterservey);
            }
            enemeyMonster.monsterservex = enemeyMonster.x;
            enemeyMonster.monsterservey = enemeyMonster.y;
            System.out.println("人間がいる位置は"+p.area+"でⅹ座標" + p.x + "、Y座標" + p.y + "です");
            System.out.println();
            System.out.println("モンスターがいる位置は"+enemeyMonster.area+"でⅹ座標" + enemeyMonster.x + "、Y座標" + enemeyMonster.y + "です");
            System.out.println();
            if (p.x == enemeyMonster.x && p.y == enemeyMonster.y && p.area.equals(enemeyMonster.area)) {
                System.out.println("!");
                System.out.println("モンスターと出会った！！");
                p.battle(enemeymonster,missionDragonKing);
                enemeymonster = ramdomMonster.getMonsterRandomly();
                ramdomMonster.randomNewEnemeyMonster(enemeyMonster);
            }
        }
    }
}