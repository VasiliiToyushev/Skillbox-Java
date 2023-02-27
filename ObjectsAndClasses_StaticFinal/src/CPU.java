package ObjectsAndClasses_StaticFinal.src;

public class CPU {
    private final double frequency;//частота
    private final int numberOfCores;//количество ядер
    private final CPUManufacturer cpuManufacturer;//производитель
    private final int weight;//вес

    public CPU(double frequency, int numberOfCores, CPUManufacturer cpuManufacturer, int weight) {
        this.frequency = frequency;
        this.numberOfCores = numberOfCores;
        this.cpuManufacturer = cpuManufacturer;
        this.weight = weight;
    }
    public CPUManufacturer getCpuManufacturer() {
        return cpuManufacturer;
    }

    public double getFrequency() {
        return frequency;
    }

    public int getNumberOfCores() {
        return numberOfCores;
    }

    public int getWeight() {

        return weight;
    }


}

