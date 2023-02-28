package practice.string;
import java.util.Scanner;
public class SequentialWordsNumbers {
    public static void main(String[] args) {
        System.out.println("Введите текст:");
        String enterText = new Scanner(System.in).nextLine();
        sequentialWordsNumbers(enterText);
    }
    public static String sequentialWordsNumbers(String text) {
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if (i == 0) {
                index++;
                stringBuilder.append("(" + index + ") ");
            }
            if (symbol == ' ') {
                index++;
                stringBuilder.append(" (" + index + ")");
            }
            if (!Character.isDigit(symbol)) {
                stringBuilder.append("" + symbol);
            }
        }
        return stringBuilder.toString();
    }
}