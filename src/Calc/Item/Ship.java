package Calc.Item;

public class Ship extends Item{
    public Ship(){
        this.name="船";
        this.buyprice=200;
        this.sellprice=100;
        this.code="ship";
        this.itemLV = 999999999;
        this.isalive = false;
        this.uphp = 0;
        this.upattack = 0;
        this.heal = 0;
    }
}
