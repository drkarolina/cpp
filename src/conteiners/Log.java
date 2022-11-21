package conteiners;

import java.util.*;

public class Log {
    private static HashMap<Pizza, TimeStamp> pizzaTimes = new HashMap<>();
    private static HashMap<Order, TimeStamp> orderTimes = new HashMap<>();
    private static ArrayList<Customer> customers = new ArrayList<>();
    public static HashMap<Pizza, TimeStamp> GetPizzaTimes() {
        return pizzaTimes;
    }
    public static ArrayList<Customer> GetCustommers() {
        return customers;
    }
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
    public static void StopPizza(Pizza pizza){
        pizzaTimes.put(pizza, pizzaTimes.get(pizza).Stop());
    }
    public static void StopOrder(Order order){
        orderTimes.put(order, orderTimes.get(order).Stop());
    }
    public static void AddCustomer(Customer customer){
        customers.add(customer);
    }
}
