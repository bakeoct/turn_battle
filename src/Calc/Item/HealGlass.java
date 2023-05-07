package Calc.Item;

public class HealGlass extends Item{
    public HealGlass(){
        this.name="薬草";
        this.buyprice=10;
        this.sellprice=5;
        this.code="healglass";
        this.itemLV = 1;
        this.isalive = false;
        this.uphp = 0;
        this.upattack = 0;
        this.heal = 500;
        this.use = true;
        this.itemgroup = "heal";
    }
}
