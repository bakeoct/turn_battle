package Calc.Item;

import java.io.Serializable;

public class SuperSword extends FightItem implements Serializable {
    public SuperSword(){
        this.name="すごい剣";
        this.buyprice=50;
        this.sellprice=25;
        this.code="supersword";
        this.itemLV = 1;
        this.uphp = 0;
        this.upattack = 10000;
        this.heal = 0;
        this.itemgroup = "attack";
    }
}
