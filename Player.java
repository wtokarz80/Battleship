
public class Player {
    private String playerName;
    private Square[][] playerBoard;
    private Square[][] shotsBoard;
    private boolean turn;
    private Ship[] listOfShips;
    private boolean isHuman;

    Player(boolean isHuman){
        this.isHuman = isHuman;
        this.playerName = createPlayerName();
    }

    public void setPlayerName(String playerName){
        this.playerName = playerName;
    }

    public String getPlayerName(){
        return playerName;
    }

    private String createPlayerName(){
        playerName = Common.getUserStringChoice("Enter your name: " + "\n");
        return playerName;
    }

    // private Ocean createPlayerBoard(){
    //     System.out.println("Hello " + playerName + "\n");
    //     Common.makeShipsList();
        

    // }

    

}

