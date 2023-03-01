package practice;

import java.util.*;

public class EmailList {
    TreeSet<String> words = new TreeSet<>();

    public void add(String email) {
        String string = "[A-Za-z]+";
        String regex = string + "@" + string + "[.rucom]{3,4}";
        String text;
        text = email.toLowerCase(Locale.ROOT);
        if (email.matches(regex)) {
            words.add(text);
        }
        // TODO: валидный формат email добавляется, email это строка, она быть может любой
        // принять решение добавлять аргумент email или нет должен этот метод
    }

    public List<String> getSortedEmails() {
        // TODO: возвращается сортированный список электронных адресов в алфавитном порядке
        return new ArrayList<>(words);
    }

}
