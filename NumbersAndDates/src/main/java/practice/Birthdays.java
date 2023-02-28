package practice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

public class Birthdays {

    public static void main(String[] args) {

        int day = 31;
        int month = 12;
        int year = 1990;

        System.out.println(collectBirthdays(year, month, day));
    }
    public static String collectBirthdays(int year, int month, int day) {
        LocalDate birthday = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy - E", Locale.US);

        int age = 0;
        String text = age + " - " + birthday.format(formatter);
        String text1 = "";

        if (birthday.isAfter(today)){
            return "";
        }
        while (true) {
            System.out.println(age + " - " + birthday.format(formatter));

            if (birthday.equals(today.minusYears(1))){
                age++;
                birthday = birthday.plusYears(1);
                text1 = age + " - " + birthday.format(formatter);
                return text + "\n" + text1;
            }
            if (Objects.equals(birthday.getYear(), today.getYear())){
                break;
            }
            age++;
            birthday = birthday.plusYears(1);
        }
        return text;
    }
}

