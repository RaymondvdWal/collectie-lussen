import java.util.Scanner;

public class Converter {
    public static void main(String[] args) {

        Integer[] numeric = {1,2,3,4,5,6,7,8,9,0};

        String[] alphabetic = {"een", "twee", "drie", "vier", "vijf", "zes", "zeven", "acht", "negen", "nul"};

        Translator translator = new Translator(numeric,alphabetic);

        boolean play = true;
        String ongeldig = "ongeldige invoer";
        Scanner scanner = new Scanner(System.in);

        while (play){
            System.out.println("type x om te stoppen");
            System.out.println("type v om te vertalen");
            String input = scanner.nextLine();
            if (input.equals("x")) {play = false;
            }
            else if (input.equals("v")) {
                System.out.println("voer een getal van 0 tm 9 in:");
                int number = scanner.nextInt();
                scanner.nextLine();
                if (number >= 0 && number <= 9) {
                    String result = translator.Translate(number);
                    System.out.println("De vertaling van " + number + " is " + result);
                } else{
                    System.out.println(ongeldig);
                }
            }   else {
                System.out.println(ongeldig);}
        }
    }
}
