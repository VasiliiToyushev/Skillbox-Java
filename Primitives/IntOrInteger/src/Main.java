package Primitives.IntOrInteger.src;

public class Main {
    public static void main(String[] args) {
//        Container container = new Container();
//        container.addCount(5672);
//        System.out.println(container.getCount());

        // TODO: ниже напишите код для выполнения задания:
        //  С помощью цикла и преобразования чисел в символы найдите все коды
        //  букв русского алфавита — заглавных и строчных, в том числе буквы Ё.


        char symbol, symbol1 = 0, symbol2 = 0, symbolStart = 0, symbolEnd = 0;
        int num1 = 0, num2 = 0;
        for (int i = 0; i < Character.MAX_VALUE; i++) {
            symbol = (char) i;
            if (symbol == 'Ё'){
                num1 = i;
                symbol1 = symbol;
            }
            if (symbol == 'ё'){
                num2 = i;
                symbol2 = symbol;
            }
            if (symbol == 'А') symbolStart = symbol;

            if (symbol == 'я') symbolEnd = symbol;
        }

        for (int i = symbolStart; i <= symbolEnd; i++) {
            System.out.println(i + " - " + symbolStart);
            symbolStart++;
            if (symbolStart == 'Ж') System.out.println(num1 + " - " + symbol1);
            if (symbolStart == 'ж') System.out.println(num2 + " - " + symbol2);
        }
    }
}

