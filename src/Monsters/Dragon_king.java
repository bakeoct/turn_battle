package Monsters;

import Calc.Person2;
import Calc.Position;

import java.io.Serializable;
import java.util.Random;

public class Dragon_king extends Monster2 {
    public Dragon_king() {
        this.HP=20000000;
        this.MP=200;
        this.judgeSente=7000;
        this.name="竜王";
        this.Attack=300000000;
        this.seibetu="男性";
        this.leberu=1;
        this.isalive=true;
        this.fellow=false;
    }
    public static String look(Monster2 monster){
        return monster.name;
    }
    public Boolean change(){
        return this.fellow=true;
    }
}
