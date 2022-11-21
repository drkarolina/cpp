package conteiners;

import java.util.ArrayList;

import enums.EnumStatuses;

public class Order {

    //required parameters
    private int id;
    private ArrayList<Pizza> pizzasList;

    //optional parameters
    private EnumStatuses status;

    public int GetId() {
        return id;
    }

    public ArrayList<Pizza> GetPizzasList() {
        return pizzasList;
    }

    public EnumStatuses GetStatus() {
        return status;
    }

    public void SetStatus(EnumStatuses status){ this.status=status;}

    private Order(OrderBuilder builder) {
        this.id=builder.id;
        this.pizzasList=builder.pizzasList;
        this.status=builder.status;
    }

    //Builder Class
    public static class OrderBuilder{
        private static int IDCounter = 0;

        //required parameters
        private int id;
        private ArrayList<Pizza> pizzasList;

        //optional parameters
        private EnumStatuses status;

        public OrderBuilder(ArrayList<Pizza> pizzasList){
            this.id=IDCounter;
            this.pizzasList=pizzasList;

            IDCounter += 1;
        }

        public OrderBuilder setStatus(EnumStatuses status) {
            this.status = status;
            return this;
        }

        public Order build(){
            return new Order(this);
        }

    }
}
