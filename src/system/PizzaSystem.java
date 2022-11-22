package system;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.Timer;

import conteiners.Customer;
import conteiners.Menu;
import conteiners.Order;
import conteiners.Pizza;
import enums.ECookType;
import enums.EnumStatuses;


public class PizzaSystem{
    private static PizzaSystem instance;
    private Integer registersCount;
    public Integer cookCount;
    private Integer pizzaTimeCook = 0;
    private ECookType cookType;
    public Menu menu = new Menu();
    public ArrayList<Customer> customers = new ArrayList<Customer>();
    private Integer pizzaCount;
    public Kitchen kitchen;
    private Integer orderPeriod = 15000;
    private PizzaSystem(ECookType _type, Integer _registersCount, Integer _cookCount, Integer _pizzaCount, Integer _orderPeriod){

        registersCount = _registersCount;
        cookCount = _cookCount;
        cookType = _type;
        pizzaCount = _pizzaCount;
        orderPeriod = _orderPeriod;
        kitchen = new Kitchen(_cookCount, _type);
        menu.pizzaMenu.add(new Pizza(0,"Hawaiian","in_queue").setDefaultPizzaIngridients("Hawaiian"));
        menu.pizzaMenu.add(new Pizza(1,"Margherita","in_queue").setDefaultPizzaIngridients("Margherita"));
        menu.pizzaMenu.add(new Pizza(2,"Pepperoni","in_queue").setDefaultPizzaIngridients("Pepperoni"));
        menu.pizzaMenu.add(new Pizza(3,"4 Seasons","in_queue").setDefaultPizzaIngridients("4 Seasons"));
        menu.pizzaMenu.add(new Pizza(4,"Pickles Pizza","in_queue").setDefaultPizzaIngridients("Pickles Pizza"));
        generateCustomer.start();
        generateOrder();
    }

    public void stopCook(){
        kitchen.stop();
    }

    public void delayCook(Integer time){
        kitchen.delay(time);
    }

    public static PizzaSystem getInstance(ECookType _type, Integer _registersCount, Integer _cookCount, Integer _pizzaCount, Integer _orderiod){
        if(null == instance){
            instance = new PizzaSystem(_type, _registersCount, _cookCount, _pizzaCount,_orderiod);
        }
        return instance;
    }

    public void generateOrder() {
//        while(--registersCount != 0){
            int index = (int)(Math.random() * menu.pizzaMenu.size()-1);
            int index2= (int)(Math.random() * menu.pizzaMenu.size()-1);
            Order order = new Order.OrderBuilder(new ArrayList<Pizza>(Arrays.asList(menu.pizzaMenu.get(index).CopyPizza(),menu.pizzaMenu.get(index).CopyPizza(),menu.pizzaMenu.get(index).CopyPizza(),menu.pizzaMenu.get(index).CopyPizza()))).setStatus(EnumStatuses.in_queue).build();
  
            Customer customer = new Customer(0, order);
            customers.add(customer);
            kitchen.addOrder(order);
//            try {
//                Thread.sleep((int) ((Math.random() * (max - min)) + min));
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
    }
    Timer generateCustomer = new Timer(orderPeriod, e->{		
		generateOrder();
	});
}
