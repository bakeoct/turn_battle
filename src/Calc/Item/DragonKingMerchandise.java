package Calc.Item;

import java.io.Serializable;

public class DragonKingMerchandise  extends MonsterItem implements Serializable {
    public DragonKingMerchandise(){
        this.name="竜王";
        this.buyprice=1000;
        this.sellprice=500;
        this.code="dragonking";
        this.itemLV = 1;
        this.itemgroup = "monster";
        this.itemsclass = "monsteritem";
    }
}
