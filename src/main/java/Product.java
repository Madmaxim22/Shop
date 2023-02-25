public class Product {

    String name;
    int price;
    int rating;
    Type type;

    public Product(Type type, String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "{ " + type + ", "
                + name + ", "
                + price + ", "
                + rating;
    }
}
