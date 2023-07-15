package Calc;

import Calc.Error.Finish;

import java.io.Serializable;
import java.util.Scanner;

public class Inventry implements Serializable {
    public static void chooseItems(Person2 p,Scanner scanner) throws Finish {
        int end_flg = 0;
        while (end_flg == 0){
            end_flg = 0;
            for (int i = 0; i < p.items.size(); i++) {
                System.out.println(p.items.get(i).name + " " + p.items.get(i).have_point + "個 [" + p.items.get(i).code + "]");
            }
            System.out.println("何も持たない　[nothave]");
            System.out.println("戻る　[goback]");
            String use_items = scanner.next();
            for (int i = 0; i < p.items.size(); i++) {
                if (use_items.equals(p.items.get(i).code)) {
                    p.have_item = p.items.get(i);
                    System.out.println(p.have_item.name+"を手に持った");
                    end_flg++;
                }
            }
            if (use_items.equals("nothave")) {
                if (p.have_item == null) {
                    System.out.println("しかし何も持っていなかった");
                }else {
                    System.out.println(p.have_item.name + "をしまった");
                }
                end_flg++;
                p.have_item = null;
            }else if (use_items.equals("goback")){
                    end_flg++;
                    System.out.println("インベントリから去った");
            }else if (use_items.equals("finish")){
                    throw new Finish();
            }else if (end_flg == 0){
                    System.out.println("インベントリの中から選んでください");
            }
        }
    }
}
