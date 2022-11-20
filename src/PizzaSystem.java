
import conteiners.Menu;
import conteiners.Order;
import conteiners.Pizza;
import enums.ECookType;
import enums.EnumStatuses;


public class PizzaSystem{
    private static PizzaSystem instance;
    private Integer registersCount;
    private Integer cookCount;
    private Integer pizzaTimeCook = 0;
    private ECookType cookType;
    public Menu menu = new Menu();
    private Integer pizzaCount;
    private Kitchen kitchen;

    private PizzaSystem(ECookType _type, Integer _registersCount, Integer _cookCount, Integer _pizzaCount){
        registersCount = _registersCount;
        cookCount = _cookCount;
        cookType = _type;
        pizzaCount = _pizzaCount;
        kitchen = new Kitchen(_cookCount, _type);
        menu.pizzaMenu.add(new Pizza(1,"Hawaiian","in_queue").setDefaultPizzaIngridients("Hawaiian"));
        menu.pizzaMenu.add(new Pizza(1,"Margherita","in_queue").setDefaultPizzaIngridients("Margherita"));
        menu.pizzaMenu.add(new Pizza(1,"Pepperoni","in_queue").setDefaultPizzaIngridients("Pepperoni"));
        menu.pizzaMenu.add(new Pizza(1,"4 Seasons","in_queue").setDefaultPizzaIngridients("4 Seasons"));
        menu.pizzaMenu.add(new Pizza(1,"Pickles Pizza","in_queue").setDefaultPizzaIngridients("Pickles Pizza"));
    }

    public void stopCook(){
        kitchen.stop();
    }

    public void delayCook(Integer time){
        kitchen.delay(time);
    }

    public static PizzaSystem getInstance(ECookType _type, Integer _registersCount, Integer _cookCount, Integer _pizzaCount){
        if(null == instance){
            instance = new PizzaSystem(_type, _registersCount, _cookCount, _pizzaCount);
        }
        return instance;
    }
    public void generateOrder() {
        int i=0;
//        while(--registersCount != 0){
            i++;
            Order order = new Order.OrderBuilder(i, menu.pizzaMenu).setStatus(EnumStatuses.in_queue).build();
            kitchen.addOrder(order);
//            try {
//                Thread.sleep((int) ((Math.random() * (max - min)) + min));
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
    }
}
