package Monsters;

import Calc.Error.Finish;
import Calc.Item.FightItem;
import Calc.Person2;
import Calc.skill.Skill;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public abstract class Monster2 implements Serializable {
    public int hp;
    public int limit_hp;
    public int mp;
    public int limit_mp;
    public int attack;
    public int defence;
    public int up_leberu;
    public String name;
    public String seibetu;
    public int leberu;
    public boolean is_alive;
    public int judge_sente;
    public Boolean fellow;
    public int can_get_experince_point;
    public int have_experince_point = 0;
    public int need_experince_point = 0;
    public Skill use_skill;
    public ArrayList<Skill> all_skill =new ArrayList<>();

    public String name() {
        return this.name;
    }

    public String seibetu() {
        return this.seibetu;
    }

    public int lv() {
        return this.leberu;
    }

    public static String look(Monster2 monster) {
        return monster.name;
    }

    public static Monster2 getMonsterRandomly() {
        Random random = new Random();
        ArrayList<Monster2> monster2List = new ArrayList<>();
        monster2List.add(new DragonKing());
        monster2List.add(new MetalSlime());
        monster2List.add(new PutiSlime());
        monster2List.add(new Gorlem());
        //0~3 no random na value get
        int randomNum = random.nextInt(monster2List.size());
        return monster2List.get(randomNum);
    }
}