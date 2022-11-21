package conteiners;

public class Customer {
    private int line, id;
    private Order order;
    private String name;
    public Customer(int line, int id, Order order, String name) {
        this.line = line;
        this.id = id;
        this.order = order;
        this.name = name;
        Log.AddOrder(order);
    }
    public int GetLine() {
        return line;
    }
    public int GetId() {
        return id;
    }
    public Order GetOrder() {
        return order;
    }
    public String GetName() {
        return name;
    }
}
