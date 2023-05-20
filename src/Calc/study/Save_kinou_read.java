package Calc.study;

import java.io.*;

public class Save_kinou_read {
    public static void main(String[] args) {
        try(FileInputStream f = new FileInputStream("status.dat");
            BufferedInputStream b = new BufferedInputStream(f);
            ObjectInputStream in = new ObjectInputStream(b)){
            Status st = (Status) in.readObject();
            System.out.println(st.name);
            System.out.println(st.hp);
            System.out.println(st.mp);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
