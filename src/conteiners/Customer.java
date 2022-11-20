package conteiners;

public class Customer {
    private int line, id;
    private Order order;
    public Customer(int line, int id, Order order) {
        this.line = line;
        this.id = id;
        this.order = order;
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
}
