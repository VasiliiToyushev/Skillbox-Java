package practice.regex;

import java.util.Scanner;

public class PhoneCleanerRegex {

    public static void main(String[] args) {
        String regex1 = "7[0-9]{10}";
        String regex2 = "[0-9]{10}";
        String regex3 = "8[0-9]{10}";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            input = input.replaceAll("[^0-9]", "");
            if (input.equals("0")) {
                scanner.close();
                break;
            }
            if (input.matches(regex2)) {
                System.out.println("7" + input);
            } else if (input.matches(regex3)) {
                System.out.println(input.replaceFirst("8", "7"));
            } else if (input.matches(regex1)) {
                System.out.println(input);
            } else {
                System.out.println("Неверный формат номера");
            }
        }
    }
}

