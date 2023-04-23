package Calc.study;
import java.util.Scanner;
public class ex06 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("数学得点");
        int in_suugaku=sc.nextInt();
        System.out.print("英語得点");
        int in_eigo=sc.nextInt();
        System.out.print("国語得点");
        int in_kokugo=sc.nextInt();
        String [] k={"数学","英語","国語"};
        int d=0;
        int s=0;
        String nd=null;
        String ns=null;
        int [] T={in_suugaku,in_eigo,in_kokugo};
        for (int i=0;i<3;i++){
            if (i==0){
                d=T[i];
                nd=k[i];
                s=T[i];
                ns=k[i];
            }else {
                if (d<T[i]){
                    d=T[i];
                    nd=k[i];
                }
                if (s>T[i]){
                    s=T[i];
                    ns=k[i];
                }
            }
        }
        System.out.println("数学は"+in_suugaku+"点です。");
        System.out.println("英語は"+in_eigo+"点です。");
        System.out.println("国語は"+in_kokugo+"点です。");
        System.out.println("最大値"+d);
        System.out.println("最大値の教科"+nd);
        System.out.println("最小値"+s);
        System.out.println("最小値の教科"+ns);
    }
}
