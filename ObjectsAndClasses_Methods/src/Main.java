package ObjectsAndClasses_Methods.src;

public class Main {

    public static void main(String[] args) {
        Basket vasyaBasket = new Basket();
        vasyaBasket.add("Молоко", 80, 500);
        vasyaBasket.add("Хлеб", 40, 2, 100);
        vasyaBasket.add("Пиво", 67, 4, 450);

        Basket petyaBasket = new Basket(50000);
        petyaBasket.add("Лопата", 280, 600);
        petyaBasket.add("Бочка", 2900, 5000);

        Basket mashaBasket = new Basket();
        mashaBasket.add("Стол", 5000, 10000);

        vasyaBasket.print("Козина васи:");
        petyaBasket.print("Корзина пети:");
        mashaBasket.print("Корзина маши:");
        System.out.println("Общее количество товаров: - " + Basket.getTotalCountProduct());
        System.out.println("Общяя стоимость товаров: - " + Basket.getTotalPriceBasket());
        System.out.println("Средняя стоимость товаров: - " + Basket.getAveragePrice());
        System.out.println("Количество корзин: - " + Basket.getCount());
        System.out.println("Средняя стоимость корзины: - " + Basket.getAverageBasketValue());
    }
}
