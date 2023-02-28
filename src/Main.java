import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        HashSet<Integer> secretNumber = randomNumberGenerator();
        String number = randomStringGenerator(secretNumber);
        feedback(number);
    }

    public static HashSet<Integer> randomNumberGenerator() {
        Random random = new Random();
        HashSet<Integer> randomNumber = new HashSet<>();
        while (randomNumber.size() < 4){
            int x = random.nextInt(10);
            randomNumber.add(x);
        }
        return randomNumber;
    }

    public static String randomStringGenerator(HashSet<Integer>randomNumber){

        StringBuilder newString = new StringBuilder();

        for (Integer x : randomNumber) {
            newString.append(x.toString());
        }
        return newString.toString();
    }

    /*
     Deze methode is voor de bonus opdracht.
     */
    public static void feedback(String stringnumber) {

        Scanner scanner = new Scanner(System.in);
        StringBuilder feedback = new StringBuilder();
        boolean guessing = true;
        while (guessing) {
            System.out.println("take a guess");
            String guess = scanner.nextLine();
            for (int i = 0; i < 4; i++) {
                if (guess.substring(i, i + 1).equals(stringnumber.substring(i, i + 1))) {
                    feedback.append("+");
                } else if (stringnumber.contains(guess.substring(i, i + 1))) {
                    feedback.append("0");
                } else feedback.append("X");
                if (Objects.equals(guess, stringnumber)) {
                    System.out.println("gefeliciteerd je hebt het goed");
                    feedback.delete(i,i+1);
                    guessing = false;
                    break;
                }
            }System.out.println(feedback);
            feedback.setLength(0);
        }
    }
}
