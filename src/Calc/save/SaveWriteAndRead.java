package Calc.save;
import Calc.Person2;
import Calc.Position;
import Monsters.*;
import java.io.*;

public class SaveWriteAndRead {
    //下の奴の目印
    public File first_save_file = new File("C:\\Users\\2009t\\IdeaProjects\\ex001\\src\\firstsave.dat");
    public Person2 p;
    public EnemeyMonster enemeyMonster;
    public Position position;
    public SaveWriteAndRead(Person2 p, EnemeyMonster enemeyMonster,Position position){
        this.p = p;
        this.enemeyMonster = enemeyMonster;
        this.position = position;
    }
    //まで
    public void write(){
        try (FileOutputStream file = new FileOutputStream("C:\\Users\\2009t\\IdeaProjects\\ex001\\src\\save.dat");
             BufferedOutputStream buffered = new BufferedOutputStream(file);
             ObjectOutputStream output = new ObjectOutputStream(buffered);
             FileWriter first_save = new FileWriter(first_save_file);
             BufferedReader first_read =new BufferedReader(new FileReader(first_save_file))){
            output.reset();
            output.writeObject(p);
            output.writeObject(enemeyMonster);
            if (!(first_save_file.canRead())){
                first_save_file.setReadable(true);
            }
            if (first_read.readLine().equals("false")) {
                first_save_file.setWritable(true);
                first_save_file.delete();
                first_save.write(String.valueOf(true));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void read(){
        //最初にfileの中が空やから入れる必要がある
        try (BufferedReader read_or_no =new BufferedReader(new FileReader(first_save_file))){
            if (read_or_no.readLine().equals("true")) {
                FileInputStream file = new FileInputStream("C:\\Users\\2009t\\IdeaProjects\\ex001\\src\\save.dat");
                BufferedInputStream buffered = new BufferedInputStream(file);
                ObjectInputStream input = new ObjectInputStream(buffered);
                this.p = (Person2) input.readObject();
                this.enemeyMonster = (EnemeyMonster) input.readObject();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
