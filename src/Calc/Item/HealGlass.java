package Calc.Item;

public class HealGlass extends FightItem{
    public HealGlass(){
        this.name="薬草";
        this.buyprice=10;
        this.sellprice=5;
        this.code="healglass";
        this.itemLV = 1;
        this.uphp = 0;
        this.upattack = 0;
        this.heal = 500;
        this.itemgroup = "heal";
        this.itemsclass = "fightitem";
    }

    @Override
    public void display() {
        System.out.println("this is HealGlass");
    }

}
