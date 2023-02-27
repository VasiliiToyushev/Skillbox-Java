package ObjectsAndClasses_StaticFinal.src;

public class Keyboard {
    private final KeyboardType keyboardType;//тип
    private final boolean presenceOfIllumination;//наличие подсветки
    private final int weight;//вес

    public Keyboard(KeyboardType keyboardType, boolean presenceOfIllumination, int weight) {
        this.keyboardType = keyboardType;
        this.presenceOfIllumination = presenceOfIllumination;
        this.weight = weight;
    }

    public KeyboardType getKeyboardType() {
        return keyboardType;
    }

    public boolean isPresenceOfIllumination() {
        return presenceOfIllumination;
    }
    public int getWeight() {
        return weight;
    }
}

