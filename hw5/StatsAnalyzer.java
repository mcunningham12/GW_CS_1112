/**
 * A class with static functions with the objective of analyzing different 
 * aspects of the basketball league
 */
public class StatsAnalyzer {

    /**
     * This function is responsible for sorting the array of players in 
     * alphabetical order by name (use the entire string --> john smith is 
     * a j). The names should be in ascending order. A at the front and Z 
     * at the back
     * COMPLETE THE SORT USING A DIFFERENT ALGORITHM FROM THE ONE YOU 
     * IMPLEMENTED ON THE LAST HW
     *
     * @param roster The roster of players you will re-organize
     */
    public static void sortPlayersInAlphabeticalOrder(Player[] roster) {
        for (int i=0; i < roster.length-1; i++) {
            //Perform swaps from end-of-array down to i-th position.
            for (int j=roster.length-1; j>i; j--) {
                //Null check
                if (!(roster[j].getPlayerName().equals(null) || roster[j-1].getPlayerName().equals(null))) {
                    //Check if two strings are out of order
                    if (roster[j].getPlayerName().compareTo(roster[j-1].getPlayerName())<0) {
                        Player temp = roster[j];
                        roster[j] = roster[j-1];
                        roster[j-1] = temp;
                    }
                }
            }
        }
    }

    // Write a binary search to find the player given a rating

    /**
     * This function will be a binary locate a Player in the roster by 
     * completing a binary search. The binary search will be comparing 
     * Players by name to know in which direction to continue if the player
     * does not exist or any parameters are inadequate, return null
     *
     * @param roster the array of players you will perform the binary search on
     * @param name  The name of the player you are looking for
     * @return a shallow copy of the Player class of the found player or null
     */
    public static Player searchPlayerByName(Player[] roster, String name) {
        StatsAnalyzer.sortPlayersInAlphabeticalOrder(roster);
        int index=0;
	//Null check
        if (name == null || name == " " || name == "") {
            Player fail = new Player(null, -1, -1, -1, roster[0].getPlayerStats());
            return fail;
        }
        //Recursively figure out which index the player is at
        index=StatsAnalyzer.binarySearchHelper(roster, name, 0, roster.length-1);
        //Return null player if the player is not found in the search
        if (index == -1) {
            Player fail2 = new Player(null,-1,-1,-1, roster[0].getPlayerStats());
            return fail2;
        }
        //Create a new player with a reference to the index where the string parameter was
        Player p = roster[index];
        return p;
    }

    /**
     * A helper function that will help you write your binary search function
     * Hint: this should be the recursive part
     *
     * @param roster the roster you are searching
     * @param name the name of the player you are searching for
     * @param left your right bounds in the array
     * @param right your left bounds in the array
     * @return the index of where you found the player you are looking for. -1 if you did not find the player
     */
    public static int binarySearchHelper(Player[] roster, String name, int left, int right){
     	//Bottom-out cases:
        //If there is only one value in the range:
        if (left == right) {
            if (roster[right].getPlayerName().compareTo(name) == 0) {
                return right;
            }
            return -1;
        }
        
        //If there are only two values in the range:
        if (right == left+1) {
            //Check first value
            if (roster[left].getPlayerName().compareTo(name) == 0) {
                 return left;
            }
            //Check second value
            if (roster[right].getPlayerName().compareTo(name) == 0) {
                return right;
            }
            return -1;
        }
	//Otherwise recurse. The value must be between roster[start] and roster[end]
        int mid = (left+right)/ 2;
        //Create new string to minimize length of compareTo() line below
	String str=roster[mid].getPlayerName();
        if (name.compareTo(str)<=0) {
            //Search the left half
            return binarySearchHelper(roster, name, left, mid);
        }
        //Else, search the right half
        return binarySearchHelper(roster, name, mid+1, right);
    }

    //Calculate the best team in terms of most win/loss ratio

