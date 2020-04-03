
public class Common {

    public static void clearScreen(){
        try {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static int getUserIntChoice(){
        System.out.print("\nYour choice : ");
        Main.intChoice = Main.scan.nextInt();
        return Main.intChoice;
    }

    public static String getUserStringChoice(String title){
        System.out.print("\n" + title + "\n");
        Main.stringChoice = Main.scan.next();
        return Main.stringChoice;
    }
}