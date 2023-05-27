package Monsters;

import java.io.Serializable;

public class MetalSlime extends Monster2  implements Serializable{
    public MetalSlime(){
        this.HP = 50;
        this.leberu = 1;
        this.Attack=6000;
        this.MP=80000;
        this.judgeSente=20;
        this.name="メタルスライム";
        this.seibetu="?";
        this.isalive=true;
        this.fellow=true;
        this.can_get_experince_point = 500;
        this.need_experince_point = 100;
    }
    public static String look(Monster2 monster){
        return monster.name;
    }
}
