package conteiners;

import java.util.*;

public class Log {
    private static HashMap<Pizza, TimeStamp> pizzaTimes = new HashMap<>();
    // ми домовилися, що в нас буде менюб тому це поле нема сенсу тримати, але якщо треба буде, то розкометуйте все що нижче
    // private static List<Pizza> pizzaNamesList = new ArrayList<>();
    private static HashMap<Order, TimeStamp> orderTimes = new HashMap<>();
    public static HashMap<Pizza, TimeStamp> GetPizzaTimes() {
        return pizzaTimes;
    }
    // public static List<Pizza> GetPizzaNamesList() {
    //     return pizzaNamesList;
    // }
    public static HashMap<Order, TimeStamp> GetOrderTimes() {
        return orderTimes;
    }
    public static void AddOrder(Order order){
        TimeStamp orderTime = new TimeStamp();
        orderTimes.put(order, orderTime);
        order.GetPizzasList().forEach(pizza -> {
            AddPizza(pizza);
        });
    }
    private static void AddPizza(Pizza pizza){
        TimeStamp pizzaTime = new TimeStamp();
        pizzaTimes.put(pizza, pizzaTime);
    }
    // public static void AddPizzaToList(Pizza pizza){
    //     pizzaNamesList.add(pizza);
    // }
    public static void StopPizza(Pizza pizza){
        pizzaTimes.put(pizza, pizzaTimes.get(pizza).Stop());
    }
    public static void StopOrder(Order order){
        orderTimes.put(order, orderTimes.get(order).Stop());
    }
}
