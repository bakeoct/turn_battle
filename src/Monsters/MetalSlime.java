package Monsters;

import java.io.Serializable;

public class MetalSlime extends Monster2  implements Serializable{
    public MetalSlime(){
        this.HP = 50;
        this.leberu = 0;
        this.Attack=6000;
        this.MP=80000;
        this.judgeSente=20;
        this.name="メタルスライム";
        this.seibetu="?";
        this.isalive=true;
        this.fellow=true;
    }
    public static String look(Monster2 monster){
        return monster.name;
    }
}
