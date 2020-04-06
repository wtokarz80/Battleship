import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static boolean keepGoing;
    public static Scanner scan;
    public static int intChoice;
    public static String stringChoice;
    public static Map<Integer, Runnable> commandsMenu;
    public static Map<Integer, Runnable> commandsSubmenu;

    public static void main(String[] args) {

        keepGoing = true;
        while (keepGoing) {
            Common.clearScreen();
            scan = new Scanner(System.in);
            scan.useDelimiter(System.lineSeparator());
            Display.displayHello();
            intChoice = Common.getUserIntChoice();
            runUserMainChoice(intChoice);
        }
    }

    private static void runUserMainChoice(int intChoice) {
        commandsMenu = new HashMap<>();
        commandsMenu.put(1, () -> newGame());
        commandsMenu.put(2, () -> Display.about());
        commandsMenu.put(3, () -> exitGame());
        commandsMenu.get(intChoice).run();
    }

    private static void newGame() {
        Display.displayNewGame();
        intChoice = Common.getUserIntChoice();
        runUserSubmenuChoice(intChoice);

    }

    private static void runUserSubmenuChoice(int intChoice) {
        commandsSubmenu = new HashMap<>();
        commandsSubmenu.put(1, () -> pvpGame());
        commandsSubmenu.put(2, () -> pvcGame());
        commandsSubmenu.put(3, () -> cvcGame());
        commandsSubmenu.put(4, () -> backToMain());
        commandsSubmenu.get(intChoice).run();
    }

    private static void pvpGame() {
        System.out.println("PVP Game");
        Ocean board = new Ocean(10);
        System.out.println(board);
        stringChoice = Common.getUserStringChoice("Do you want play again[y/n]");
        if (stringChoice.equalsIgnoreCase("y")) {
            keepGoing = true;
        } else if (stringChoice.equalsIgnoreCase("n")) {
            keepGoing = false;
        }
    }

    private static void pvcGame() {
        System.out.println("PVC Game");
        Ocean board = new Ocean(10);
        System.out.println(board);
        stringChoice = Common.getUserStringChoice("Do you want play again[y/n]");
        if (stringChoice.equalsIgnoreCase("y")) {
            keepGoing = true;
        } else if (stringChoice.equalsIgnoreCase("n")) {
            keepGoing = false;
        }
    }

    private static void cvcGame() {
        System.out.println("CVC Game");
        Ocean board = new Ocean(10);
        System.out.println(board);
        stringChoice = Common.getUserStringChoice("Do you want play again[y/n]");
        if (stringChoice.equalsIgnoreCase("y")) {
            keepGoing = true;
        } else if (stringChoice.equalsIgnoreCase("n")) {
            keepGoing = false;
        }
    }

    public static void backToMain(){
        keepGoing = true;
    }
    
    public static void exitGame() {
        keepGoing = false;
    }

}