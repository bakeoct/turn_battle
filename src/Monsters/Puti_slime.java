package Monsters;

public class Puti_slime extends Monster2{
    public Puti_slime(){
        this.leberu = 300;
        this.HP = 398;
        this.Attack=50000000;
        this.MP=700000000;
        this.judgeSente=7000000;
        this.name="プチスライム";
        this.seibetu="?";
        this.isalive=true;
        this.fellow=false;
    }
    public static String look(Monster2 monster){
        return monster.name;
    }
}
