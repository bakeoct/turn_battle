package Calc;

import java.util.Scanner;

public class ex09 {
    public static void main(String[] ares){
        int [] tokute=new int[101];
        String[] namae=new String[101];
        int [] suuryou=new int[101];
        int t=0;
        int i=0;
        int h=0;
        int g=0;
        int s=0;
        int d=0;
        int u=0;
        int gu=0;
        String nd=null;
        String ns=null;
        int endflg=0;
        Scanner sc =new Scanner(System.in);
        while (!(i==101)&&endflg==0) {
            System.out.println("パンの名前");
            namae[i] = sc.next();
            System.out.println("単価");
            tokute[i] = sc.nextInt();
            if (tokute[i] == 999) {
                endflg = 1;
            }else {
                if (tokute[i]<0||tokute[i]>500) {
                    System.out.println("違いまっせ");
                    tokute[i] = 0;
                    namae[i]=null;
                }else {
                    System.out.println("数量");
                    suuryou[i] = sc.nextInt();
                    i++;
                }
            }
        }
        while (!(t>=101)&&!(tokute[t]==999)){
            System.out.println("名前 "+namae[t]);
            System.out.println("単価　"+tokute[t]+"円");
            System.out.println("数量 "+suuryou[t]+"個");
            u=tokute[t]*suuryou[t];
            System.out.println("売上 "+u+"円");
            if (t==0){
                s=u;
                ns=namae[t];
                d=u;
                nd=namae[t];
            }else {
                if (d<u){
                    d=u;
                    nd=namae[t];
                }
                if (s>u){
                    s=u;
                    ns=namae[t];
                }
            }
            g=g+tokute[t];
            gu=gu+u;
            h++;
            t++;
        }
        System.out.println("合計単価"+g+"円");
        System.out.println("合計売上"+gu+"円");
        System.out.println("単価平均"+g/h+"円");
        System.out.println("売り上げ平均"+gu/h+"円");
        System.out.println("最大売り上げのパンの名前"+nd);
        System.out.println("最大売り上げ"+d+"円");
        System.out.println("最小売り上げのパンの名前"+ns);
        System.out.println("最小売り上げ"+s+"円");
        System.out.println("パンの種類数"+h+"個");
    }
}
