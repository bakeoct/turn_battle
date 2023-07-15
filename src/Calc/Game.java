package Calc;

import Calc.Error.Finish;
import Calc.Item.*;
import Calc.Mission.MissionDragonKing;
import Calc.map.Map;
import Monsters.*;
import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;
import static  Calc.Inventry.chooseItems;
import static Monsters.Monster2.getMonsterRandomly;

//敵を一回倒したらその敵をエラーの場所以外のどこかへ飛ばしまた倒されたら別の場所にまた飛ばす
public class Game implements Serializable {
    public Ship ship = new Ship();
    public Ladder ladder = new Ladder();
    public Map map =new Map();
    public Person2 p;
    public EnemeyMonster enemey_monster;
    public MissionDragonKing mission_dragon_king =new MissionDragonKing();
    public Game(Person2 person2, EnemeyMonster enemey_monster) {
        this.p = person2;
        this.enemey_monster = enemey_monster;
    }

    public void gameTurn() throws Finish {
        Store store = new Store(p,ship,ladder,mission_dragon_king);
        Event event =new Event(p,map,ladder,ship,mission_dragon_king,enemey_monster);
        Random random = new Random();
        Monster2 enemey_monster = getMonsterRandomly();
        disPlayPlace();
        while (true) {
            int i = 0;
            while (i == 0) {
                String serve_get_map_code = map.getMapCode(p.x, p.y, p.area);
                Scanner scanner = new Scanner(System.in);
                String plice = scanner.next();
                if (plice.equals("a") || plice.equals("d") || plice.equals("w") || plice.equals("s")) {
                    p.walk(p, plice);
                    i++;
                } else if (plice.equals("finish")) {
                    throw new Finish();
                } else if (plice.equals("inventry")) {
                    chooseItems(p,scanner);
                } else {
                    System.out.println("a,w,s,dのどれかを選んでください");
                }
                i = event.eventPerson(serve_get_map_code, i, store);
            }
            p.serve_x = p.x;
            p.serve_y = p.y;
            int monsteri = 0;
            while (monsteri == 0) {
                if (random.nextBoolean()) {
                    this.enemey_monster.x = this.enemey_monster.walk(this.enemey_monster.x);
                    monsteri++;
                } else {
                    this.enemey_monster.y = this.enemey_monster.walk(this.enemey_monster.y);
                    monsteri++;
                }
                monsteri = event.eventMonster(monsteri);
            }
            this.enemey_monster.monster_serve_x = this.enemey_monster.x;
            this.enemey_monster.monster_serve_y = this.enemey_monster.y;
            disPlayPlace();
            if (p.x == this.enemey_monster.x && p.y == this.enemey_monster.y && p.area.equals(this.enemey_monster.area)) {
                System.out.println("!");
                System.out.println("モンスターと出会った！！");
                p.turnBattle(enemey_monster,mission_dragon_king);
                enemey_monster = getMonsterRandomly();
                this.enemey_monster.randomNewEnemeyMonster();
            }
        }
    }
    public void disPlayPlace(){
        System.out.println("人間がいる位置は"+p.area+"でⅹ座標" + p.x + "、Y座標" + p.y + "です");
        System.out.println();
        System.out.println("モンスターがいる位置は"+enemey_monster.area+"でⅹ座標" + enemey_monster.x + "、Y座標" + enemey_monster.y + "です");
        System.out.println();
    }
}