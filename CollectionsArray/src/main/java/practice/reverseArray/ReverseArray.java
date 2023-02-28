package practice.reverseArray;

public class ReverseArray {


    public static String[] reverse(String[] strings) {
        String[] words = new String[strings.length];
        for (int i = strings.length - 1; i >= 0; i--) {
            words[i] = strings[strings.length - 1 - i];
        }
        for (int j = 0; j < words.length; j++){
            strings[j] = words[j];
            System.out.println(strings[j]);
        }
        //TODO: Напишите код, который меняет порядок расположения элементов внутри массива на обратный.
        return strings ;
    }
}