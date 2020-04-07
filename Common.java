import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Common {

    public static Character[] letters = new Character[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
    public static String[] numbers = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    public static Map<Character, String> lettersToNums;



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

    public static String getOrientation(String title){
        System.out.println(title + "\n");
        String orientation = "";
        boolean isOk = false;
        while(!isOk){
            orientation = Main.scan.next().toUpperCase();
            if(orientation.equalsIgnoreCase("H") || orientation.equalsIgnoreCase("V")){
                isOk = true;
            }
        }
        return orientation;
    }

    public static String getUserPosition(String title){
        System.out.println(title);
        String userInput = "";
        boolean isOk = false;
        while(!isOk){
            userInput = Main.scan.next().toUpperCase();
            if(userInput.length() > 1 &&  Arrays.asList(letters).contains(userInput.charAt(0))
             && Arrays.asList(numbers).contains(userInput.substring(1))){
                isOk = true;
            }
            else{
                System.out.println("Please enter vailid input, eg. G4.");
            }
        }
        return userInput;
    }

    public static int letterToNumber(char letter){
        lettersToNums = new HashMap<>();
        for(int i = 0; i < letters.length; i++){
            lettersToNums.put(letters[i], numbers[i]);
        }
        int number = Integer.parseInt(lettersToNums.get(letter));
        return number;
    }
    
}