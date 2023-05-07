package Calc.Item;

public class SuperSword extends Item{
    public SuperSword(){
        this.name="すごい剣";
        this.buyprice=50;
        this.sellprice=25;
        this.code="supersword";
        this.itemLV = 1;
        this.isalive = false;
        this.uphp = 0;
        this.upattack = 10000;
        this.heal = 0;
        this.itemgroup = "attack";
    }
}
