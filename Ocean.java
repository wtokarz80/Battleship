import java.util.ArrayList;
import java.util.List;

public class Ocean {
    private int oceanSize;
    private Square[][] oceanBoard;
    private List<Square> shipSquaresList;
    private List<Square> allowedSquares;
    private List<Square> forbiddenSquares;

    Ocean(int oceanSize) {
        this.oceanSize = oceanSize;
        this.allowedSquares = new ArrayList<>();
        this.shipSquaresList = new ArrayList<>();
        this.oceanBoard = createOceanBoard(oceanSize);
    }

    public Square[][] createOceanBoard(int oceanSize) {
        oceanBoard = new Square[oceanSize][oceanSize];
        for (int i = 0; i < oceanSize; i++) {
            for (int j = 0; j < oceanSize; j++) {
                Square field = new Square(i, j);
                oceanBoard[i][j] = field;
                allowedSquares.add(field);
            }
        }
        return oceanBoard;
    }

    public Square[][] getOceanBoard() {
        return this.oceanBoard;
    }

    public Square getSquare(int posY, int posX) {
        return this.getOceanBoard()[posY][posX];
    }

    public boolean matchTable(Ship newShip) {
        if (newShip.getOrientation().equals("H")) {
            if (newShip.getPosX() + newShip.getLength() <= oceanSize && isAllowed(newShip, "H")) {
                for (int i = newShip.getPosX(); i < newShip.getPosX() + newShip.getLength(); i++) {
                    getOceanBoard()[newShip.getPosY()][i].setStatus("SHIP");
                    Square field = getSquare(newShip.getPosY(), i);
                    newShip.addSquareToList(field);
                    // allowedSquares.remove(field);
                    allowedSquares = removeSquares(allowedSquares, newShip, "H");
                }
                return true;

            }

        } else if (newShip.getOrientation().equals("V")) {
            if (newShip.getPosY() + newShip.getLength() <= oceanSize && isAllowed(newShip, "V")) {
                for (int i = newShip.getPosY(); i < newShip.getPosY() + newShip.getLength(); i++) {
                    getOceanBoard()[i][newShip.getPosX()].setStatus("SHIP");
                    Square field = getSquare(i, newShip.getPosX());
                    newShip.addSquareToList(field);
                    // allowedSquares.remove(field);
                    allowedSquares = removeSquares(allowedSquares, newShip, "V");
                }
                return true;

            }
        }
        return false;

    }

    public List<Square> removeSquares(List<Square> allowedSquares, Ship newShip, String orientation) {

        for(Square element : newShip.getListOfFields()){
            for (int i = -1; i < 2; i++){
                for (int j = -1; j < 2; j++){
                    int x = element.getPosX() + j;
                    int y = element.getPosY() + i;
                    if (x >= 0 && x < 10 && y >= 0 && y < 10){
                        Square field = getSquare(x, y);
                        if(allowedSquares.contains(field)){
                            allowedSquares.remove(field);
                        }
                    }
                }
            }
        }
        
        return allowedSquares;
    }

    public boolean isAllowed(Ship newShip, String orientation) {
        if (orientation.equalsIgnoreCase("H")) {
            for (int i = newShip.getPosX(); i < newShip.getPosX() + newShip.getLength(); i++) {
                if (!allowedSquares.contains(getOceanBoard()[newShip.getPosY()][i])) {
                    return false;            
                }
               
            }
        } else if (orientation.equalsIgnoreCase("V")) {
            for (int i = newShip.getPosY(); i < newShip.getPosY() + newShip.getLength(); i++) {
                if (!allowedSquares.contains(getOceanBoard()[i][newShip.getPosX()])) {
                    return false;
                }
                
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder board = new StringBuilder();
        String letters = "ABCDEFGHIJ";
        board.append(" ");
        for (int i = 1; i < 11; i++) {
            board.append(" " + i);
        }
        board.append("\n");
        for (int i = 0; i < oceanSize; i++) {
            board.append(letters.charAt(i));
            for (int j = 0; j < oceanSize; j++) {
                board.append(oceanBoard[i][j].toString());
            }
            board.append("\n");
        }
        return board.toString();
    }

}
