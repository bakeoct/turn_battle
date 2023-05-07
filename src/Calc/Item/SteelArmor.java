package Calc.Item;

public class SteelArmor extends Item{
    public SteelArmor(){
        this.name="鋼の防具";
        this.buyprice=50;
        this.sellprice=25;
        this.code="steelarmor";
        this.itemLV = 1;
        this.isalive = false;
        this.uphp = 15000;
        this.upattack = 0;
        this.heal = 0;
        this.itemgroup = "armor";
    }
}
