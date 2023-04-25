package Calc.study;

public class TryAndCatch {
    public static void main(String[] args) {
        int i=0;
        int j=0;
        while (i==0){
            System.out.println("a");
            while (j==0){
                System.out.println("b");
                break;
            }
        }
        System.out.println("c");
    }
}
