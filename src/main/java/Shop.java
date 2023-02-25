import java.util.HashMap;
import java.util.Map;

public class Shop implements Store {

    final Map<Product, Integer> productsShop;
    final Basket basket;
    private final int shopSize = 100;

    public Shop() {
        basket = new Basket();
        productsShop = new HashMap<>();
    }

    @Override
    public void addProduct(Product product, int count) {
        if (productsShop.containsKey(product)) {
            if (productsShop.get(product) > shopSize) {
                System.out.println("Магазин заполнен!");
            }
            productsShop.put(product, productsShop.get(product) + count);
        } else {
            productsShop.put(product, count);
        }
    }

    @Override
    public void deleteProduct(String name, int count) {
        Product product = searchProductShop(name);
        if (productsShop.containsKey(product)) {
            productsShop.put(product, productsShop.get(product) - count);
        }
    }

    boolean addProductBasket(String name, int count) {
        Product product = searchProductShop(name);
        basket.addProduct(product, count);
        deleteProduct(name, count);
        return true;
    }

    boolean deleteProductBasket(String name, int count) {
        Product product = searchProductShop(name);
        basket.deleteProduct(name, count);
        addProduct(product, count);
        return true;
    }

    private Product searchProductShop(String name) {
        return productsShop.keySet().stream()
                .filter(p -> p.name.equals(name))
                .findFirst()
                .orElse(null);
    }

    void productShop() {
        System.out.println("Список товаров в Магазине:");
        System.out.printf("%-1.10s %-20.19s %-10.10s %-10.10s%n", " ", "Наименование товара", "Количество", "Цена/за.ед");
        int i = 1;
        for (Map.Entry<Product, Integer> product : productsShop.entrySet()) {
            System.out.printf("%-1.10s %-20.10s %-10.10s %-10.10s%n",
                    (i++) + ".", product.getKey().name, product.getValue(), product.getKey().price + " руб/шт");
        }
    }
}
