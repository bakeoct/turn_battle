package Calc;

import java.io.Serializable;
import java.util.ArrayList;
    //名前をMAPにさせる
    public class Map implements Serializable {
        public final int TL = 5;//TreasureChest(Ladder)
        public final int TS = 4;//TreasureChest(Ship)
        public final int O = 3;//Ocean
        public final int M = 2;//Mounten
        public final int C = 1;//Cliff
        public final int G = 0;//Glass
        public final int E = -1;//ErrerPoint
        public final int S = 6;//Store
        public final int BW = 7;//BackWorld
        public final int W = 8;//wood
        public final int PH1 = 9;//peopleHome1
        public int[][] world_map = {
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
                {E, M, M, M, PH1, M, M, M, M, M, M, M, E},
                {E, M, M, M, M, M, M, M, TS, M, M, M, E},
                {E, E, E, E, E, E, E, E, E, E, E, E, E}
        };
        public int[][] people_home1 = {
                {E,E,E,E,E,E,E,E,E},
                {E,W,W,W,W,W,W,W,E},
                {E,W,W,W,W,W,W,W,E},
                {E,W,W,W,W,W,W,W,E},
                {E,W,W,W,W,W,W,W,E},
                {E,W,W,W,W,W,W,W,E},
                {E,W,W,W,W,W,W,W,E},
                {E,W,W,W,W,W,W,W,E},
                {E,E,E,E,BW,E,E,E,E},
        };
        public int getMapCode(int pointx, int pointy,String area) {
            int map = 0;
            if (area.equals("メインマップ")){
                map = this.world_map[pointy][pointx];
            }else if (area.equals("民家1")){
                map = this.people_home1[pointy][pointx];
            }
            return map;
        }
        public int[] getRange(String area){
            int[] map =new int[2];
            if (area.equals("メインマップ")){
                map[0] = 12;
                map[1] = 12;
            }else if (area.equals("民家1")){
                map[0] = 8;
                map[1] = 8;
            }
            return map;
        }
    }
