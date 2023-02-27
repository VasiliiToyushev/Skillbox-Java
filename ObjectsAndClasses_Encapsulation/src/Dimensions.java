package ObjectsAndClasses_Encapsulation.src;

public class Dimensions {
    private final int width;
    private final int height;
    private final int length;
    private final int cargoVolume;

    public Dimensions(int width, int height, int length) {
        this.width = width;
        this.height = height;
        this.length = length;
        this.cargoVolume = length * width * height;
    }
    public int getCargoVolume() {
        return cargoVolume;
    }
    }





