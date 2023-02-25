import java.util.HashMap;
import java.util.Map;

public class Basket implements Store {

    static Map<Product, Integer> productsBasket;
    double sum;

    public Basket() {
        productsBasket = new HashMap<>();
    }

    @Override
    public void addProduct(Product product, int count) {
        if (productsBasket.containsKey(product)) {
            productsBasket.put(product, productsBasket.get(product) + count);
        } else {
            productsBasket.put(product, count);
        }
        sum += product.price * count;
    }

    @Override
    public void deleteProduct(String name, int count) {
        Product product = searchProductBasket(name);
        if (productsBasket.containsKey(product)) {
            productsBasket.put(product, productsBasket.get(product) - count);
        }
        sum -= product.price * count;
    }

    private Product searchProductBasket(String name) {
        return productsBasket.keySet().stream()
                .filter(p -> p.name.equals(name))
                .findFirst()
                .orElse(null);
    }

    void productBasket() {
        System.out.println("Список товаров в козине:");
        System.out.printf("%-1.10s %-20.19s %-10.10s %-10.10s%n", "", "Наименование товара", "Количество", "Цена/за.ед");
        int i = 1;
        for (Map.Entry<Product, Integer> product : productsBasket.entrySet()) {
            System.out.printf("%-1.10s %-20.10s %-10.10s %-10.10s%n",
                    (i++) + ".", product.getKey().name, product.getValue(), product.getKey().price + " руб/шт");
        }
        System.out.printf("%-20.10s %-10.10s %-10.10s %-10.2f%n", "", "", "Итого: ", sum);
    }
}
