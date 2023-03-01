package practice;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        String regexPhone = "7[0-9]{10}";
        String regexName = "[A-zА-яёЁ]{1,10}";

        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            System.out.println("Введите номер, имя или команду:");
            String text = scanner.nextLine();
            if (text.equals("LIST")) {
                System.out.println(phoneBook.getAllContacts());
                continue;
            }

            if (!(text.matches(regexName) || text.matches(regexPhone))) {
                System.out.println("Неверный формат ввода");
            }
            if (phoneBook.getContactByName(text).size() > 0) {
                System.out.println(phoneBook.getContactByName(text));

            } else if (text.matches(regexName)) {
                System.out.println("Такого имени в телефонной книге нет.");
                System.out.println("Введите номер телефона для абонента " + text);

                Scanner scanner1 = new Scanner(System.in);
                String textPhone = scanner1.nextLine();

//                if (!textPhone.matches(regexPhone)) {
//                    System.out.println("Неверный формат ввода");
//                }

                if (textPhone.matches(regexPhone)) {
                    phoneBook.addContact(textPhone, text);
                    System.out.println("Контакт сохранен!");
                }
            }

            if (text.matches(regexPhone)) {
                System.out.println("Такого номера нет в телефонной книге.");
                System.out.println("Введите имя абонента для номера " + text);

                Scanner scanner2 = new Scanner(System.in);
                String textName = scanner2.nextLine();

//                if (!textName.matches(regexName)) {
//                    System.out.println("Неверный формат ввода");
//                }

                if (textName.matches(regexName)) {
                    phoneBook.addContact(text, textName);
                    System.out.println("Контакт сохранен!");
                }
            }
        }
    }
}
