package bullscows;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int bulls = 0;
    public static int cows = 0;
    public static int secretNumber = 9305;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = scanner.nextInt();
        Random random = new Random();
        //secretNumber = random.nextInt(10000);
        scoreBulls(inputNumber);
    }

    public static void scoreBulls(int inputNumber) {
        if (inputNumber == secretNumber) {
            bulls = 4;
            printResult();
            return;
        }
        String input = String.valueOf(inputNumber);
        String secret = String.valueOf(secretNumber);
        for (int i = 0; i < 4; i++) {
            if (input.charAt(i) == secret.charAt(i)) {
                bulls++;
            }
        }
        scoreCows(inputNumber);
    }

    public static void scoreCows(int inputNumber) {
        String input = String.valueOf(inputNumber);
        String secret = String.valueOf(secretNumber);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (input.charAt(i) == secret.charAt(j) && i != j) {
                    cows++;
                    break;
                }
            }
        }

        printResult();
    }

    public static void printResult() {
        if (bulls == 0 && cows == 0) {
            System.out.println("Grade: None.  The secret code is " + secretNumber + ".");
        } else {
            System.out.println("Grade: " + bulls + " bull(s) and " + cows + " cow(s). The secret code is " + secretNumber + ".");
        }
    }

}
