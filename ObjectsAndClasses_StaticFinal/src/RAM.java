package ObjectsAndClasses_StaticFinal.src;

public class RAM {
    private final RAMType ramType;//тип
    private final int volume;//объём
    private final int weight;//вес
    public RAM(RAMType ramType, int volume, int weight) {
        this.ramType = ramType;
        this.volume = volume;
        this.weight = weight;
    }
    public RAMType getRamType() {
        return ramType;
    }

    public int getVolume() {
        return volume;
    }

    public int getWeight() {
        return weight;
    }
}

