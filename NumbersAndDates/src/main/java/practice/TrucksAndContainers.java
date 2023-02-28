package practice;

import java.util.Scanner;

public class TrucksAndContainers {
    private static final int TRUCK_FITS_MAXIMUM = 12;
    private static final int CONTAINER_FITS_MAXIMUM = 27;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //получение количество коробок от пользователя
        int boxes = scanner.nextInt();

        int container = 0;
        int boxesCount = 0;
        int truck = 0;

        if (boxes > 0) {
            container = 1;
            truck = 1;
            System.out.println("Грузовик: " + truck);
            System.out.println("\tКонтейнер: " + container);
            while (true) {
                if (boxes <= boxesCount) {
                    break;
                }
                if (boxesCount % CONTAINER_FITS_MAXIMUM == 0 && boxesCount != 0) {
                    if (container % TRUCK_FITS_MAXIMUM == 0) {
                        truck++;
                        System.out.println("Грузовик: " + truck);
                    }
                    container++;
                    System.out.println("\tКонтейнер: " + container);
                }
                boxesCount++;
                System.out.println("\t\tЯщик: " + boxesCount);
            }
        }
        System.out.println("Необходимо:" + "\n" +
                "грузовиков - " + truck + " шт." + "\n" +
                "контейнеров - " + container + " шт.");

        // TODO: вывести в консоль коробки разложенные по грузовикам и контейнерам
        // пример вывода при вводе 2
        // для отступа используйте табуляцию - \t

        /*
        Грузовик: 1
            Контейнер: 1
                Ящик: 1
                Ящик: 2
        Необходимо:
        грузовиков - 1 шт.
        контейнеров - 1 шт.
        */

    }
}





