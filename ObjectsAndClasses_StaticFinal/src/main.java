package ObjectsAndClasses_StaticFinal.src;

public class main {
    public static void main(String[] args) {

        Computer computer = new Computer("Китай", "Acer");
        computer.setCpu(new CPU(4.4, 6, CPUManufacturer.INTEL, 30));
        computer.setRam(new RAM(RAMType.DDR4,64,20));
        computer.setInformationStorage(new InformationStorage(StorageType.SSD, 1, 80));
        computer.setScreen(new Screen(16,ScreenType.IPS,5000));
        computer.setKeyboard(new Keyboard(KeyboardType.MAGNETIC, true, 600));
        computer.toString();


        computer = computer.setVendor("Тайвань");
        computer = computer.setName("Asus");
        computer.setCpu(new CPU(2.5, 4, CPUManufacturer.AMD, 35));
        computer.setRam(new RAM(RAMType.DDR3, 32, 25));
        computer.setInformationStorage(new InformationStorage(StorageType.HDD, 2, 85));
        computer.setScreen(new Screen(20, ScreenType.VA, 2500));
        computer.setKeyboard(new Keyboard(KeyboardType.MECHANICAL, false, 900));
        computer.toString();




    }
}


