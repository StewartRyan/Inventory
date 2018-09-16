import java.util.ArrayList;

public class Order {
    // Attributes
    private ArrayList<OrderDetails> orderDetails;
    private double orderCost;

    /**
     * Order constructor
     */
    public Order() {
        this.orderDetails = new ArrayList<>();
        orderCost = 0;
    }

    /**
     * Add order to array list of orders
     * @param product product we want to add
     * @param quantity quantity
     */
    public void add(Product product, int quantity) {
        // Instantiate a new object of orderDetails
        OrderDetails orderDetail = new OrderDetails(product, quantity);

        // Incrementally increase the total cost of the order
        this.orderCost += product.getPrice() * quantity;

        // Add orderDetail to our array list
        this.orderDetails.add(orderDetail);
    }

    /**
     * Getter: order details
     * @return order details
     */
    public ArrayList<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    /**
     * order details
     * @param orderDetails order details
     */
    public void setOrderDetails(ArrayList<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    /**
     * Print this order iteratively
     */
    public void printProductsInOrder() {
        // Iterate through all products in this order
        for (OrderDetails orderDetail : this.orderDetails)
            // Print order details
            orderDetail.print();

        // Print total order cost
        Print.println(Colour.blue("Total cost: \u20AC" + this.orderCost, true));
    }
}
