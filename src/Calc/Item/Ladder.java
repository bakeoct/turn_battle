package Calc.Item;

import java.io.Serializable;

public class Ladder extends FieldItem implements Serializable {
    public Ladder(){
        this.name="梯子";
        this.buyprice=200;
        this.sellprice=100;
        this.code="ladder";
        this.itemLV = 999999999;
        this.itemgroup = "move";
        this.itemsclass = "fielditem";
    }
}
