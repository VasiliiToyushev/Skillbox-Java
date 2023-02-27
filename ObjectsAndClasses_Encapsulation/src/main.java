package ObjectsAndClasses_Encapsulation.src;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Elevator elevator = new Elevator(-3, 26);
        while (true) {
            System.out.println("Введите номер этажа: ");
            int floor = new Scanner(System.in).nextInt();
            elevator.move(floor);
        }

//        Dimensions dimensions = new Dimensions(10, 15, 5);
//        CargoInformation cargoInformation = new CargoInformation(dimensions, 200 ,"Samara" ,true ,"vas+100500" ,false);
//        cargoInformation.allInfo();
//
//        cargoInformation = cargoInformation.setDimension(new Dimensions(12,12,12));
//        cargoInformation = cargoInformation.setWeight(500);
//        cargoInformation = cargoInformation.setProperty(false);
//        cargoInformation = cargoInformation.setDeliveryAddress("Anapa");
//        cargoInformation = cargoInformation.setRegistrationNumber("12d12d12");
//        cargoInformation = cargoInformation.setFragility(true);
//
//        cargoInformation.allInfo();
    }
}



