package Calc.Item;

import Monsters.*;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Item implements Serializable {
    public String item_group;
    public int item_lv;
    public Boolean have = false;
    public String name;
    public int have_number = 0;
    public int buy_price;
    public int sell_price;
    public String code;
    public int have_point = 0;
    public boolean can_hold;
}
