package Calc;

public class Main {

    public static void main(String[] args) {
        String[] C = {"soo1", "soo2", "soo3", "soo4", "soo5"};
        String[] N = {"あんぱん", "カレーパン", "メロンパン", "クリームパン", "フランスパン"};
        int[] T = {150, 200, 160, 140, 300};
        int[] S = {20, 30, 10, 40, 5};
        double DT = 0;
        int d = 0;
        int k=0;
        for (int i = 0; i < 5; i++) {
            if (i == 0) {
                DT = (T[i] * 1.1) * S[i];
                d = i;
            } else {
                if (DT < (T[i] * 1.1) * S[i]) {
                    DT = (T[i] * 1.1) * S[i];
                    d = i;
                }
            }
            if (T[i]>=150){
                System.out.println("単価"+T[i]);
                System.out.println("商品"+N[i]);
                System.out.println("売上"+(T[i]*1.1)*S[i]);
                k=T[i]*S[i];
                System.out.println(k);
            }
        }
        System.out.println("最大売上の単価" + T[d]);
        System.out.println("最大売上の商品" + N[d]);
        System.out.println("最大売上" + DT);

    }
}
