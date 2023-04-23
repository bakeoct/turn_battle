package Calc.study;

import java.util.Scanner;

public class ex11 {
    public static void main(String[] ares){
        String[] code={"S001","S002","S003","S004","S005"};
        String[] name={"あんぱん","カレーパン","クリームパン","フランスパン","メロンパン"};
        int[] g=new int[5];
        int[] tank={100,200,150,300,250};
        String[] c=new String[100];
        int[] u=new int[100];
        int i=0;
        int t=0;
        int s1=0;
        int s2=0;
        int s3=0;
        int s4=0;
        int s5=0;
        int endflg=0;
        int h=0;
        String nd=null;
        int d=0;
        String ns=null;
        int s=0;
        int goukei=0;
        Scanner sc=new Scanner(System.in);
        while (i<100&&endflg==0){
            System.out.println("商品コード");
            c[i]=sc.next();
            if (c[i].equals("S999")){
                endflg=1;
            }else {
                if (c[i].equals("S001")||c[i].equals("S002")||c[i].equals("S003")||c[i].equals("S004")||c[i].equals("S005")){
                    System.out.println("数量");
                    u[i]=sc.nextInt();
                    i++;
                }else {
                    System.out.println("違いまっせ");
                    c[i]=null;
                }
            }
        }
        while (t<100&&!(c[t].equals("S999"))){
        if (c[t].equals("S001"))s1=s1+u[t];
        else if (c[t].equals("S002")) s2=s2+u[t];
        else if (c[t].equals("S003")) s3=s3+u[t];
        else if (c[t].equals("S004")) s4=s4+u[t];
        else if (c[t].equals("S005"))s5=s5+u[t];
        t++;
        }
        for (int l=0;l<5;l++){
            if (l==0)g[l]=s1*tank[l];
            else if (l==1) g[l]=s2*tank[l];
            else if (l==2) g[l]=s3*tank[l];
            else if (l==3) g[l]=s4*tank[l];
            else g[l]=s5*tank[l];
            if (l==0){
                ns=name[l];
                s=g[l];
                nd=name[l];
                d=g[l];
            }else {
                if (d<g[l]){
                    d=g[l];
                    nd=name[l];
                }
                if (s>g[l]){
                    s=g[l];
                    ns=name[l];
                }
            }
            goukei=goukei+g[l];
            h++;
        }
            System.out.println(code[0] + " " + name[0]+" "+tank[0]+"×"+s1+"=" + tank[0]*s1);
            System.out.println(code[1] + " " + name[1]+" "+tank[1]+"×"+s2+"=" + tank[1]*s2);
            System.out.println(code[2] + " " + name[2]+" "+tank[2]+"×"+s3+"=" + tank[2]*s3);
            System.out.println(code[3] + " " + name[3]+" "+tank[3]+"×"+s4+"=" + tank[3]*s4);
            System.out.println(code[4] + " " + name[4]+" "+tank[4]+"×"+s5+"=" + tank[4]*s5);
            System.out.println("売上合計"+goukei);
            System.out.println("売上平均"+goukei/h);
            System.out.println("最大値"+d);
            System.out.println("最大値のパンの名前"+nd);
            System.out.println("最小値"+s);
            System.out.println("最小値のパンの名前"+ns);
    }
}
