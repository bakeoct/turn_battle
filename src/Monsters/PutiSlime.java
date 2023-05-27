package Monsters;

import java.io.Serializable;

public class PutiSlime extends Monster2 implements Serializable {
    public PutiSlime(){
        this.leberu = 1;
        this.HP = 398;
        this.Attack=50000000;
        this.MP=7;
        this.judgeSente=7000000;
        this.name="プチスライム";
        this.seibetu="?";
        this.isalive=true;
        this.fellow=false;
        this.can_get_experince_point = 2000;
        this.need_experince_point = 50;
    }
    public static String look(Monster2 monster){
        return monster.name;
    }
}