    /**
     * This function will find which team is the best team by finding the 
     * team with the largest win/loss ratio
     *
     * @param league an array of the teams to compare
     * @return a shallow copy of the best team
     */
    public static Team getBestTeam(Team[] league) {
        //Set check variable equal to win ratio of the first element
        double check = (double) league[0].getWins() / (league[0].getLosses()+league[0].getWins());
        //Set position integer equal to 0 
        int pos=0;
        for (int i =1;i<league.length;i++){
            //Check to see if the team I'm looking at has a sufficient amount of wins or losses
            if (league[i] != null && league[i].getWins()>=0 && league[i].getLosses()>=0) {
                double j= (double) league[i].getWins() / (league[i].getLosses()+league[i].getWins());
                if (j>check) {
                    check= j;
                    pos=i;
                }
            }
        }
        return league[pos]; 
    }

    /**
     * This function will find which team is the best team by finding the 
     * team with the smallest win/loss ratio
     *
     * @param league an array of the teams to compare
     * @return a shallow copy of the worst team
     */
     public static Team getWorstTeam(Team[] league) {
        //Set check and pos equal to the respective value of the first element
        double check = (double) league[0].getWins() / (league[0].getLosses()+league[0].getWins());
        int pos=0;
        for (int i=0;i<league.length;i++){
            if (league[i] != null && league[i].getWins()>=0 && league[i].getLosses()>=0) {
                double j=(double) league[i].getWins()/league[i].getLosses();
                if(j<check){
                   check=j;
                   pos=i; 
                }
            }
        }
        return league[pos];
    }

    //--------------------------------------------------------------------
    // Extension 1
    //--------------------------------------------------------------------

    // Write a function to create a ranking for each player and set the 
    // ranking for each player (points + assists + rebounds)

    /**
     * This function computes the player rating for a specific player then 
     * sets that value in the player's class
     * A player rating is defined as their Points+Assists+Rebounds
     *
     * @param player The player you are computing the rating for
     * @return the player rating computer for that player or -1 if 
     *         parameters were invalid
     */
    public static int computePlayerRating(Player player) {
        //make shallow copy of PlayerStats for player
        PlayerStat p  = player.getPlayerStats();
        //null check
        if (p == null) {
            return -1;
        }
        //
        if (p.getPoints()>=0 && p.getAssists()>=0 && p.getRebounds()>=0) {
            return p.getPoints()+p.getAssists()+p.getRebounds();
        }
        return -1;
    }

    /**
     * find the player with the highest player rating in the league
     *
     * @param roster The array of players to analyze for the MVP
     * @return a shallow copy of the Player considered to be MVP
     */
    public static Player getLeagueMVP(Player[] roster) {
        int check= StatsAnalyzer.computePlayerRating(roster[0]);
        int pos=0;
        for (int i=0;i<roster.length;i++) {
            if (roster[i] != null) {
                PlayerStat s = roster[i].getPlayerStats();
                if (s.getPoints()>=0 && s.getAssists()>=0 && s.getRebounds()>=0)  {
                    int rating=StatsAnalyzer.computePlayerRating(roster[i]);
                    if (rating>check){
                        check=rating;
                        pos=i;
                    }
                }
            }
        }
        System.out.println("MVP: " + roster[pos].getPlayerName());
        return roster[pos];
    }

    //--------------------------------------------------------------------
    // Extension 2
    //--------------------------------------------------------------------

    /**
     * Create the best possible team which fits under a set salary cap.
     * Best possible is defined as the combination of players with the 
     * highest combined Player Ratings
     *
     * When creating your dream team.
     *      name can be anything you want
     *      Wins/losses should both == 0 because your team has not played 
     *      any games
     *      Players[] should be an array of 5 players. These players should 
     *      be shallow copies of players in the roster
     *
     * @return a new Team Object that is your dream team.
     */
    public static Team DreamTeam(int salaryCap,Player[] roster){
         Team t;
         
         return null;
    }

}
