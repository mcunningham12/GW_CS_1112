
/**
 * This class runs your program. You will write your unit tests here
 */
public class UnitTests{

    static private Team[] league;
    static private Player[] roster;

    public static void main(String[] args){

        // Load the data related to the team and players. DO NOT REMOVE
        if(!LeagueData.load() ) {
            System.out.println("ERROR: loading League Data\nExiting");
            return;
        }

        league = LeagueData.getLeague();
        roster = LeagueData.getRoster();
        if(league == null || roster == null ) {
            System.out.println("ERROR: Invalid League Data\nExiting");
            return; 
        }
        /*
        // Prints out the player and team data
        for(int i = 0; i < roster.length; i++) {
            System.out.println(roster[i].getPlayerName());
        }
        for(int i = 0; i < league.length; i++) {
            System.out.println(league[i].getName());
        }
        */

        // TODO: Call your test cases here
        System.out.println("Sort Players=" + UnitTests.sortPlayers());
        System.out.println("Search Players=" + UnitTests.searchPlayers());
        System.out.println("Best Team=" + UnitTests.bestTeam());
        System.out.println("Worst Team=" + UnitTests.worstTeam());
        
        //Extension Unit Tests
        System.out.println("Player Rating="+ UnitTests.computeRating());
        System.out.println("League MVP=" + UnitTests.leagueMVP());
    }

    //--------------------------------------------------------------------
    //  Your tests go here...
    //--------------------------------------------------------------------


    public static boolean sortPlayers() {
       StatsAnalyzer.sortPlayersInAlphabeticalOrder(roster);
       for (int i=0;i<roster.length-1;i++) {
            String n1=roster[i].getPlayerName();
            String n2=roster[i+1].getPlayerName();
            if (n1.compareTo(n2) > 0) {    
                return false;
            }
        }
       //Run the unit test again to make sure sorting a sorted array works
       StatsAnalyzer.sortPlayersInAlphabeticalOrder(roster);
       for (int i=0;i<roster.length-1;i++) {
            String n1=roster[i].getPlayerName();
            String n2=roster[i+1].getPlayerName();
            if (n1.compareTo(n2) > 0) {    
                return false;
            }
        }
        return true;
    }

    public static boolean searchPlayers() {
        //null check
        String name = " ";
        Player p = StatsAnalyzer.searchPlayerByName(roster, name);
        if (p.getPlayerName() != null) {
            System.out.println("FAILED NULL CHECK");
            return false;
        }
        //check name at end
        String name2 = "The Graders";
        Player p2 = StatsAnalyzer.searchPlayerByName(roster, name2);
        if (p2.getPlayerName().compareTo(name2) != 0) {
            System.out.println("FAILED NAME IN LEAGUE");
            return false;
        }
        //check name not in league
        String name3 = "Dirk Nowitzki";
        Player p3 = StatsAnalyzer.searchPlayerByName(roster, name3);
        if (p3.getPlayerName() != null) {
            System.out.println("FAILED NAME NOT IN LEAGUE");
            return false;
        }
        //check name in league
        String name4 = "James Levy";
        Player p4 = StatsAnalyzer.searchPlayerByName(roster, name4);
        if (p4.getPlayerName().compareTo(name4) !=0) {
            System.out.println("FAILED NAME IN LEAGUE LEFT");
            return false;
        }
        //check different name in league
        String name5 = "Kelvin Petersen";
        Player p5 = StatsAnalyzer.searchPlayerByName(roster, name5);
        if (p5.getPlayerName().compareTo(name5) !=0) {
            System.out.println("FAILED NAME IN LEAGUE RIGHT");
            return false;
        }  
        return true;
    }

    public static boolean bestTeam() {
        //check if the best team is returned
        Team t = StatsAnalyzer.getBestTeam(league);
        if (t.getName().compareTo("Purdue Boilermakers") != 0) {
            return false;
        }
        return true;
    }
    public static boolean worstTeam() {
        //check if worst team is returned
        Team t = StatsAnalyzer.getWorstTeam(league);
        if (t.getName().compareTo("IU Hoosiers") == 0) {
            return true;
        }
        return false;
    }
    
    public static boolean computeRating(){
        //null check
        PlayerStat stat = new PlayerStat(300,-5,100);
        Player p = new Player(null,-1,-1,-1,stat);
        if (StatsAnalyzer.computePlayerRating(p) != -1){
            return false;
        }
        //check to see if method works for newly created player
        PlayerStat stat1 = new PlayerStat(900,400,500);
        Player p1 = new Player("Max Cunningham",12,21,10000,stat1);
        if (StatsAnalyzer.computePlayerRating(p1) != 1800){
            return false;
        }
        return true;
    }

    public static boolean leagueMVP() {
        //test1
        Player p = StatsAnalyzer.getLeagueMVP(roster);
        String str="Carsen Edwards";
        if (p.getPlayerName().compareTo(str) != 0){
            return false;
        }
        //test2 where a new player is added to the array
        PlayerStat stat1 = new PlayerStat(900,400,500);
        Player p1 = new Player("Max Cunningham",12,21,10000,stat1);
        roster[5]=p1;
        //check if method can handle null players
        roster[2]=null;
        Player p2 = StatsAnalyzer.getLeagueMVP(roster);
        if (p2.getPlayerName().compareTo("Max Cunningham") !=0){
            return false;
        }
        return true;
    }
}
