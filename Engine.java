import java.util.ArrayList;
import java.util.Map;

public class Engine {
    private Player player1;
    private Player player2;


    public static ArrayList<String> listOfPlayers = new ArrayList<>();

    Engine (boolean isHuman1, boolean isHuman2) {
        this.player1 = new Player(isHuman1);
        this.player2 = new Player(isHuman2);
    }
    public Player getPlayerOne() {
        return this.player1;
    }

    public Player getPlayerTwo() {
        return this.player2;
    }
    void shooting (Player gamer, Player opponent){
        System.out.println(String.format("now %s is shooting. Shoot! eg. G4", gamer.getPlayerName()));
        String userPosition = Common.getUserPosition("Enter shooting coordinates, for example G4.");
        char userLetter = userPosition.charAt(0);
        int userNumber = Integer.parseInt(userPosition.substring(1));
        int posY = Common.letterToNumber(userLetter) - 1;
        int posX = userNumber - 1;
            if (opponent.getPlayerBoard().getSquare(posY, posX).getStatus() == "SHIP"){
                    gamer.getShotsBoard().getSquare(posY, posX).setStatus("HIT");
                    System.out.println("You have shot the enemy!");
            }
            else {System.out.println("You have missed the ship");
        }
        System.out.println(gamer.getShotsBoard());
    }

}