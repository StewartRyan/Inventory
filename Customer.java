import java.util.ArrayList;

public class Customer {
    // Attributes
    private String name;
    private String address;
    private ArrayList<Order> orders;

    /**
     * Constructor
     * @param name customer name
     */
    public Customer(String name) {
        this.name = name;
        this.address = "";
        orders = new ArrayList<>();
    }

    /**
     * Getter: name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * getter: address
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     * Getter: Orders
     * @return
     */
    public ArrayList<Order> getOrders() {
        return orders;
    }

    /**
     * Setter: name
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter: address
     * @param address address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Setter: Orders
     * @param orders Orders
     */
    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    /**
     * Add an order
     * @param order order to be added
     */
    public void addOrder(Order order) {
        // Add Order to orders array list
        this.orders.add(order);
    }
}
