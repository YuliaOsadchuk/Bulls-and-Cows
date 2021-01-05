package bullscows;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int bulls = 0;
    public static int cows = 0;
    public static String secretNumber;

    public static void main(String[] args) {
        System.out.println("Input the length of the secret code:");
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        if (count > 36) {
            System.out.println("Error: can't generate a secret number with a length of " + count +
                    " because there aren't enough unique digits.");
            return;
        }
        String[] symbols = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f",
                "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        System.out.println("Input the number of possible symbols in the code:");
        int numberPossible = scanner.nextInt();
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        while (stringBuilder.length() != count) {
            int generate = random.nextInt(numberPossible);
            if (!stringBuilder.toString().contains(symbols[generate])) {
                stringBuilder.append(symbols[generate]);
            }
        }
        secretNumber = stringBuilder.toString();
        System.out.println(secretNumber);
        StringBuilder stringSymbols = new StringBuilder();
        stringSymbols.append("The secret is prepared: ");
        for (int i = 0; i < count; i++) {
            stringSymbols.append("*");
        }
        stringSymbols.append(" (0-");
        if (numberPossible > 10) {
            stringSymbols.append("9, a");
            if (numberPossible > 11 && numberPossible < 36) {
                stringSymbols.append("-");
            }
        }
        stringSymbols.append(symbols[numberPossible - 1]);
        stringSymbols.append(").");


        System.out.println(stringSymbols);
        System.out.println("Okay, let's start a game!");

        int turn = 1;
        while (bulls != count) {
            System.out.println("Turn " + turn + ":");
            scoreBulls(scanner.next());
            turn++;
            printResult(count);
        }


    }

    public static void scoreBulls(String inputNumber) {
        bulls = 0;
        cows = 0;

        String secret = String.valueOf(secretNumber);
        for (int i = 0; i < inputNumber.length(); i++) {
            if (inputNumber.charAt(i) == secret.charAt(i)) {
                bulls++;
            } else if (inputNumber.contains(String.valueOf(secret.charAt(i)))) {
                cows++;
            }
        }
    }

    public static void printResult(int count) {
        if (bulls == 0 && cows == 0) {
            System.out.println("Grade: None.");
        } else if (bulls == count) {
            System.out.println("Grade: " + bulls + " bulls");
            System.out.println("Congratulations! You guessed the secret code.");
        } else {
            System.out.println("Grade: " + bulls + " bull(s) and " + cows + " cow(s).");
        }
    }

}
