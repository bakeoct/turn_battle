package Calc.study;

import java.io.*;

public class ReaderAndWriter {
    public static void main(String[] args){
        try {
            File file =new File("C:\\Users\\2009t\\IdeaProjects\\ex001\\src\\Calc\\save\\Save.txt");
            BufferedWriter file_save_writer = new BufferedWriter(new FileWriter(file));
            if (!file.canWrite()){
                file.setWritable(true);
            }
            file_save_writer.write("a");
            file_save_writer.close();
            BufferedReader file_save_Reader = new BufferedReader(new FileReader(file));
            if (!file.canRead()) {
                file.setReadable(true);
            }
            System.out.println(file_save_Reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}