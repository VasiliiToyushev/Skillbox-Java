package ObjectsAndClasses_StaticFinal.src;

public class InformationStorage {
    private final StorageType storageType;//тип — HDD, SSD
    private final int memorySize;//объём памяти
    private final int weight;//вес

    public InformationStorage(StorageType storageType, int memorySize, int weight) {
        this.storageType = storageType;
        this.memorySize = memorySize;
        this.weight = weight;
    }
    public StorageType getStorageType() {
        return storageType;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public int getWeight() {
        return weight;
    }
}

