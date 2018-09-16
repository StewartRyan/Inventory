abstract public class Product {
    // Counter for setting unique ID to each product
    private static int counter = 0;

    // Attributes
    private String name;
    private String description;
    private double price;
    private int productID;


    /**
     * Product constructor
     * @param name Product name
     * @param description Product description
     * @param price Product price
     */
    public Product(String name, String description, double price) {
        this.name        = name;
        this.description = description;
        this.price       = price;
        this.productID   = ++counter;
    }

    /**
     * Getter: Name
     * @return Name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter: description
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Getter: price
     * @return productID
     */
    public double getPrice() {
        return price;
    }

    /**
     * Getter: productID
     * @return productID
     */
    public int getProductID() {
        return productID;
    }


    /**
     * Setter: name
     * @param name new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter: description
     * @param description new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Setter: price
     * @param price new price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Setter: productID
     * @param productID new productID
     */
    public void setProductID(int productID) {
        this.productID = productID;
    }


    /**
     * Overridden print() for printing generic product data
     */
    public void print() {
        Print.header("ID: " + this.productID  + " - Product: " + this.name);
        System.out.println("Price: \u20AC" + this.price);
    }
}