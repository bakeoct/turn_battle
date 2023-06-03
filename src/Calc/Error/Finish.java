package Calc.Error;

import Calc.Person2;
import Monsters.EnemeyMonster;

import java.util.ArrayList;

public class Finish extends Exception {
    public static final long serialVersionUID = 1L;
    public SaveWriteAndRead saveWriteAndRead = new SaveWriteAndRead();
    public void write(ArrayList<String> write_memorys, Person2 p, EnemeyMonster enemeyMonster){
        saveWriteAndRead.write(write_memorys,p,enemeyMonster);
    }
    public ArrayList<String> Read(ArrayList<String> string_read_memorys){
        string_read_memorys=saveWriteAndRead.read(string_read_memorys);
        return string_read_memorys;
    }
}
