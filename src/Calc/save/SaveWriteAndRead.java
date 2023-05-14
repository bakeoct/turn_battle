package Calc.save;

import Calc.Item.FightItem;
import Calc.Item.Item;
import Calc.Person2;
import Calc.Position;
import Monsters.EnemeyMonster;
import Monsters.Monster2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class SaveWriteAndRead {
    public File file =new File("C:\\Users\\2009t\\IdeaProjects\\ex001\\src\\Calc\\save\\Save.txt");
    public BufferedWriter save_file_write;
    public BufferedReader save_file_read;
    public void write(ArrayList<String> write_memorys,Person2 p,EnemeyMonster enemeyMonster){
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
            for (FightItem fight_item : p.fight_items){
                save_file_write.write(fight_item.name);
                save_file_write.newLine();
                save_file_write.write(fight_item.code);
                save_file_write.newLine();
                save_file_write.write(fight_item.itemsclass);
                save_file_write.newLine();
                save_file_write.write(fight_item.itemgroup);
                save_file_write.newLine();
                String items_have = tureChengeString(fight_item.have);
                save_file_write.write(items_have);
                save_file_write.newLine();
                save_file_write.write(String.valueOf(fight_item.itemLV));
                save_file_write.newLine();
                save_file_write.write(String.valueOf(fight_item.buyprice));
                save_file_write.newLine();
                save_file_write.write(String.valueOf(fight_item.sellprice));
                save_file_write.newLine();
                save_file_write.write(String.valueOf(fight_item.upattack));
                save_file_write.newLine();
                save_file_write.write(String.valueOf(fight_item.uphp));
                save_file_write.newLine();
                save_file_write.write(String.valueOf(fight_item.heal));
                save_file_write.newLine();
                save_file_write.write(String.valueOf(fight_item.havenumber));
                save_file_write.newLine();
            }
            for (Item field_item : p.monster_items){
                save_file_write.write(field_item.name);
                save_file_write.newLine();
                save_file_write.write(field_item.code);
                save_file_write.newLine();
                save_file_write.write(field_item.itemsclass);
                save_file_write.newLine();
                save_file_write.write(field_item.itemgroup);
                save_file_write.newLine();
                String items_have = tureChengeString(field_item.have);
                save_file_write.write(items_have);
                save_file_write.newLine();
                save_file_write.write(String.valueOf(field_item.itemLV));
                save_file_write.newLine();
                save_file_write.write(String.valueOf(field_item.buyprice));
                save_file_write.newLine();
                save_file_write.write(String.valueOf(field_item.sellprice));
                save_file_write.newLine();
                save_file_write.write(String.valueOf(field_item.havenumber));
                save_file_write.newLine();
            }
            for (Item monster_item : p.field_items){
                save_file_write.write(monster_item.name);
                save_file_write.newLine();
                save_file_write.write(monster_item.code);
                save_file_write.newLine();
                save_file_write.write(monster_item.itemsclass);
                save_file_write.newLine();
                save_file_write.write(monster_item.itemgroup);
                save_file_write.newLine();
                String items_have = tureChengeString(monster_item.have);
                save_file_write.write(items_have);
                save_file_write.newLine();
                save_file_write.write(String.valueOf(monster_item.itemLV));
                save_file_write.newLine();
                save_file_write.write(String.valueOf(monster_item.buyprice));
                save_file_write.newLine();
                save_file_write.write(String.valueOf(monster_item.sellprice));
                save_file_write.newLine();
                save_file_write.write(String.valueOf(monster_item.havenumber));
                save_file_write.newLine();
            }
            for (Monster2 monster : p.monsters2){
                save_file_write.write(monster.name);
                save_file_write.newLine();
                save_file_write.write(monster.seibetu);
                save_file_write.newLine();
                save_file_write.write(String.valueOf(monster.HP));
                save_file_write.newLine();
                save_file_write.write(String.valueOf(monster.MP));
                save_file_write.newLine();
                save_file_write.write(String.valueOf(monster.Attack));
                save_file_write.newLine();
                save_file_write.write(String.valueOf(monster.judgeSente));
                save_file_write.newLine();
                save_file_write.write(String.valueOf(monster.leberu));
                save_file_write.newLine();
                String monster_alive = tureChengeString(monster.isalive);
                save_file_write.write(monster_alive);
                save_file_write.newLine();
                String monster_fellow = tureChengeString(monster.fellow);
                save_file_write.write(monster_fellow);
                save_file_write.newLine();
            }
            save_file_write.write(String.valueOf(enemeyMonster.position.x));
            save_file_write.newLine();
            save_file_write.write(String.valueOf(enemeyMonster.position.y));
            save_file_write.newLine();
            save_file_write.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<String> read(ArrayList<String> string_read_memory){
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
    public void InSave(ArrayList<String> string_read_memory, EnemeyMonster monsterposition, Person2 p, ArrayList<Monster2> monsters2){

    }
    public String tureChengeString(Boolean item_have){
        String item_have_string;
        if (item_have){
            item_have_string = "ture";
        }else {
            item_have_string = "false";
        }
        return item_have_string;
    }
}
