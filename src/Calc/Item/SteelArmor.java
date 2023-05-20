package Calc.Item;

public class SteelArmor extends FightItem{
    public SteelArmor(){
        this.name="鋼の防具";
        this.buyprice=50;
        this.sellprice=25;
        this.code="steelarmor";
        this.itemLV = 1;
        this.uphp = 15000;
        this.upattack = 0;
        this.heal = 0;
        this.itemgroup = "armor";
        this.itemsclass = "fightitem";
    }
    @Override
    public void display() {
        System.out.println("this is SteelArmor");
    }
}
