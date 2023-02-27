package ObjectsAndClasses_Methods.src;

public class Basket {

    private static int count = 0;
    private String items = "";
    private int totalPrice = 0;
    private int limit;
    private double totalWeight = 0;
    private static int totalCountProduct = 0;
    private static int totalPriceBasket = 0;
    public Basket() {
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice, double totalWeight) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
        this.totalWeight = totalWeight;


    }

    public static int getCount() {
        return count;
    }

    public static void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }

    public void add(String name, int price, double weight) {
        add(name, price, 1, weight);
    }

    public void add(String name, int price, int count ,double weight) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " - " +
                count + " шт. - " + count * price + " rub. - вес: " + count * weight + " gramm";
        totalPrice = totalPrice + count * price;
        totalWeight = totalWeight + count * weight;
        totalCountProduct = totalCountProduct + count;
        totalPriceBasket = totalPriceBasket + price * count;

    }

    public void clear() {
        items = "";
        totalPrice = 0;
        totalWeight = 0;
        totalCountProduct = 0;
        totalPriceBasket = 0;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
    public double getTotalWeight() {
        return totalWeight;
    }
    public boolean contains(String name) {
        return items.contains(name);
    }
    public static double getAveragePrice() {
        return (double) totalPriceBasket / totalCountProduct;
    }
    public static double getAverageBasketValue() {
        return (double) totalPriceBasket / count;
    }
    public static int getTotalCountProduct() {
        return totalCountProduct;
    }
    public static int getTotalPriceBasket() {
        return totalPriceBasket;
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
            System.out.println("Общая стоимость товаров: - " + getTotalPrice() + " rub.");
            System.out.println("Общий вес товаров: - " + getTotalWeight() + " gramm.");
            System.out.println();
        }
    }
}