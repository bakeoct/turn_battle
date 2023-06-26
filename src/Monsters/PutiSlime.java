package Monsters;

import java.io.Serializable;

public class PutiSlime extends Monster2 implements Serializable {
    public PutiSlime(){
        this.leberu = 1;
        this.hp = 398;
        this.attack=50000000;
        this.mp=7;
        this.judge_sente=7000000;
        this.name="プチスライム";
        this.seibetu="?";
        this.is_alive=true;
        this.fellow=false;
        this.can_get_experince_point = 2000;
        this.need_experince_point = 50;
    }
    public static String look(Monster2 monster){
        return monster.name;
    }
}
