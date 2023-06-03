package Calc.save;

import Calc.Error.Finish;
import Calc.Game;
import Calc.Map;
import Calc.Mission.MissionDragon_king;
import Calc.Person2;
import Monsters.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SaveLoadManager {
    String saveFilePath = System.getProperty("user.home") + "/Desktop/myfile.txt";
    public void save(Game game) {
        try (
                FileOutputStream fos = new FileOutputStream(this.saveFilePath);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            oos.writeObject(game);
        } catch(IOException e) {
        }
    }

    public Game restore() {
        Game game = null;
        try (
                FileInputStream fis = new FileInputStream(this.saveFilePath);
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            game = (Game) ois.readObject();
            return game;
        } catch (IOException e) {
            Gorlem gorlem =new Gorlem();
            Dragon_king dragon_king =new Dragon_king();
            Metal_slime metal_slime =new Metal_slime();
            Puti_slime puti_slime=new Puti_slime();
            int personkey=1;
            ArrayList<String> string_memory =new ArrayList<String>();
            Scanner scanner =new Scanner(System.in);
            MissionDragon_king missionDragon_king =new MissionDragon_king();
            EnemeyMonster enemeyMonster =new EnemeyMonster();
            ArrayList<Monster2> enemy_monsters = new ArrayList<>();
            enemy_monsters.add(dragon_king);
            enemy_monsters.add(metal_slime);
            enemy_monsters.add(puti_slime);
            enemy_monsters.add(gorlem);
            Person2 p = new Person2("takumi","dannsei",personkey,metal_slime,gorlem);
            p.money = 220;
            SaveLoadManager sl = new SaveLoadManager();
            Map map =new Map();
            game =new Game(map,p,missionDragon_king,enemeyMonster,enemy_monsters,dragon_king);
            return game;
        }  catch (ClassNotFoundException e) {
            Gorlem gorlem =new Gorlem();
            Dragon_king dragon_king =new Dragon_king();
            Metal_slime metal_slime =new Metal_slime();
            Puti_slime puti_slime=new Puti_slime();
            int personkey=1;
            ArrayList<String> string_memory =new ArrayList<String>();
            Scanner scanner =new Scanner(System.in);
            MissionDragon_king missionDragon_king =new MissionDragon_king();
            EnemeyMonster enemeyMonster =new EnemeyMonster();
            ArrayList<Monster2> enemy_monsters = new ArrayList<>();
            enemy_monsters.add(dragon_king);
            enemy_monsters.add(metal_slime);
            enemy_monsters.add(puti_slime);
            enemy_monsters.add(gorlem);
            Person2 p = new Person2("takumi","dannsei",personkey,metal_slime,gorlem);
            p.money = 250;
            SaveLoadManager sl = new SaveLoadManager();
            Map map =new Map();
            game =new Game(map,p,missionDragon_king,enemeyMonster,enemy_monsters,dragon_king);
            return game;
        }
    }
}
