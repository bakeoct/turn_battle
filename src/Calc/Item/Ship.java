package Calc.Item;

import java.io.Serializable;

public class Ship extends FieldItem implements Serializable {
    public Ship(){
        this.name="船";
        this.buyprice=200;
        this.sellprice=100;
        this.code="ship";
        this.itemLV = 999999999;
        this.itemgroup = "move";
    }
}
