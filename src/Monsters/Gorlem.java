package Monsters;

import java.io.Serializable;

public class Gorlem extends Monster2  implements Serializable {
    public Gorlem(){
        this.leberu = 1;
        this.HP=9000;
        this.Attack=70000;
        this.MP=300000;
        this.judgeSente=10;
        this.name="ゴ－レム";
        this.seibetu="なし";
        this.isalive=true;
        this.fellow=true;
        this.can_get_experince_point = 3000;
        this.need_experince_point = 300;
    }
    public static String look(Monster2 monster){
        return monster.name;
    }
}
