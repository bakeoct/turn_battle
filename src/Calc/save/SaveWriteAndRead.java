package Calc.save;

import java.io.*;
import java.util.ArrayList;

public class SaveWriteAndRead {
    public File file =new File("C:\\Users\\2009t\\IdeaProjects\\ex001\\src\\Calc\\save\\Save.txt");
    public BufferedWriter save_file_write;
    public BufferedReader save_file_read;
    public void write(ArrayList<String> write_memorys){
        try {
            file.delete();
            save_file_write = new BufferedWriter(new FileWriter(file));
            if (!file.canWrite()){
                file.setWritable(true);
            }
            for (String memory : write_memorys){
                save_file_write.write(memory);
                save_file_write.newLine();
            }
            save_file_write.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<String> read(ArrayList<String> string_read_memory,ArrayList<Integer> int_read_memory){
        try {
            int i = 0;
            save_file_read = new BufferedReader(new FileReader(file));
            if (!file.canRead()){
                file.setReadable(true);
            }
            while (true){
                string_read_memory.add(save_file_read.readLine());
                if (string_read_memory.get(i) == null){
                    break;
                }
                i++;
            }
            save_file_read.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string_read_memory;
    }
}