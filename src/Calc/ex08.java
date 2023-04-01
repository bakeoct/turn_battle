package Calc;

import java.util.Scanner;

public class ex08 {
    public static void main(String[] ares){
        int [] tokutenn=new int[101];
        int t=0;
        Scanner sc =new Scanner(System.in);
        for (int i=0;i<101;i++){
            System.out.println("得点");
            tokutenn[i]=sc.nextInt();
        }
        while (!(tokutenn[t]==999)){
            System.out.println(tokutenn[t]);
            t++;
        }
    }
}
