# Shop

### Магические числа
В классе Shop создана переменная shopSize которая определяет место в магазине для каждого товара.

### Принцип единой ответственности  
В магазине созданы классы:
Shop - основной класс магазина  
Send - класс реализующий отправку сообщений с чеком покупки.
Каждый класс логически делает только то для чего он предназначен.

### Принцип открытости / закрытости 
Если создать наследника от класса Shop и добавить ему дополнительные методы.  
Например:  
1. Заказ товара которого на данный момент нет на складе;
2. Сортировка товаров по типу(по алфавиту, по стоимости);

### Принцип замены Барбары Лисков  
В магазине есть два класса:
Shop и Basket хоть они реализуют два общих метода add и delete, 
они не имеют логической связи как наследники.  
Уместно было бы создание наследовать от класса Shop, класс FruitStore или VegetableStore;

### Принцип сегрегации (разделения) интерфейса
В магазине реализованы два интерфейса store и send.  
Первый интерфейс логически отделен от второго. Вместо создания одного большого интерфейса создали два логически разных интерфейса.
Зачем корзине отправлять сообщения?

### Принцип инверсии зависимостей
В классе Shop я не завишу от конкретного типа товара.  
Мне все равно будет там храниться овощи или сноуборд для продажи.  
Например: 
Я могу создать класс WinterClothingStore имплементировать интерфейс Store и создавать объекты магазинов через:  
Store shop = new Shop;  
Store winterClothingStore = new WinterClothingStore;
