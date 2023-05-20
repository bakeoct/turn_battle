package Calc.Mission;

import Calc.Error.Finish;
import Calc.Person2;

import java.util.ArrayList;
import java.util.Scanner;

public class MissionSab{
    public int endflg=0;
    public ArrayList<Mission> missionsAll =new ArrayList<Mission>();
    public MissionDragonKing missionDragon_king =new MissionDragonKing();
    public void receive(Person2 p, Scanner scanner, MissionDragonKing missionDragon_king) throws Finish {
        int i = 0;
        ArrayList<Mission> missions = new ArrayList<Mission>();
        while (i==0) {
            missionsAll.clear();
            missionsAll.add(missionDragon_king);
            for (Mission mission : missionsAll) {
                if (p.LV >= mission.dangerousLV && !(mission.progress)) {
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
            }else if (missionSelection.equals("finish")) {
                throw new Finish();
            } else if (endflg==0){
                    System.out.println("ミッションの中から選んでくれ");
                }
            }
        }
    public void missionProgres(Mission successmission){
                successmission.progress = false;
                successmission.getreward = true;
    }
}
