package Calc.Item.monsteritem;

import Calc.Item.MonsterItem;

import java.io.Serializable;

public class MetalSlimeMerchandise  extends MonsterItem implements Serializable {
    public MetalSlimeMerchandise(){
        this.name="メタルスライム";
        this.buyprice=300;
        this.sellprice=150;
        this.code="metalslime";
        this.itemLV = 1;
        this.itemgroup = "monster";
    }
}
