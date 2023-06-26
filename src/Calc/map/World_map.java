package Calc.map;

import java.io.Serializable;

import static Calc.map.cave.Cave1.CV1;
import static Calc.map.Map.*;
import static Calc.map.PersonHome1.*;
public class World_map implements Serializable {
    public static String[][] world_map = {
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
}
