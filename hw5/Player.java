/**
 * This class represents a player in our basketball league
 */
public class Player {
    private String name;
    private int playerNumber; 
    private int age;  
    private int salary;
    private double playerRating;
    private PlayerStat playerStats;

    /**
     * This constructor creates a new Player.
     * The Player Rating variable is initially uncalculated and set to a nonsense value
     *
     * @param name the name of the basketball player
     * @param playerNumber the player's jersey number
     * @param age how old the player is
     * @param salary how much the player gets paid
     * @param playerStats a playerStats object that represents how well the player did over the course of a season
     */
    Player(String name, int playerNumber, int age, int salary, PlayerStat playerStats) {
        this.name = name; 
        this.playerNumber = playerNumber;
        this.age = age;
        this.salary = salary; 
        this.playerStats = playerStats;

        this.playerRating = -1; //sets the rating as a clear wrong value
    }

    //Get and set methods that allow the client programmer to interact with the objects variables

    public String getPlayerName() {
        return name; 
    }
    public int getPlayerNumber() {
        return playerNumber;
    }
    public int getPlayerAge() {
        return age; 
    }
    public int getPlayerSalary() {
        return salary; 
    }
    public PlayerStat getPlayerStats() {
        return playerStats; 
    }
    public double getPlayerRating() {
        return playerRating;
    }

    public void setPlayerRating(double playerRating) {
        this.playerRating = playerRating;
    }

    @Override
    /**
     * Prints information used to check if the player is built correctly
     */
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", playerNumber=" + playerNumber +
                ", playerStats=" + playerStats +
                '}';
    }
}
