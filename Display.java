import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Display {

   public static void displayHello(){
   
    System.out.println(" WELCOME TO : ");
    int width = 100;
    int height = 30;
    System.out.print(Colors.RED_BOLD);

    //BufferedImage image = ImageIO.read(new File("/Users/mkyong/Desktop/logo.jpg"));
    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    Graphics g = image.getGraphics();
    g.setFont(new Font("SansSerif", Font.HANGING_BASELINE, 12));

    Graphics2D graphics = (Graphics2D) g;
    graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    graphics.drawString("BATTLE SHIPS", 0, 20);

    for (int y = 0; y < height; y++) {
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < width; x++) {

            sb.append(image.getRGB(x, y) == -16777216 ? " " : "$");

        }

        if (sb.toString().trim().isEmpty()) {
            continue;
        }
        System.out.println(sb);
    }
    System.out.print(Colors.RESET);
      System.out.println("");
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~\n"
                        + "|    M   E   N   U    |\n"
                        + "|---------------------|\n"
                        + "| 1 - New game        |\n"
                        + "| 2 - About           |\n"
                        + "| 3 - Exit game       |\n"
                        + "~~~~~~~~~~~~~~~~~~~~~~~\n");

   }



   public static void showBoard(){
      Ocean board = new Ocean(10);
      System.out.println(board);
   }

   public static void about(){

      Common.clearScreen();
      
      System.out.println("\n    Battleship (or Sea Battle[1]) is a strategy type guessing game for two players.\n"
      + "It is played on ruled grids (paper or board) on which each player's fleet of ships\n"
      + "(including battleships) are marked. The locations of the fleets are concealed from\n"
      + "the other player. Players alternate turns calling 'shots' at the other player's ships,\n"
      + "and the objective of the game is to destroy the opposing player's fleet.\n"
      + "Battleship is known worldwide as a pencil and paper game which dates from World War I.\n"
      + "It was published by various companies as a pad-and-pencil game in the 1930s,\n"
      + "and was released as a plastic board game by Milton Bradley in 1967.\n"
      + "The game has spawned electronic versions, video games, smart device apps and a film.\n"
      + "    For more info how to play, go to: https://www.cs.nmsu.edu/~bdu/TA/487/brules.htm");

      System.out.println("\nPress enter to back to menu.\n");
      Main.scan.next();
   }

   public static void displayNewGame(){
      System.out.println("");
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                        + "|         NEW GAME         |\n"
                        + "|--------------------------|\n"
                        + "| 1 - Player vs Player     |\n"
                        + "| 2 - Player vs Computer   |\n"
                        + "| 3 - Computer vs Computer |\n"
                        + "| 4 - Back to main menu    |\n"
                        + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
   }
}