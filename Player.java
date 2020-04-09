import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {
    private Map<String, Integer> shipsList;
    private String playerName;
    private Ocean playerBoard;
    private Ocean shotsBoard;
    private int turn;
    private List<Ship> playerShips;
    private boolean isHuman;

    Player(boolean isHuman) {
        this.isHuman = isHuman;
        this.shipsList = makeShipsList();
        this.shotsBoard = new Ocean(10);
        this.turn = 0;
        if (isHuman) {
            this.playerName = createPlayerName();
            this.playerBoard = chooseBoard();
        }
        else{
            this.playerName = "Computer";
            this.playerBoard = createComputerBoard();
        }
    }

    public Map<String, Integer> makeShipsList() {
        shipsList = new HashMap<>();
        shipsList.put("Carrier", 5);
        shipsList.put("Battleship", 4);
        shipsList.put("Cruiser", 3);
        shipsList.put("Destroyer", 2);
        return shipsList;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public List<Ship> getPlayerShips() {
        return this.playerShips;
    }

    public String createPlayerName() {
        playerName = Common.getUserStringChoice("Enter your name: " + "\n");
        return playerName;
    }
    public String createComputerName() {
        playerName = Common.getUserStringChoice("Enter computer name: " + "\n");
        return playerName;
    }

    public Ocean getPlayerBoard() {
        return this.playerBoard;
    }

    public Ocean chooseBoard(){
        System.out.println("Set ships on the board\n");
        String choice = Common.getChoiceBoard("Enter [r] for random ships set or [m] for manual ships set.");
        if(choice.equalsIgnoreCase("R")){
            return createComputerBoard();
        }
        else{
            return createPlayerBoard();
        }
    }

    private Ocean createPlayerBoard() {
        int oceanSize = 10;
        playerShips = new ArrayList<>();
        System.out.println("Hello " + playerName + "\n");
        Ocean playerBoard = new Ocean(oceanSize);
        for (String key : shipsList.keySet()) {
            boolean isOk = false;
            Ship newShip;
            while (!isOk) {
                System.out.println(playerBoard);
                System.out.printf("Set on the %s on your board, ship's length is %s\n", key, shipsList.get(key));
                String orientation = Common
                        .getOrientation("Enter [h] for horizontal or [v] for vertical ship orientation.");
                String userPosition = Common.getUserPosition("Enter starting position, for example G4.");
                char userLetter = userPosition.charAt(0);
                int userNumber = Integer.parseInt(userPosition.substring(1));
                int posY = Common.letterToNumber(userLetter) - 1;
                int posX = userNumber - 1;
                int length = shipsList.get(key);
                newShip = new Ship(length, orientation, posX, posY, key);
                boolean keepGoing = playerBoard.matchTable(newShip);
                if (!keepGoing) {
                    System.out.println("The ships must fit on board and may not touch each other.");
                } else {
                    getPlayerShips().add(newShip);
                    isOk = true;
                }
            }
        }
        System.out.println(playerBoard);
        System.out.println("Press enter to countinue.");
        Main.scan.next();
        Common.clearScreen();
        return playerBoard;
    }

    private Ocean createComputerBoard() {
        int oceanSize = 10;
        playerShips = new ArrayList<>();
        System.out.println("Hello " + playerName + "\n");
        Ocean playerBoard = new Ocean(oceanSize);
        for (String key : shipsList.keySet()) {
            boolean isOk = false;
            Ship newShip;
            while (!isOk) {
                String computerOrientation = Common.getRandomNumber(10) < 5 ? "H" : "V";
                int posY = Common.getRandomNumber(10);
                int posX = Common.getRandomNumber(10);
                int length = shipsList.get(key);
                newShip = new Ship(length, computerOrientation, posX, posY, key);
                boolean keepGoing = playerBoard.matchTable(newShip);
                if (keepGoing) {
                    getPlayerShips().add(newShip);
                    isOk = true;
                }

            }
        }
        System.out.println(playerBoard);
        System.out.println("Press enter to countinue.");
        Main.scan.next();
        Common.clearScreen();
        return playerBoard;
    }

    public int getTurn() {
        return this.turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

}
