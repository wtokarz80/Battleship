import java.util.ArrayList;
import java.util.Map;


public class Engine {
    private Player player1;
    private Player player2;

    public static ArrayList<String> listOfPlayers = new ArrayList<>();

    Engine(boolean isHuman1, boolean isHuman2) {
        this.player1 = new Player(isHuman1);
        this.player2 = new Player(isHuman2);
    }

    public Player getPlayerOne() {
        return this.player1;
    }

    public Player getPlayerTwo() {
        return this.player2;
    }


    public void startGame(String mode) {
        boolean isAlive = true;
        boolean switchPlayer = false;
        Player currentPlayer = getPlayerOne();
        Player opponentPlayer = getPlayerTwo();

        while (isAlive) {
            if (!switchPlayer) {
                switchPlayer = true;
                currentPlayer = getPlayerOne();
                opponentPlayer = getPlayerTwo();
                currentPlayer.setTurn(currentPlayer.getTurn() + 1);
                opponentPlayer.setTurn(opponentPlayer.getTurn() + 1);
            } else {
                switchPlayer = false;
                currentPlayer = getPlayerTwo();
                opponentPlayer = getPlayerOne();
            }
            switch (mode) {
                case "pvc":
                    pvcGame(currentPlayer, opponentPlayer);
                    break;
            }
            isAlive = Common.arePlayersAlive(currentPlayer, opponentPlayer);
        }
        winGameScreen(currentPlayer, opponentPlayer);
    }

    public void winGameScreen(Player player1, Player player2) {
        System.out.println("\n" + player1.getPlayerName() + " WINS!\n");
        System.out.println(player1.getPlayerName() + "'S BOARD");
        System.out.println(player1.getPlayerBoard().toString());
        System.out.println("");
        System.out.println(player2.getPlayerName() + "'S BOARD");
        System.out.println(player2.getPlayerBoard().toString());
    }

    public void pvcGame(Player currentPlayer, Player opponentPlayer) {

        if(currentPlayer.getIsHuman() == true){
            System.out.print(Colors.BLUE_BOLD);
            currentPlayer.displayScreen("");
            System.out.print(Colors.RESET);
            String message = currentPlayer.playerGame(opponentPlayer);
            currentPlayer.displayScreen(message);
            System.out.println("Press enter to change player.");
            Main.scan.next();
        }
        else{
            Common.clearScreen();
            System.out.println("\n\nComputer turn\n\n");
            currentPlayer.computerGame(opponentPlayer);
            System.out.println("Press enter to shoot.");
            Main.scan.next();
            Common.clearScreen();
        }
    }


    boolean isWinning (Player winner){
        int shooted = 0;
        for (int i = 0; i<10; i++){
            for (int j = 0; j<10; j++){
                if (winner.getShotsBoard().getSquare(i, j).getStatus() == "HIT"){
                    shooted++;
                }
            }
        }
        if (shooted == 2) {
            System.out.println(String.format("the winner is: %s", winner.getPlayerName()));}
             return (shooted == 2);

    }
}