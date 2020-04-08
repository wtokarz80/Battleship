import java.util.HashMap;
import java.util.Map;

public class Square {

    private String status;
    private boolean isAvailable;
    private int posX;
    private int posY;

    public Square(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
        this.isAvailable = true;
        this.status = "WATER";
    }

    public boolean getIsAwailable(){
        return this.isAvailable;
    }

    public void setUnAvailable(){
        this.isAvailable = false;
    }

    public int getPosX(){
        return this.posX;
    }

    public int getPosY(){
        return this.posY;
    }

    public String getStatus(){
        return this.status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String toString(){
        String hit = " \u2715";
        String missed = " \u25E6";
        String water = " \u2751";
        String ship = " \u25A0";
        Map<String, String> squareView = new HashMap<>();
        squareView.put("HIT", hit);
        squareView.put("MISSED", missed);
        squareView.put("WATER", water);
        squareView.put("SHIP", ship);
        return squareView.get(this.getStatus());
    }
}