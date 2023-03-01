package practice;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static TodoList todoList = new TodoList();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();

            switch (input) {
                case "LIST" -> {
                    for (int i = 0; i < todoList.getTodos().size(); i++) {
                        System.out.println(i + " - " + todoList.getTodos().get(i));
                    }
                }
                case "ADD" -> {
                    String str = scanner.nextLine().trim();
                    if (str == "") {
                        System.out.println("error");
                        break;
                    }
                    if (Character.isDigit(str.charAt(0))) {
                        todoList.add(Integer.parseInt(str.replaceAll("[^0-9]", "").trim()),
                                str.replaceAll("[0-9]", "").trim());
                        break;
                    }
                    todoList.add(str);
                    }
                case "DELETE" -> todoList.delete(scanner.nextInt());
                case "EDIT" -> todoList.edit(scanner.nextInt(), scanner.nextLine().trim());
                case "EX" -> System.out.println("EXIT");
                default -> System.out.println("error");

            }
            if ("EX".equals(input))break;
        }
        // TODO: написать консольное приложение для работы со списком дел todoList
    }
}
