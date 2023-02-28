package practice.twoDimensionalArray;

public class TwoDimensionalArray {

    public static final char SYMBOL = 'X';
    public static char[][] getTwoDimensionalArray(int size) {
        char[][] array = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++){
                if (j == i || i + j == size - 1) {
                    array[i][j] = SYMBOL;
                } else {
                    array[i][j] = ' ';
                }
            }
            //TODO: Написать метод, который создаст двумерный массив char заданного размера.
            // массив должен содержать символ SYMBOL по диагоналям, пример для size = 3
            // [X,  , X]
            // [ , X,  ]
            // [X,  , X]
        }
        return array;
    }
}
