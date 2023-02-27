package ObjectsAndClasses_StaticFinal.src;

public class Computer {
    public CPU cpu;
    public RAM ram;
    public InformationStorage informationStorage;
    public Screen screen;
    public Keyboard keyboard;
    private final String vendor;
    private final String name;
    public int totalWeightComputer;

    public Computer(String vendor, String name) {
        this.vendor = vendor;
        this.name = name;

    }
    public String getVendor() {
        return vendor;
    }
    public Computer setVendor(String vendor) {
        return new Computer(vendor ,name);
    }
    public String getName() {
        return name;
    }
    public Computer setName(String name) {
        return new Computer(vendor, name);
    }

    public CPU getCpu() {
        return cpu;

    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;

    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public InformationStorage getInformationStorage() {
        return informationStorage;
    }

    public void setInformationStorage(InformationStorage informationStorage) {
        this.informationStorage = informationStorage;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public int getTotalWeightComputer() {
        return totalWeightComputer = cpu.getWeight() + ram.getWeight() +
                informationStorage.getWeight() + screen.getWeight() + keyboard.getWeight();
    }
    public String toString() {
        System.out.println("Компьютер");
        System.out.println("Производитель: " + getVendor());
        System.out.println("Название: " + getName());
        System.out.println("Процессор: " +
                "производитель - " + cpu.getCpuManufacturer() +
                ". Количество ядер - " + cpu.getNumberOfCores() +
                ". Частота - " + cpu.getFrequency() + " ГГц" +
                ". Вес - " + cpu.getWeight() + " грамм.");
        System.out.println("Оперативная память: " +
                "Тип - " + ram.getRamType() +
                ". Объем - " + ram.getVolume() + " ГБ" +
                ". Вес - " + ram.getWeight() + " грамм.");
        System.out.println("Накопитель информации: " +
                "Тип - " + informationStorage.getStorageType() +
                ". Объём памяти - " + informationStorage.getMemorySize() + " ТБ" +
                ". Вес - " + informationStorage.getWeight() + " грамм.");
        System.out.println("Экран: " +
                "Тип - " + screen.getScreenType() +
                ". Диагональ - " + screen.getDiagonal() +
                ". Вес - " + screen.getWeight() + " грамм.");
        System.out.println("Клавиатура: " +
                "Тип - " + keyboard.getKeyboardType() +
                ". Наличие подсветки - " + (keyboard.isPresenceOfIllumination() ? "Да" : "Нет") +
                ". Вес - " + keyboard.getWeight() + " грамм.");
        System.out.println("Общяя масса компьютера: " + getTotalWeightComputer() + " грамм.");
        System.out.println();
        return null;
    }
}


