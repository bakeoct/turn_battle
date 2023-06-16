package Calc.Item;

import java.io.Serializable;

public class GorlemMerchandise  extends MonsterItem implements Serializable {
    public GorlemMerchandise(){
        this.name="ゴーレム";
        this.buyprice=200;
        this.sellprice=100;
        this.code="gorlem";
        this.itemLV = 1;
        this.itemgroup = "monster";
    }
}
