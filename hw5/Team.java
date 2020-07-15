import java.util.Arrays;

/**
 * This class represents a basketball team in our league.
 */
public class Team {
    private String name;
    private Player[] players; //cap at 5
    private int wins;
    private int losses;

    /**
     * The constructor called to create a new basket ball team
     *
     * @param players an array of player objects (should be size 5) that will be in the team
     * @param wins the number of wins the basketball team got over the course of the season
     * @param losses the number of losses the basketball team got over the course of the season
     * @param name The name of the basketball team
     */
    public Team(Player[] players, int wins, int losses, String name) {
        this.players = players;
        //this.mvp = mvp;
        this.wins = wins;
        this.losses = losses;
        this.name = name;
    }

    // Get and set methods that allow the client programmer to access the objects variables

    public Player[] getPlayers() {
        return players;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public String getName(){
        return name;
    }


    @Override
    /**
     * Prints information used to check if the team is built correctly
     */
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", players=" + Arrays.toString(players) +
                ", wins=" + wins +
                ", losses=" + losses +
                '}';
    }
}
