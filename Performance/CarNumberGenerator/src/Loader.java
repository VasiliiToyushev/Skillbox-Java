import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Loader {

    public static void main(String[] args)  {
        List<Thread> threadList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            threadList.add(new Thread(() -> {
                try {
                    run(finalI);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }));
        }
        threadList.forEach(Thread::start);

}

    private static StringBuilder padNumber(int number, int numberLength) {
        StringBuilder stringBuilderNum = new StringBuilder();
        String numberStr = Integer.toString(number);
        int padSize = numberLength - numberStr.length();
        for (int i = 0; i < padSize; i++) {
            stringBuilderNum.append("0");
        }
        stringBuilderNum.append(numberStr);
        return stringBuilderNum;
    }

    private static void run(int i) throws IOException {

        long start = System.currentTimeMillis();

        FileOutputStream writer = new FileOutputStream(
                "res/numbers".concat(String.valueOf(i)).concat(".txt"));

        char[] letters = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};
        StringBuilder stringBuilder = new StringBuilder();
        for (int number = 1; number < 1000; number++) {
            int regionCode = 199;
            for (char firstLetter : letters) {
                for (char secondLetter : letters) {
                    for (char thirdLetter : letters) {
                        stringBuilder.append(firstLetter)
                                .append(padNumber(number, 3))
                                .append(secondLetter)
                                .append(thirdLetter)
                                .append(padNumber(regionCode, 2))
                                .append("\n");
                    }
                }
            }
        }
        writer.write(stringBuilder.toString().getBytes());

        writer.flush();
        writer.close();

        System.out.println((System.currentTimeMillis() - start) + " ms");
    }
}
