/**
 * This class represents a player's statistics over the course of a season
 */
public class PlayerStat{

    private int points;
    private int assists;
    private int rebounds;

    /**
     * This constructor creates a new PlayerStat object with the given parameters
     *
     * @param p the number of points scored during the season
     * @param a the number of assists they had during the season
     * @param r the number of rebounds they had over the course of the season
     */
    public PlayerStat(int p, int a, int r){
        points = p;
        assists = a;
        rebounds = r;
    }

    //get and set methods to allow the client programmer to interact with the object's variables

    public int getPoints(){
        return points;
    }

    public int getAssists(){
        return assists;
    }

    public int getRebounds(){
        return rebounds;
    }


    @Override
    /**
     * Prints information used to check if the stats are built correctly
     */
    public String toString() {
        return "PlayerStat{" +
                "points=" + points +
                ", assists=" + assists +
                ", rebounds=" + rebounds +
                '}';
    }
}