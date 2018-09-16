import java.util.ArrayList;

public class ProductDB {
    // Attributes
    private ArrayList<Product> products;

    /**
     * Product DB constructor
     */
    public ProductDB() {
        this.products = new ArrayList<>();
    }

    /**
     * Add a product to the product database
     * @param product the product we wish to add
     */
    public void add(Product product) {
        // Add product to the array list of products
        this.products.add(product);
    }

    /**
     * Remove an item from the product database
     * @param index the index of the product we wish to remove
     */
    public void remove(int index) {
        // Check if the index given is correct
        if (this.products.size() < index)
            this.products.remove(index);
        else
            System.out.println("Error: There is no product at the specified index.");
    }

    /**
     * Find a product given an ID
     * @param id the ID we will search for
     * @return the product we find
     */
    public Product find(int id) {
        // Iterate through products
        for (Product product : this.products)
            // Check if product id is same as specified id
            if (product.getProductID() == id)
                // Return product with matching id
                return product;

        // Return null if nothing was found
        return null;
    }

    /**
     * Getter: Products
     * @return Products
     */
    public ArrayList<Product> getProducts() {
        return products;
    }

    /**
     * Setter: Products
     * @param products Products
     */
    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}