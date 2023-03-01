package practice;

import java.util.Scanner;


public class Main {
    public static EmailList emailList = new EmailList();
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";
    public static final String ADD = "ADD";
    public static final String LIST = "LIST";

    
    /* TODO:
        Пример вывода списка Email, после ввода команды LIST в консоль:
        test@test.com
        hello@mail.ru
        - каждый адрес с новой строки
        - список должен быть отсортирован по алфавиту
        - email в разных регистрах считается одинаковыми
           hello@skillbox.ru == HeLLO@SKILLbox.RU
        - вывод на печать должен быть в нижнем регистре
           hello@skillbox.ru
        Пример вывода сообщения об ошибке при неверном формате Email:
        "Неверный формат email"
    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = "[A-Za-z]+";
        String regex = string + "@" + string + "[.rucom]{3,4}";
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            switch (input) {
                case ADD -> {
                    String str = scanner.nextLine().trim();
                    if (!str.matches(regex)) {
                        System.out.println(WRONG_EMAIL_ANSWER);
                    }
                    emailList.add(str);
                }
                case LIST -> {
                    for (int i = 0; i < emailList.getSortedEmails().size(); i++) {
                        System.out.println(i + " - " + emailList.getSortedEmails().get(i));
                    }
                }
                default -> System.out.println("error");
            }
        }
    }
}
