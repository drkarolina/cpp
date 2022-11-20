package conteiners;

import java.util.ArrayList;

public class Register {
    private ArrayList<Order> ordersList;

    public Register(ArrayList<Order> ordersList){
        this.ordersList=ordersList;
    }

    public ArrayList<Order> GetOrdersList(){
        return ordersList;
    }

    public void AddOrderToList(Order order){
        ordersList.add(order);
    }
}
