package Calc;

import Calc.Error.Finish;
import Calc.Item.*;
import Calc.Mission.MissionDragonKing;
import Monsters.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
//敵を一回倒したらその敵をエラーの場所以外のどこかへ飛ばしまた倒されたら別の場所にまた飛ばす
public class Game implements Serializable {
    public SuperSword superSword = new SuperSword();
    public PutiSlimeMerchandise puti_slimeMerchandise = new PutiSlimeMerchandise();
    public DragonKingMerchandise dragonKingMerchandise =new DragonKingMerchandise();
    public MetalSlimeMerchandise metalSlimeMerchandise =new MetalSlimeMerchandise();
    public GorlemMerchandise gorlemMerchandise =new GorlemMerchandise();
    public HealGlass healGlass = new HealGlass();
    public SteelArmor steelArmor = new SteelArmor();
    public Ship ship = new Ship();
    public Ladder ladder = new Ladder();
    public Map map =new Map();
    public Person2 p;
    public String point;
    public int servex = 6;
    public int servey = 6;
    public int monsterservex = 6;
    public int monsterservey = 3;
    public ArrayList<Item> items_all = new ArrayList<>();
    public MissionDragonKing missionDragon_king;
    public ArrayList<FightItem> fight_items_all = new ArrayList<FightItem>();
    public ArrayList<MonsterItem> monster_items_all = new ArrayList<MonsterItem>();
    public EnemeyMonster enemeyMonster;
    public ArrayList<Monster2> enemy_monsters;
    public DragonKing dragon_king;

    public Game(Person2 person2, MissionDragonKing missionDragon_king, EnemeyMonster enemeyMonster, ArrayList<Monster2> enemy_monsters, DragonKing dragon_king) {
        this.p = person2;
        this.dragon_king = dragon_king;
        this.missionDragon_king = missionDragon_king;
        this.enemeyMonster = enemeyMonster;
        this.enemy_monsters = enemy_monsters;
        this.items_all.add(ship);
        this.items_all.add(ladder);
        this.items_all.add(puti_slimeMerchandise);
        this.items_all.add(dragonKingMerchandise);
        this.items_all.add(metalSlimeMerchandise);
        this.items_all.add(gorlemMerchandise);
        this.items_all.add(healGlass);
        this.items_all.add(steelArmor);
        this.items_all.add(superSword);
        this.fight_items_all.add(healGlass);
        this.fight_items_all.add(steelArmor);
        this.fight_items_all.add(superSword);
        this.monster_items_all.add(puti_slimeMerchandise);
        this.monster_items_all.add(dragonKingMerchandise);
        this.monster_items_all.add(metalSlimeMerchandise);
        this.monster_items_all.add(gorlemMerchandise);
    }

    public void gameTurn() throws Finish {
        Event event =new Event(p,map,ladder,ship,missionDragon_king,enemeyMonster);
        Store store = new Store(this.p.money);
        Random random = new Random();
        RamdomMonster ramdomMonster = new RamdomMonster();
        Monster2 enemeymonster = ramdomMonster.randomMonsters(enemy_monsters);
        System.out.println("人間がいる位置は"+p.area+"でⅹ座標" + p.position.x + "、Y座標" + p.position.y + "です");
        System.out.println();
        System.out.println("モンスターがいる位置は"+enemeyMonster.area+"でⅹ座標" + enemeyMonster.position.x + "、Y座標" + enemeyMonster.position.y + "です");
        System.out.println();
        while (true) {
            int i = 0;
            while (i == 0) {
                int serve_get_map_code = map.getMapCode(p.position.x, p.position.y, p.area);
                Scanner scanner = new Scanner(System.in);
                String plice = scanner.next();
                if (plice.equals("a") || plice.equals("d")) {
                    p.position.x = p.walkX(p.position.x, plice);
                    i++;
                } else if (plice.equals("w") || plice.equals("s")) {
                    p.position.y = p.walkY(p.position.y, plice);
                    i++;
                } else if (plice.equals("finish")) {
                    throw new Finish();
                } else {
                    System.out.println("a,w,s,dのどれかを選んでください");
                }
                i = event.eventPerson(serve_get_map_code, i, servex, servey, store, items_all, monster_items_all);
            }
            this.servex = p.position.x;
            this.servey = p.position.y;
            p.position = new Position(p.position.x, p.position.y);
            int monsteri = 0;
            while (monsteri == 0) {
                if (random.nextBoolean()) {
                    enemeyMonster.position.x = enemeyMonster.walk(enemeyMonster.position.x);
                    monsteri++;
                } else {
                    enemeyMonster.position.y = enemeyMonster.walk(enemeyMonster.position.y);
                    monsteri++;
                }
                monsteri = event.eventMonster(monsteri,monsterservex,monsterservey);
            }
            this.monsterservex = enemeyMonster.position.x;
            this.monsterservey = enemeyMonster.position.y;
            enemeyMonster.position = new Position(enemeyMonster.position.x, enemeyMonster.position.y);
            System.out.println("人間がいる位置は"+p.area+"でⅹ座標" + p.position.x + "、Y座標" + p.position.y + "です");
            System.out.println();
            System.out.println("モンスターがいる位置は"+enemeyMonster.area+"でⅹ座標" + enemeyMonster.position.x + "、Y座標" + enemeyMonster.position.y + "です");
            System.out.println();
            if (p.position.x == enemeyMonster.position.x && p.position.y == enemeyMonster.position.y && p.area.equals(enemeyMonster.area)) {
                System.out.println("モンスターと出会った！！");
                p.battle(enemeymonster,dragon_king, missionDragon_king);
                enemy_monsters = ramdomMonster.initialization(enemy_monsters);
                enemeymonster = ramdomMonster.randomMonsters(enemy_monsters);
                ramdomMonster.randomNewEnemeyMonster(enemeyMonster);
                enemeyMonster.position = new Position(enemeyMonster.position.x, enemeyMonster.position.y);
            }
        }
    }
}