package bullscows;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int bulls = 0;
    public static int cows = 0;
    public static int secretNumber;

    public static void main(String[] args) {
        System.out.println("Please, enter the secret code's length:");
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        if (count > 10) {
            System.out.println("Error: can't generate a secret number with a length of " + count +
                    " because there aren't enough unique digits.");
            return;
        }

        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        while (stringBuilder.length() != count) {
            String generate = String.valueOf(random.nextInt(10));
            if (!stringBuilder.toString().contains(generate)) {
                stringBuilder.append(generate);
            }
        }
        secretNumber = Integer.parseInt(stringBuilder.toString());
        //System.out.println(secretNumber);
        /*long pseudoRandomNumber = System.nanoTime();
        String pseudoString = String.valueOf(pseudoRandomNumber);
        if (pseudoString.startsWith("0")) {
            pseudoString = pseudoString.substring(1);
        }
        StringBuilder stringBuilder = new StringBuilder();

        int i = 0;
        while (stringBuilder.length() != count) {
            String s = String.valueOf(pseudoString.charAt(i));

            if (pseudoString.length() - 1 == i) {
                pseudoString = String.valueOf(System.nanoTime());
                i = 0;
            }
            i++;
            if (stringBuilder.toString().contains(s)) {
                continue;
            } else {
                stringBuilder.append(s);
            }

        }*/
        //secretNumber = Integer.parseInt(stringBuilder.toString());

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
