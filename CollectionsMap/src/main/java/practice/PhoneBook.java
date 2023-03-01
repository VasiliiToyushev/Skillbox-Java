package practice;

import java.util.*;

public class PhoneBook {

    TreeMap<String, String> phonesNames = new TreeMap<>();

    String regexName = "[A-zА-яёЁ]{1,10}";
    String regexPhone = "7[0-9]{10}";

    public void addContact(String phone, String name) {
        phonesNames.put(phone, name);
        // проверьте корректность формата имени и телефона
        // (рекомедуется написать отдельные методы для проверки является строка именем/телефоном)
        // если такой номер уже есть в списке, то перезаписать имя абонента
    }


    public String getContactByPhone(String phone) {

        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку

        return phonesNames.get(phone) + " - " + phone;
    }

    public Set<String> getContactByName(String name) {
        List<String> contact = new ArrayList<>();
        StringBuilder phoneNum = new StringBuilder();
        if (phonesNames.containsValue(name)) {

            for (Map.Entry<String, String> entry : phonesNames.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (name.equals(value)) {
                    phoneNum.append(key).append(", ");
                }
            }
            int indexDel = phoneNum.lastIndexOf(",");
            phoneNum = new StringBuilder(phoneNum.substring(0, indexDel));
            contact.add(name + " - " + phoneNum);
        } else {
            contact = new ArrayList<>();


            // формат одного контакта "Имя - Телефон"
            // если контакт не найден - вернуть пустой TreeSet

        }
        return new TreeSet<>(contact);
    }

    public Set<String> getAllContacts() {
        Set<String> allContacts = new TreeSet<>();
        String result;
        for (Map.Entry<String, String> entry : phonesNames.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            result = getContactByName(value).toString().replaceAll("\\[", "").replaceAll("]", "");
            allContacts.add(result);
            if (!(key.matches(regexPhone) && value.matches(regexName))) {
                return new TreeSet<>();
            }
        }
        return allContacts;
    }
}


// для обхода Map используйте получение пары ключ->значение Map.Entry<String,String>
// это поможет вам найти все ключи (key) по значению (value)
    /*
        for (Map.Entry<String, String> entry : map.entrySet()){
            String key = entry.getKey(); // получения ключа
            String value = entry.getValue(); // получения ключа
        }
    */
