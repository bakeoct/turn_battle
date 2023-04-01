package Calc;
import java.util.*;
import java.util.Scanner;

public class ex12 {
    public static void main(String[] ares) {
        int[] g=new int[8];
        int[] array = new int[8];
        int[] sn=new int [8];
        String T=null;
        int s = 0;
        int seekflg = 0;
        int e = 0;
        int t = 0;
        int falseflg=0;
        int f=0;
        int y=0;
        int m=0;
        int ere=0;
        int kosyo = 0;
        int errflg = 0;
        String[] b = {"1番目", "2番目", "3番目", "4番目", "5番目", "6番目", "7番目", "8番目"};
        String[] c = {"S001", "S002", "S003", "S004", "S005", "S006", "S007", "S008"};
        String[] d ={"あん","カレー","メロン","チョコ","クリーム","焼きそば","フランス","ソーセージ"};
        int[] k={200,400,500,300,450,250,700,350};
        String[] S = new String[8];
        String[] n = new String[8];
        int[] o=new int[8];
        Scanner sc = new Scanner(System.in);
        while (s < array.length) {
            System.out.println(b[s] + "のコード");
            S[s] = sc.next();
            t=0;
            seekflg=0;
            while (t<c.length && seekflg == 0) {
                if (S[s].equals(c[t])) {
                    seekflg = 1;
                }
                t++;
            }
            if (seekflg == 1) {
                e = 0;
                errflg = 0;
                while (s > e && errflg == 0) {
                    if (S[s].equals(S[e])) {
                        System.out.println("このコードは既に使われております");
                        errflg = 1;
                    }
                    e++;
                }
                if (errflg == 0) {
                    System.out.println(b[s] + "の数字");
                    array[s] = sc.nextInt();
                    s++;
                }
            } else {
                System.out.println("違いまっせ");
            }
        }
        for (int i=0;i< array.length;i++){
            ere=0;
            m=0;
            while (ere==0) {
                if (S[i].equals(c[m])) {
                    n[i]=d[m];
                    o[i]=k[m];
                    g[i]=o[i]*array[i];
                    ere=1;
                }
                m++;
            }
        }
        for (int i=0;i<S.length;i++){
            if (S[i].equals(c[0])){
                sn[i]=1;
            }else {
                if (S[i].equals(c[1])){
                    sn[i]=2;
                }else {
                    if (S[i].equals(c[2])){
                        sn[i]=3;
                    }else {
                        if (S[i].equals(c[3])){
                            sn[i]=4;
                        }else {
                            if (S[i].equals(c[4])){
                                sn[i]=5;
                            }else {
                                if (S[i].equals(c[5])){
                                    sn[i]=6;
                                }else {
                                    if (S[i].equals(c[6])){
                                        sn[i]=7;
                                    }else {
                                        sn[i]=8;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        while (f==0) {
            System.out.println("数量は昇順ですか？「0」、降順ですか？「1」、売上は昇順ですか？「2」、降順ですか？「3」コードは昇順ですか？「4」、降順ですか？「5」");
            kosyo = sc.nextInt();
            if (kosyo == 0) {
                for (int i = 0; i < array.length; i++) {
                    for (int j = i + 1; j < array.length; j++) {
                        if (array[i] > array[j]) {
                            int maxg = g[i];
                            int ming = g[j];
                            g[i] = ming;
                            g[j] = maxg;
                            int maxt = o[i];
                            int mint = o[j];
                            o[i] = mint;
                            o[j] = maxt;
                            String maxs = S[i];
                            String mins = S[j];
                            S[j] = maxs;
                            S[i] = mins;
                            String maxb = b[i];
                            String minb = b[j];
                            b[i] = minb;
                            b[j] = maxb;
                            int max = array[i];
                            int min = array[j];
                            array[j] = max;
                            array[i] = min;
                            f++;
                        }
                    }
                }
            } else {
                if (kosyo == 1) {
                    for (int i = 0; i < array.length; i++) {
                        for (int j = i + 1; j < array.length; j++) {
                            if (array[j] > array[i]) {
                                int maxg = g[j];
                                int ming = g[i];
                                g[j] = ming;
                                g[i] = maxg;
                                int maxt = o[j];
                                int mint = o[i];
                                o[j] = mint;
                                o[i] = maxt;
                                String maxn = n[j];
                                String minn = n[i];
                                n[i] = maxn;
                                n[j] = minn;
                                String maxs = S[j];
                                String mins = S[i];
                                S[i] = maxs;
                                S[j] = mins;
                                String maxb = b[j];
                                String minb = b[i];
                                b[j] = minb;
                                b[i] = maxb;
                                int max = array[j];
                                int min = array[i];
                                array[i] = max;
                                array[j] = min;
                                f++;
                            }
                        }
                    }
                }else {
                        if (kosyo==2){
                            for (int i = 0; i < g.length; i++) {
                                for (int j = i + 1; j < g.length; j++) {
                                    if (g[i] > g[j]) {
                                        int maxg = g[i];
                                        int ming = g[j];
                                        g[i] = ming;
                                        g[j] = maxg;
                                        int maxt = o[i];
                                        int mint = o[j];
                                        o[i] = mint;
                                        o[j] = maxt;
                                        String maxs = S[i];
                                        String mins = S[j];
                                        S[j] = maxs;
                                        S[i] = mins;
                                        String maxb = b[i];
                                        String minb = b[j];
                                        b[i] = minb;
                                        b[j] = maxb;
                                        int max = array[i];
                                        int min = array[j];
                                        array[j] = max;
                                        array[i] = min;
                                        f++;
                                    }
                                }
                            }
                        }else {
                            if (kosyo==3) {
                                for (int i = 0; i < g.length; i++) {
                                    for (int j = i + 1; j < g.length; j++) {
                                        if (g[j]>g[i]) {
                                            int maxg = g[j];
                                            int ming = g[i];
                                            g[j] = ming;
                                            g[i] = maxg;
                                            int maxt = o[j];
                                            int mint = o[i];
                                            o[j] = mint;
                                            o[i] = maxt;
                                            String maxn = n[j];
                                            String minn = n[i];
                                            n[i] = maxn;
                                            n[j] = minn;
                                            String maxs = S[j];
                                            String mins = S[i];
                                            S[i] = maxs;
                                            S[j] = mins;
                                            String maxb = b[j];
                                            String minb = b[i];
                                            b[j] = minb;
                                            b[i] = maxb;
                                            int max = array[j];
                                            int min = array[i];
                                            array[i] = max;
                                            array[j] = min;
                                            f++;
                                        }
                                    }
                                }
                            }else {
                                if (kosyo==4){
                                    for (int i = 0; i < sn.length; i++) {
                                        for (int j = i + 1; j < sn.length; j++) {
                                            if (sn[i] > sn[j]) {
                                                int maxg = g[i];
                                                int ming = g[j];
                                                g[i] = ming;
                                                g[j] = maxg;
                                                int maxt = o[i];
                                                int mint = o[j];
                                                o[i] = mint;
                                                o[j] = maxt;
                                                String maxs = S[i];
                                                String mins = S[j];
                                                S[j] = maxs;
                                                S[i] = mins;
                                                String maxb = b[i];
                                                String minb = b[j];
                                                b[i] = minb;
                                                b[j] = maxb;
                                                int max = array[i];
                                                int min = array[j];
                                                array[j] = max;
                                                array[i] = min;
                                                int maxq=sn[i];
                                                int minq=sn[j];
                                                sn[i]=minq;
                                                sn[j]=maxq;
                                                f++;
                                            }
                                        }
                                    }
                                }else {
                                    if (kosyo==5){
                                        for (int i = 0; i < sn.length; i++) {
                                            for (int j = i + 1; j < sn.length; j++) {
                                                if (sn[j]>sn[i]) {
                                                    int maxg = g[j];
                                                    int ming = g[i];
                                                    g[j] = ming;
                                                    g[i] = maxg;
                                                    int maxt = o[j];
                                                    int mint = o[i];
                                                    o[j] = mint;
                                                    o[i] = maxt;
                                                    String maxn = n[j];
                                                    String minn = n[i];
                                                    n[j] = minn;
                                                    n[i] = maxn;
                                                    String maxs = S[j];
                                                    String mins = S[i];
                                                    S[j] = mins;
                                                    S[i] = maxs;
                                                    String maxb = b[j];
                                                    String minb = b[i];
                                                    b[j] = minb;
                                                    b[i] = maxb;
                                                    int max = array[j];
                                                    int min = array[i];
                                                    array[j] = min;
                                                    array[i] = max;
                                                    int maxq=sn[j];
                                                    int minq=sn[i];
                                                    sn[j]=minq;
                                                    sn[i]=maxq;
                                                    f++;
                                                }
                                            }
                                        }
                                    }else {
                                        System.out.println("違うぞーー");
                                    }
                                }
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < array.length; i++) {
                System.out.println("コード" + S[i] + "　"+ "商品名"+n[i]+" " + b[i] + "数量"+array[i]+"×"+"単価"+o[i] +"="+g[i]+ "  ");
            }
            System.out.println("コードは？");
            T=sc.next();
            while (y<array.length&&falseflg==0){
                if (T.equals(S[y])){
                    System.out.println("コード" + S[y] + "　"+ "商品名"+n[y]+" " + b[y] + "数量"+array[y]+"×"+"単価"+o[y] +"="+g[y]);
                    falseflg++;
                }
                if (T.equals("S999")){
                    for (int i = 0; i < array.length; i++) {
                        for (int j = i + 1; j < array.length; j++) {
                            if (array[i] > array[j]) {
                                int maxg = g[i];
                                int ming = g[j];
                                g[i] = ming;
                                g[j] = maxg;
                                int maxt = o[i];
                                int mint = o[j];
                                o[i] = mint;
                                o[j] = maxt;
                                String maxs = S[i];
                                String mins = S[j];
                                S[j] = maxs;
                                S[i] = mins;
                                String maxb = b[i];
                                String minb = b[j];
                                b[i] = minb;
                                b[j] = maxb;
                                int max = array[i];
                                int min = array[j];
                                array[j] = max;
                                array[i] = min;
                            }
                        }
                    }
                    for (int i = 0; i < array.length; i++) {
                        System.out.println("コード" + S[i] + "　"+ "商品名"+n[i]+" " + b[i] + "数量"+array[i]+"×"+"単価"+o[i] +"="+g[i]+ "  ");
                    }
                    falseflg++;
                }
                if (y== array.length-1&&falseflg==0){
                    y=-1;
                    System.out.println("違いまっせ");
                    System.out.println("コードは？");
                    T=sc.next();
                }
                y++;
            }
        }
    }