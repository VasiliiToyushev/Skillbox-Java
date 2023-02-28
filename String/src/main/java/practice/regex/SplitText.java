package practice.regex;

public class SplitText {

  public static void main(String[] args) {
    String text = "Hello       i" +
            ",  " +
            " 77" +
            "    am 45  Katy.";
    System.out.println(splitTextIntoWords(text));
  }
  public static String splitTextIntoWords(String text) {
    StringBuilder result = new StringBuilder();
    String t = text.replaceAll("[\\d\\p{P}]+", "");
    String[] word = t.split("\\s+");
    for (String s : word) {
      result.append(s.concat("\n"));
    }
    //TODO реализуйте метод
    return result.toString().trim();
  }
}
