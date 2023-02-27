package ObjectsAndClasses_Encapsulation.src;

public class Elevator {
    public int currentFloor = 1;
    public int minFloor;
    public int maxFloor;
    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }
    public void moveDown() {
        currentFloor--;
        System.out.println("Этаж: " + currentFloor);
    }
    public void moveUp() {
        currentFloor++;
        System.out.println("Этаж: " + currentFloor);
    }
    public void move(int floor) {
        if (floor > maxFloor || floor < minFloor) {
            System.out.println("error");

        } else if (currentFloor < floor ) {
            for (;currentFloor < floor;)moveUp();

        } else if (currentFloor > floor) {
            for (;currentFloor > floor;)moveDown();

        }
    }
}
