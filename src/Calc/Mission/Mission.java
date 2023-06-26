package Calc.Mission;

import Calc.Person2;
import Calc.Store;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Mission implements Serializable {
    public int dangerous_lv;
    public int reward;
    public String code;
    public String name;
    public Boolean progress = false;
    public Boolean get_reward = false;
}
