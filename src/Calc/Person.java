package Calc;

import java.util.ArrayList;

public class Person {
    public int position;
    public ArrayList<Monster> monsters;
    public String name;
    public String seibetu;

    public Person(String namae,String seibetu2,ArrayList<Monster> monsters2){
        this.position=0;
        this.name=namae;
        this.monsters=monsters2;
        this.seibetu=seibetu2;
        if (this.seibetu.equals("dannsei")){
            System.out.print(namae+"くんが戦っているのは");
        }
        if (this.seibetu.equals("josei")){
            System.out.print(namae+"さんが戦っているのは");
        }
        if (!(this.seibetu.equals("dannsei") || this.seibetu.equals("josei"))){
            System.out.println("(josei)または(dannsei)を入力してください。");
        }
    }
    public int walk(){
        this.position++;
        return this.position;
    }
}
