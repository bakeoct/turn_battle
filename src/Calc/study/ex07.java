package Calc.study;

import java.util.Scanner;

public class ex07 {
    public static void main(String[] ares){
        int [] Tensu=new int[5];
        String [] namae=new String[5];
        Scanner sc = new Scanner(System.in);
        int gt=0;
        String nd=null;
        int td=0;
        String ns=null;
        int ts=0;
        int h=0;
        for (int i=0;i<5;i++){
            System.out.print("点数");
            Tensu[i]=sc.nextInt();
            System.out.print("名前");
            namae[i]= sc.next();
        }
        for (int i=0;i<5;i++){
            System.out.println("点数"+Tensu[i]);
            System.out.println("名前"+namae[i]);
            gt=gt+Tensu[i];
            h++;
        }
        for (int i=0;i<5;i++){
            if (i==0){
                nd=namae[i];
                td=Tensu[i];
                ns=namae[i];
                ts=Tensu[i];
            }else {
                if (td<Tensu[i]){
                    nd=namae[i];
                    td=Tensu[i];
                }
                if (ts>Tensu[i]){
                    ns=namae[i];
                    ts=Tensu[i];
                }
            }

        }
        System.out.println("合計点数"+gt);
        System.out.println("平均"+gt/h);
        System.out.println("最大値"+td);
        System.out.println("最大値の名前"+nd);
        System.out.println("最小値"+ts);
        System.out.println("最小値の名前"+ns);
    }
}
