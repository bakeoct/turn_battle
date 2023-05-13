package Calc.Error;

import Calc.save.SaveWriteAndRead;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class Finish extends Exception {
    public static final long serialVersionUID = 1L;
    public SaveWriteAndRead saveWriteAndRead = new SaveWriteAndRead();
    public void Write(ArrayList<String> write_memorys){
        saveWriteAndRead.write(write_memorys);
    }
    public ArrayList<String> Read(ArrayList<String> string_read_memorys,ArrayList<Integer> int_read_memory){
        read_memorys=saveWriteAndRead.read(string_read_memorys,int_read_memory);
        return read_memorys;
    }
}
