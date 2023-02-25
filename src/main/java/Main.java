public class Main {

    public static void main(String[] args) {

        Shop shop = new Shop();
        shop.addProduct(new Product(Type.FRUIT, "Яблоко", 100), 100);
        shop.addProduct(new Product(Type.FRUIT, "Банан", 70), 100);
        shop.addProduct(new Product(Type.VEGETABLES, "Огурец", 40), 100);
        shop.addProduct(new Product(Type.VEGETABLES, "Помидор", 80), 100);
        shop.addProduct(new Product(Type.MILK_PRODUCTS, "Молоко", 89), 100);
        shop.addProduct(new Product(Type.MILK_PRODUCTS, "Мороженное", 110), 100);
        shop.addProduct(new Product(Type.ALCOHOL, "Бренди", 1100), 100);

        Send send = new SendMessage();
        View view = new View(shop, send);

        view.command();
    }
}
