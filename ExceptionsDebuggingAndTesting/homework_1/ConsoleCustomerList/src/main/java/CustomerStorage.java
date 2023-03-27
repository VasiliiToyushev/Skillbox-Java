import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String regexPhone = "[+]7[0-9]{10}";
        String string = "[A-Za-z.]{1,20}";
        String regexMail = string + "@" + string + "[.rucom]{3,4}";

        String[] components = data.split("\\s+");
        if (components.length != 4) {
            throw new IllegalArgumentException("Неверный формат. Пример правильного формата: \n" +
                    "add Василий Петров vasily.petrov@gmail.com +79215637722");
        }
        if (!components[INDEX_PHONE].matches(regexPhone) || !components[INDEX_EMAIL].matches(regexMail)) {
            throw new IllegalArgumentException("Неверный формат телефона или email." +
                    " Пример правильного формата: \n" +
            "add Василий Петров vasily.petrov@gmail.com +79215637722");
        }
        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];

        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}