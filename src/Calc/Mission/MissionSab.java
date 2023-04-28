package Calc.Mission;

import Calc.Person2;
import Calc.Store;
import Monsters.Monster2;

import java.util.ArrayList;
import java.util.Scanner;

public class MissionSab extends Mission{
    public int endflg=0;
    public ArrayList<Mission> missionsAll =new ArrayList<Mission>();
    public MissionDragon_king missionDragon_king =new MissionDragon_king();
    public Boolean receive(Person2 p, Scanner scanner) {
        int i = 0;
        while (i==0) {
            ArrayList<Mission> missions = new ArrayList<Mission>();
            missionsAll.clear();
            missionsAll.add(missionDragon_king);
            for (Mission mission : missionsAll) {
                if (p.LV >= mission.dangerousLV && !(mission.progress == true)) {
                    endflg = 0;
                    System.out.println(mission.name + " " + "報酬" + mission.reward + "$" + " [" + mission.code + "]");
                    missions.add(mission);
                }
            }
            if (endflg==1){
                System.out.println("って、もうミッションがないな");
                break;
            }
            System.out.println("戻る [goback]");
            String missionSelection = scanner.next();
            for (Mission mission : missions) {
                if (missionSelection.equals(mission.code)) {
                    mission.progress = true;
                    System.out.println(mission.name+"のミッションを受けた！");
                    System.out.println("ほかに受けたいミッションはあるか？");
                    endflg = 1;
                    break;
                }
            }
            if (missionSelection.equals("goback")) {
                System.out.println("そうか");
                i++;
            }else {
                if (endflg==0){
                    System.out.println("ミッションの中から選んでくれ");
                }
            }
        }
        return missionDragon_king.progress;
    }
    public void missionprogres(Mission successmission){
        for (Mission mission : missionsAll){
            if (successmission == mission && missionDragon_king.progress){
                mission.progress = false;
                mission.getreward = true;
            }
        }
    }
}
