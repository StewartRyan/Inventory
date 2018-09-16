import java.util.ArrayList;

import static org.junit.Assert.*;

public class ProductDBTest {

    @org.junit.Test
    public void find() throws Exception {
        // Create a product database
        ProductDB database = new ProductDB();

        // Create some new phone products
        Phone iPhone = new Phone("Apple", "iPhone X", 256, 999);
        Phone galaxy = new Phone("Samsung", "Galaxy S8+", 128, 679);
        Phone OnePlus = new Phone("OnePlus", "OnePlus 5T", 64, 499);

        // Add the iPhone to the product database
        database.add(iPhone);  // ID: 1
        database.add(galaxy);  // ID: 2
        database.add(OnePlus); // ID: 3

        // Find product with user input ID
        Product searchedProduct = database.find(29);

        // Assert if the searched ID is equal to the expected iPhone product
        assertEquals(galaxy, searchedProduct);
    }

    private static  ArrayList<Customer> customers;
    @org.junit.Test
    public void customerExists() throws Exception {
        // Customers array list
        customers = new ArrayList<>();

        // Create some customers
        Customer ryan = new Customer("Ryan");
        Customer john = new Customer("John");

        // Add customers to the array list
        customers.add(ryan);
        customers.add(john);

        // Search for name
        Customer ryanSearch = getCustomerForName("ryan");

        // Check if the search for customer was found
        assertEquals(ryan, ryanSearch);

    }

    // Method for getting customer for name
    public static Customer getCustomerForName(String name) {
        // Iterate through all customers
        for (Customer customer : customers)
            // If customer name from input matches that of one in the array list
            if (customer.getName().equalsIgnoreCase(name))
                // Return the customer found
                return customer;

        // A customer was not found, so create a new one
        Customer customer = new Customer(name);

        // Add the customer to the array list
        customers.add(customer);

        // Return the newly created customer
        return customer;
    }
}