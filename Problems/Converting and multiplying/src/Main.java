import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s;
        ArrayList<String> list = new ArrayList<>();
        while (!(s = scanner.next()).equals("0")) {
            list.add(s);
        }

        for (String i : list) {
            try {
                System.out.println(Integer.parseInt(i) * 10);
            } catch (NumberFormatException e) {
                System.out.println("Invalid user input: " + i);
            }
        }
    }
}