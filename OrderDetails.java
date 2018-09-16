public class OrderDetails {
    // Attributes
    private Product product;
    private int quantity;

    /**
     * Constructor
     * @param product product
     * @param quantity quantity
     */
    public OrderDetails(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * Getter: Product
     * @return product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Setter: Product
     * @param product product
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Getter: Quantity
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Setter: Quanity
     * @param quantity quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Print out this order details
     */
    public void print() {
        // Print quantity of product
        Print.print(this.quantity + " \u00D7 ");

        // Check if instance of Phone
        if (this.product instanceof Phone) {
            // Cast product to phone
            Phone phone = (Phone) product;

            // Print phone model
            Print.print(phone.getModel());
        }

        // Check if instance of TV
        if (this.product instanceof TV) {
            // Cast product to TV
            TV tv = (TV) this.product;

            // Print tv make and size
            Print.print(tv.getMake() + " " + tv.getSize() + " TV");
        }

        // Round off to 2 decimal places
        String roundedPrice = String.format("%.2f", (this.product.getPrice() * this.quantity));

        // Print cost of product cost x quantity
        Print.print(" - cost: \u20AC" + roundedPrice + "\n");
    }
}
