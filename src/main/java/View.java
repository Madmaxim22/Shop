import java.util.Scanner;

public class View {

    Shop shop;
    Send send;
    Scanner scanner = new Scanner(System.in);

    public View(Shop shop, Send send) {
        this.shop = shop;
        this.send = send;
    }

    void command() {
        System.out.println("Введите имя пользователя:");
        String userName = scanner.nextLine();
        System.out.println("Введите электронную почту:");
        String userEmail = scanner.nextLine();
        while (true) {
            System.out.println("Введите команду:\n" +
                    "/list - для вывода ассортимента магазина;\n" +
                    "/basket - для вывода товаров в корзине;");
            String input = scanner.nextLine();
            switch (input) {
                case "/list":
                    shop.productShop();
                    System.out.println("Введите название и количество которое хотите добавить в корзину." +
                            " \nДля выхода в главное меню введите /exit.");
                    while (true) {
                        String string = scanner.nextLine();
                        String[] parts = string.split(" ");
                        if (parts[0].equals("/exit")) break;
                        String nameProduct = parts[0];
                        int productCount = Integer.parseInt(parts[1]);
                        if (shop.addProductBasket(nameProduct, productCount)) {
                            System.out.println(nameProduct + " - успешно добавлено в корзину!");
                        } else {
                            System.out.println(nameProduct + " - нет такого товара!");
                        }
                    }
                    break;
                case "/basket":
                    shop.basket.productBasket();
                    System.out.println("Для оплаты введите /payment" +
                            "\nВведите название и количество которое хотите убрать из корзины." +
                            " \nДля выхода в главное меню введите /exit.");
                    while (true) {
                        String string = scanner.nextLine();
                        String[] parts = string.split(" ");
                        if (parts[0].equals("/exit")) break;
                        if (parts[0].equals("/payment")) {
                            System.out.println("Оплата прошла успешно!");
                            send.send(userName, userEmail, "");
                            return;
                        }
                        String nameProduct = parts[0];
                        int productCount = Integer.parseInt(parts[1]);
                        if (shop.deleteProductBasket(nameProduct, productCount)) {
                            System.out.println(nameProduct + " - " + productCount + " шт. удалены из корзины!");
                        } else {
                            System.out.println(nameProduct + " - нет такого товара!");
                        }
                    }
                    break;
                default:
                    System.out.println("Нет такой команды");
                    break;
            }
        }
    }
}
