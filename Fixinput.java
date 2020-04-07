import java.util.Scanner;

class Fixinput {

    public static String numbers = "123456789";
    public static String alphabet = "abcdefghij";
    public static String validInput =checkingValues(numbers, alphabet);

    public static String checkingValues(String numbers, String alphabet) {
        boolean valid = false;
        String validinput = "";

        do {System.out.println("type co-ordinates");
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine().toLowerCase();

            if ((input.length() == 2 || input.length() == 3 && input.contains("10")) == false) {
                System.out.println("invalid input, try something like this: 'A4'");
            } 
            else if (alphabet.indexOf(input.charAt(0)) == -1) {
                System.out.println("try another letter please");
            } 
            else if (numbers.indexOf(input.charAt(1)) == -1) {
                System.out.println("try another digit please");
            } 
            else {        
                scan.close();
                validinput = input;
                valid = true;
            }
        } while (valid == false);

        return validinput;
    }

    public static String convert(String validinput, String alphabet, String numbers) {
        int first = alphabet.indexOf(validinput.charAt(0));
        String secound = "";
        if (validinput.length() == 2){
        secound = String.valueOf(numbers.indexOf(validinput.charAt(1)));}
        if (validinput.length() == 3){
        secound = "9";}
        StringBuilder converted = new StringBuilder();
        converted.append(first);
        converted.append(secound);
        System.out.println(converted.toString());
        return converted.toString();
    }
  //  public static void main(String args[]){
    //    String validInput =checkingValues(numbers, alphabet);
     //   convert(validInput, alphabet, numbers);
        
  //  }
}

 