package ObjectsAndClasses_StaticFinal.src;

public class Screen {
    private final int diagonal;//диагональ
    private final ScreenType screenType;//тип (IPS, TN, VA)
    private final int weight;//вес

    public Screen(int diagonal, ScreenType screenType, int weight) {
        this.diagonal = diagonal;
        this.screenType = screenType;
        this.weight = weight;
    }
    public ScreenType getScreenType() {
        return screenType;
    }

    public int getDiagonal() {
        return diagonal;
    }

    public int getWeight() {
        return weight;
    }
}

