package Calc;

import java.util.ArrayList;

public class Notgo {
    public ArrayList<Integer> oceanx =new ArrayList<Integer>();
    public ArrayList<Integer> oceany =new ArrayList<Integer>();
    public ArrayList<Integer> cliffx =new ArrayList<Integer>();
    public ArrayList<Integer> cliffy =new ArrayList<Integer>();
    public ArrayList<Integer> mountenx =new ArrayList<Integer>();
    public ArrayList<Integer> mounteny =new ArrayList<Integer>();
    public Notgo(){
        this.oceanx.add(0);
        this.oceany.add(1);
    }
    public Boolean notpoint(ArrayList<Integer> notgolist,int point){
        Boolean nogo=false;
        for (int j : notgolist){
            if (j==point) {
                nogo=true;
                break;
            }
        }
        return nogo;
    }
}
