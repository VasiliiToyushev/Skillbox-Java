package ObjectsAndClasses_Encapsulation.src;

public class CargoInformation {
    private final Dimensions dimensions;
    private final int weight;
    private final String deliveryAddress;
    private final boolean property;// можно ли переворачивать
    private final String registrationNumber;
    private final boolean fragility;// является ли груз хрупким

    public CargoInformation(Dimensions dimensions, int weight, String deliveryAddress,
                            boolean property, String registrationNumber,
                            boolean fragility) {
        this.dimensions = dimensions;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.property = property;
        this.registrationNumber = registrationNumber;
        this.fragility = fragility;
    }
    public int getDimensions() {
        return dimensions.getCargoVolume();
    }
    public CargoInformation setDimension(Dimensions dimensions) {
        return new CargoInformation(dimensions, weight, deliveryAddress ,
                property, registrationNumber, fragility);
    }

    public int getWeight() {
        return weight;
    }

    public CargoInformation setWeight(int weight) {
        return new CargoInformation(dimensions, weight, deliveryAddress ,
                property, registrationNumber, fragility);
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public CargoInformation setDeliveryAddress(String deliveryAddress) {
        return new CargoInformation(dimensions, weight, deliveryAddress ,
                property, registrationNumber, fragility);
    }

    public boolean isProperty() {
        return property;
    }

    public CargoInformation setProperty(boolean property) {
        return new CargoInformation(dimensions, weight, deliveryAddress ,
                property, registrationNumber, fragility);
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public CargoInformation setRegistrationNumber(String registrationNumber) {
        return new CargoInformation(dimensions, weight, deliveryAddress ,
                property, registrationNumber, fragility);
    }

    public boolean isFragility() {
        return fragility;
    }

    public CargoInformation setFragility(boolean fragility) {
        return new CargoInformation(dimensions, weight, deliveryAddress ,
                property, registrationNumber, fragility);
    }
    public void allInfo() {
        System.out.println("объём груза - " + getDimensions());
        System.out.println("масса - " + getWeight());
        System.out.println("адрес доставки - " + getDeliveryAddress());
        System.out.println("можно ли переворачивать - " +
                (isProperty() ? "можно" : "нельзя" ));
        System.out.println("регистрационный номер - " + getRegistrationNumber());
        System.out.println("является ли груз хрупким - " +
                (isFragility() ? "да" : "нет"));
        System.out.println();
    }
}

