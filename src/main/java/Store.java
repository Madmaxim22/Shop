public interface Store {

    void addProduct(Product product, int count);

    void deleteProduct(String name, int count);
}
