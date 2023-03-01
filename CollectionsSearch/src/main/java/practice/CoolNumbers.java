package practice;

import java.util.*;

public class CoolNumbers {
    public static ArrayList<String> coolNum = new ArrayList<>();

    public static List<String> generateCoolNumbers() {
        String[] numbers = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
        for (String x : numbers) {
            for (int n = 111; n <= 999; n += 111) {
                for (String y : numbers) {
                    for (String z : numbers) {
                        for (int r = 1; r <= 199; r++) {
                            coolNum.add(String.format("%s%03d%s%s%02d", x, n, y, z, r));
                        }
                    }
                }
            }
        }
//        Collections.sort(coolNum);
        return coolNum;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        long time = System.nanoTime();
        for (String str : list) {
            if (str.equals(number)) {
                System.out.println(number);
                System.out.println("Поиск перебором: номер найден, поиск занял " +
                        (double) (System.nanoTime() - time) + "нс");
                return true;
            }
        }
        System.out.println("Поиск перебором: номер не найден, поиск занял "
                + (double) (System.nanoTime() - time) + " нс");
        return false;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        Collections.sort(sortedList);
        long time = System.nanoTime();
        int index = Collections.binarySearch(sortedList, number);
        if (index >= 0) {
            System.out.println(number);
            System.out.println("Бинарный поиск: номер найден, поиск занял "
                    + (double) (System.nanoTime() - time) + " нс");
            return true;
        } else {
            System.out.println("Бинарный поиск: номер не найден, поиск занял "
                    + (double) (System.nanoTime() - time) + " нс");
            return false;
        }
    }


    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        long time = System.nanoTime();
        if (hashSet.contains(number)) {
            System.out.println(number);
            System.out.println("Поиск в HashSet: номер найден, поиск занял "
                    + (double) (System.nanoTime() - time) + " нс");
            return true;
        }
        System.out.println("Поиск в HashSet: номер не найден, поиск занял "
                + (double) (System.nanoTime() - time) + " нс");
        return false;
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        long time = System.nanoTime();
        if (treeSet.contains(number)) {
            System.out.println(number);
            System.out.println("Поиск в TreeSet: номер найден, поиск занял "
                    + (double) (System.nanoTime() - time) + " нс");
            return true;
        }
        System.out.println("Поиск в TreeSet: номер не найден, поиск занял "
                + (double) (System.nanoTime() - time) + " нс");
        return false;
    }

}
