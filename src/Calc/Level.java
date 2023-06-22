package Calc;

import Monsters.Monster2;

import java.io.Serializable;

public class Level implements Serializable {
    public void upLevel(Person2 p){
        while (true) {
            boolean endflg = true;
            if (p.have_experince_point >= p.need_experince_point) {
                p.LV++;
                p.have_experince_point -= p.need_experince_point;
                p.need_experince_point *= 2;
                endflg = false;
            }
            for (Monster2 monster2 : p.monsters2) {
                if (monster2.have_experince_point >= monster2.need_experince_point) {
                    monster2.leberu++;
                    monster2.have_experince_point -= monster2.need_experince_point;
                    monster2.need_experince_point *= 2;
                    endflg = false;
                }
            }
            if (endflg) {
                break;
            }
        }
        for (Monster2 monster2 : p.monsters2) {
            for (int i = 1; i < monster2.leberu; i++) {
                monster2.HP *= 1.5;
                monster2.MP *= 1.5;
                monster2.Attack *= 1.3;
                monster2.judgeSente *= 1.3;
            }
        }
    }
}
