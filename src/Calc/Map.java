package Calc;

import java.util.ArrayList;
    //名前をMAPにさせる
    public class Map {
        public final int TL = 5;//TreasureChest(Ladder)
        public final int TS = 4;//TreasureChest(Ship)
        public final int O = 3;//Ocean
        public final int M = 2;//Mounten
        public final int C = 1;//Cliff
        public final int G = 0;//Glass
        public final int E = -1;//Errerpoint
        public final int S = 6;//Store
        public int[][] map = {
                {E, E, E, E, E, E, E, E, E, E, E, E, E},
                {E, O, O, O, O, O, O, O, O, O, O, O, E},
                {E, O, O, O, O, G, G, O, O, O, O, O, E},
                {E, O, O, O, G, G, G, G, O, O, O, O, E},
                {E, O, G, G, G, G, G, G, G, G, O, O, E},
                {E, G, G, G, S, G, G, G, TL, G, O, O, E},
                {E, G, G, G, G, G, G, G, G, G, G, G, E},
                {E, G, G, G, G, G, G, G, G, G, G, G, E},
                {E, C, C, C, C, C, C, C, C, C, C, C, E},
                {E, C, C, M, M, M, M, M, M, C, C, C, E},
                {E, M, M, M, M, M, M, M, M, M, M, M, E},
                {E, M, M, M, M, M, M, M, TS, M, M, M, E},
                {E, E, E, E, E, E, E, E, E, E, E, E, E}
        };

        public int notpoint(int pointx, int pointy) {
            int nogo = 0;
            if (1 == this.map[pointy][pointx]) {
                nogo = 1;
            } else {
                if (2 == this.map[pointy][pointx]) {
                    nogo = 2;
                } else {
                    if (3 == this.map[pointy][pointx]) {
                        nogo = 3;
                    } else {
                        if (4 == this.map[pointy][pointx]) {
                            nogo = 4;
                        } else {
                            if (5 == this.map[pointy][pointx]) {
                                nogo = 5;
                            }else {
                                if (6 == this.map[pointy][pointx]) {
                                    nogo = 6;
                                } else{
                                    if (-1 == this.map[pointy][pointx]) {
                                        nogo = -1;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return nogo;
        }
    }
