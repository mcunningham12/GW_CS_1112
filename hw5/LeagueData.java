import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class LeagueData {
    static private Team[] league;
    static private Player[] roster;

    static public Team[] getLeague() {
        return league;
    }

    static public Player[] getRoster() {
        return roster;
    }

    /**
     * loads the .csv file that contains all team and player data. DO NOT TOUCH this function
     */
    public static boolean load( ){
        league = new Team[5];
        roster = new Player[25];

        //loads in the entire leauge from a file
        try{
            File file = new File("Team_sheet.csv");

            BufferedReader br = new BufferedReader(new FileReader(file));

            int teamcount = 0;
            int playerInTeam = 0;
            int playercount = 0;

            Player[] thisTeam = new Player[5];

            String st;
            while ((st = br.readLine()) != null) {


                if (st.contains("~")){
                    //System.out.println(st);
                    String[] splits = st.split("~");

                    //System.out.println(Arrays.toString(splits));
                    Player[] loadP = new Player[5];
                    for (int x = 0; x<5;x++){
                        loadP[x] = thisTeam[x];
                    }

                    Team t = new Team(loadP,Integer.parseInt(splits[1]),Integer.parseInt(splits[2]),splits[0]);
                    league[teamcount] = t;

                    teamcount++;
                    playerInTeam = 0;

                    // System.out.println(league[0]);

                } else if (st.contains(",")){
                    String[] splits = st.split(",");

                    //System.out.println(st);
                    //System.out.println(Arrays.toString(splits));


                    PlayerStat ps = new PlayerStat(Integer.parseInt(splits[4]),Integer.parseInt(splits[5]),Integer.parseInt(splits[6]));
                    Player p = new Player(splits[0],Integer.parseInt(splits[1]),Integer.parseInt(splits[2]),Integer.parseInt(splits[3]),ps);

                    thisTeam[playerInTeam] = p;
                    roster[playercount] = p;

                    playercount++;
                    playerInTeam++;

                }
            }

        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
