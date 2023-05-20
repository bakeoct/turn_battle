package Calc.study;

import java.io.*;

public class Save_kinou {
    public static void main(String[] args) {
        try(FileOutputStream file = new FileOutputStream("status.dat");
            BufferedOutputStream b = new BufferedOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(b)){

            Status st = new Status("勇者", 100, 30);

            out.writeObject(st);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class Status implements Serializable{
    String name;
    int hp;
    int mp;
    Status(String name, int hp, int mp){
        this.name = name;
        this.hp = hp;
        this.mp = mp;
    }
}
