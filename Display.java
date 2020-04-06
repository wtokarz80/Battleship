import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Display {

   public static void displayHello(){
      System.out.println(" WELCOME TO BATTLESHIP");
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