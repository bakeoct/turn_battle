package Calc;

import java.util.Random;

public class sab1 {
    final static double PI = 3.14;
    public static void main(int n) {
        Random random = new Random();
        n = random.nextInt(4);
        System.out.println(n);
        if (n==0){
            System.out.println("0を解禁");
        }else {
            if (n==1){
                System.out.println("1を解禁");
            }else {
                if (n==2){
                    System.out.println("2を解禁");
                }else {
                    if(n==3){
                        System.out.println("３を解禁");
                    }else {
                        System.out.println("4を解禁");
                    }
                }
            }
        }
    }
    public static  void en(double I,int O){
        I=I*PI+O;
        System.out.println(I);
    }
}
