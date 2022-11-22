package conteiners;

public class Customer {
    static int IDCounter = 0;
    private int line, id;
    private Order order;
    private String name;
    public Customer(int line, Order order) {
        this.line = line;
        this.id = IDCounter;
        this.order = order;
        this.name = RandomNameGenerator.GetRandomName();
        
        IDCounter += 1;
        Log.AddCustomer(this);
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
