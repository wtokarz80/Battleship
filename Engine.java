import java.util.ArrayList;
import java.util.Map;

public class Engine {
    private Player player1;
    private Player player2;


    public static ArrayList<String> listOfPlayers = new ArrayList<>();

    Engine (boolean isHuman1, boolean isHuman2) {
        this.player1 = new Player(isHuman1);
        // this.player2 = new Player(isHuman2);
    }
    public Player getPlayerOne() {
        return this.player1;
    }

    public Player getPlayerTwo() {
        return this.player2;
    }

    
}