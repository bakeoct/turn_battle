package Calc.Mission;

import Calc.Person2;
import Calc.Store;

import java.io.Serializable;
import java.util.ArrayList;

public class Mission implements Serializable {
    public int dangerousLV;
    public int reward;
    public String code;
    public String name;
    public Boolean progress = false;
    public Boolean getreward = false;
}
