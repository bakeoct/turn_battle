package Calc;

import java.io.Serializable;
import java.util.ArrayList;
    //名前をMAPにさせる
    public class Map implements Serializable {
        public final String TL = "treasure_chest_ladder";
        public final String TS = "treasure_chest_ship";
        public final String O = "海";//Ocean
        public final String M = "山";//Mounten
        public final String C = "崖";//Cliff
        public final String G = "glass";//Glass
        public final String E = "errer";//ErrerPoString
        public final String S = "store";//Store
        public final String BW = "back_world";//BackWorld
        public final String W = "wood";//wood
        public final String PH1 = "people_home_1";//peopleHome1
        public final String SN = "stone";//Stone;
        public final String CV1 = "cave1";//Cave1;
        public final String CV1_1 = "cave1_1";//Cave1_1;
        public final String BCV1 = "back_cave_1";//BackCave1;
        public String[][] world_map = {
                {E, E, E, E, E, E, E, E, E, E, E, E, E},
                {E, O, O, O, O, O, O, O, O, O, O, O, E},
                {E, O, O, O, O, G, G, O, O, O, O, O, E},
                {E, O, O, O, G, G, G, G, O, O, O, O, E},
                {E, O, G, G, G, G, G, G, G, G, O, O, E},
                {E, G, G, G, S, G, G, G, TL, G, O, O, E},
                {E, G, G, G, G, G, G, G, G, G, G, G, E},
                {E, G, G, G, G, G, G, G, G, G, G, G, E},
                {E, C, C, C, C, C, C, C, C, C, C, C, E},
                {E, C, C, M, M, M, M, M, M, C, C, CV1, E},
                {E, M, M, M, PH1, M, M, M, M, M, M, M, E},
                {E, M, M, M, M, M, M, M, TS, M, M, M, E},
                {E, E, E, E, E, E, E, E, E, E, E, E, E}
        };
        public String[][] cave1 = {
                {E,E,CV1_1,E,E},
                {E,SN,SN,SN,E},
                {E,SN,SN,SN,E},
                {E,SN,SN,SN,E},
                {E,SN,SN,SN,E},
                {E,SN,SN,SN,E},
                {E,SN,SN,SN,E},
                {E,SN,SN,SN,E},
                {E,E,BW,E,E},
        };
        public String[][] people_home1 = {
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
        public String[][] cave1_1 = {
                {E,E,E,E,E,E,E,E,E},
                {E,SN,SN,SN,SN,SN,SN,SN,E},
                {E,SN,SN,SN,SN,SN,SN,SN,E},
                {E,SN,SN,SN,SN,SN,SN,SN,E},
                {E,SN,SN,SN,SN,SN,SN,SN,E},
                {E,SN,SN,SN,E,E,E,E,E,E,E},
                {E,SN,SN,SN,E,E,E,E,E,E,E},
                {E,SN,SN,SN,E,E,E,E,E,E,E},
                {E,E,BCV1,E,E,E,E,E,E},
        };
        public String getMapCode(int pointx, int pointy,String area) {
            String map = null;
            if (area.equals("メインマップ")){
                map = this.world_map[pointy][pointx];
            }else if (area.equals("民家1")){
                map = this.people_home1[pointy][pointx];
            }else if (area.equals("洞窟1")){
                map = this.cave1[pointy][pointx];
            }else if (area.equals("洞窟1_1")){
                map = this.cave1_1[pointy][pointx];
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
            }else if (area.equals("洞窟1")){
                map[0] = 4;
                map[1] = 8;
            }else if (area.equals("洞窟1_1")){
                map[0] = 8;
                map[1] = 8;
            }
            return map;
        }
    }
