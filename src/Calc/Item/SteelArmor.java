package Calc.Item;

import java.io.Serializable;

public class SteelArmor extends FightItem implements Serializable {
    public SteelArmor(){
        this.name="鋼の防具";
        this.buyprice=50;
        this.sellprice=25;
        this.code="steelarmor";
        this.itemLV = 1;
        this.uphp = 15000;
        this.itemgroup = "armor";
    }
}
