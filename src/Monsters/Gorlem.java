package Monsters;

public class Gorlem extends Monster2{
    public Gorlem(){
        this.leberu = 30;
        this.HP=9000;
        this.Attack=70000;
        this.MP=300;
        this.judgeSente=10;
        this.name="ゴ－レム";
        this.seibetu="なし";
        this.isalive=true;
        this.fellow=true;
    }

    public static int[] battle(Monster2 monster1,Monster2 monster2) {
        return Monster2.battle(monster1,monster2);
    }
    public static String look(Monster2 monster){
        return monster.name;
    }
}
