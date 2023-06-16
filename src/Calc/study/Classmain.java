package Calc.study;

import Calc.Error.Finish;
import Calc.Person2;
import Monsters.Gorlem;
import Monsters.MetalSlime;
import Monsters.Monster2;

public class Classmain {
    public static void main(String[] args){
        MetalSlime metalSlime =new MetalSlime();
        metalSlime.name = "1";
        MetalSlime metalSlime1 =new MetalSlime();
        Gorlem gorlem =new Gorlem();
        metalSlime.attack(metalSlime1);
            System.out.println(metalSlime.HP);
    }
}
