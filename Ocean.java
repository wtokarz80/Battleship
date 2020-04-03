import java.util.ArrayList;
import java.util.List;

public class Ocean {
    private int oceanSize;
    private Square[][] oceanBoard;
    private List<Square> shipSquaresList;
    private List<Square> allSquaresList;

    Ocean(int oceanSize){
        this.oceanSize = oceanSize;
        this.allSquaresList = new ArrayList<>();
        this.shipSquaresList = new ArrayList<>();
        this.oceanBoard = createOceanBoard(oceanSize);
    }

    public Square[][] createOceanBoard(int oceanSize){
        oceanBoard = new Square [oceanSize][oceanSize];
        for(int i = 0; i < oceanSize; i++){
            for(int j = 0; j < oceanSize; j++){
                Square field = new Square(i, j);
                oceanBoard[i][j] = field;
                allSquaresList.add(field);
            }
        }
        
        return oceanBoard;
    }

    public String toString(){
        StringBuilder board = new StringBuilder();
        String letters = "ABCDEFGHIJ";
        board.append(" ");
        for(int i = 1; i < 11; i++){
            board.append(" " + i);
        }
        board.append("\n");
        for(int i = 0; i < oceanSize; i++){
            board.append(letters.charAt(i));
            for(int j = 0; j < oceanSize; j++){
                board.append(oceanBoard[i][j].toString());
            }
            board.append("\n");
        }
        return board.toString();
    }


}
