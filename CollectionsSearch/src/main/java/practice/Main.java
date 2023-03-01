package practice;


import java.util.*;

public class Main {
    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска введимого номера в консоль в каждой из структуры данных
     - проанализоровать полученные данные
     */

    public static void main(String[] args) {
        HashSet<String> coolNum = new HashSet<>(CoolNumbers.generateCoolNumbers());
        TreeSet<String> coolTree = new TreeSet<>(CoolNumbers.generateCoolNumbers());
        List<String> coolList = new ArrayList<>(CoolNumbers.generateCoolNumbers());

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите номер: ");
            String input = scanner.next();
            System.out.println(CoolNumbers.bruteForceSearchInList(coolList, input));
            System.out.println(CoolNumbers.binarySearchInList(coolList, input));
            System.out.println(CoolNumbers.searchInHashSet(coolNum, input));
            System.out.println(CoolNumbers.searchInTreeSet(coolTree, input));
        }


    }
}
