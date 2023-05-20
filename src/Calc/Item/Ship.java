package Calc.Item;

public class Ship extends FieldItem{
    public Ship(){
        this.name="船";
        this.buyprice=200;
        this.sellprice=100;
        this.code="ship";
        this.itemLV = 999999999;
        this.itemgroup = "move";
        this.itemsclass = "fielditem";
    }

    @Override
    public void display() {
        System.out.println("this is Ship");
    }
}
