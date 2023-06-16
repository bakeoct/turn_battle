package Calc.Item;

import java.io.Serializable;

public class PutiSlimeMerchandise extends MonsterItem implements Serializable {
    public PutiSlimeMerchandise(){
        this.name="プチスライム";
        this.buyprice=100;
        this.sellprice=50;
        this.code="putislime";
        this.itemLV = 1;
        this.itemgroup = "monster";
    }
}
