import java.util.ArrayList;

/**
 * @author Ryan
 * @version 1.0
 */
public class Part3 {
    // Attributes
    private static ProductDB database;
    private static ArrayList<Customer> customers;

    /**
     * Main method
     * @param args args
     */
    public static void main(String[] args) {
        // Instantiate products database
        database  = new ProductDB();
        customers = new ArrayList<>();

        // Run the menu
        menu();
    }





    /****** OPTION 1 - CREATE PRODUCTS *************
     *
     * Start the 'create product' menu
     ***********************************************/
    public static void createProduct() {
        int userChoice = 0;

        while (userChoice != 3) {
            // New List Menu
            ListMenu menu = new ListMenu();

            // Set Menu header
            menu.setHeader("Select a product type");

            // Add items to the menu
            menu.addItem("Phone");
            menu.addItem("Television");
            menu.addItem("Exit");

            // Print the menu
            menu.print();

            // Get the user's input
            userChoice = UserInput.getIntInRange(1, menu.getNumberItems());

            // Switch between whichever option the user chose
            switch (userChoice) {
                // User chose option 1:
                case 1:
                    // Call createPhone()
                    createPhone();
                    break;

                // User chose option 2:
                case 2:
                    // Call createTV()
                    createTV();
                    break;
            }
        }
    }

    /**
     * Start the 'create phone' menu
     */
    public static void createPhone() {
        // Run this block once, then check the while condition
        do {
            // Use static method: printHeader to print nice header
            Print.header("Adding Product: Phone");

            // Get all user input and set them into respective variables
            String inputMake  = UserInput.getInputText("Enter make: ");
            String inputModel = UserInput.getInputText("Enter model: ");
            int inputStorage  = UserInput.getInputInt("Enter storage: ");
            double inputPrice = UserInput.getInputDouble("Enter price: ");

            // New phone instance with newly gathered user input
            Phone phone = new Phone(inputMake, inputModel, inputStorage, inputPrice);

            // Add phone to product database
            database.add(phone);

        // Keep looping until the user types 'exit'
        } while (UserInput.getExitStatus());
    }

    /**
     * Start the 'create TV' menu
     */
    public static void createTV() {
        // Run once then check the while condition
        do {
            // Print a formatted header
            Print.header("Adding Product: Television");

            // Get all user input and set them into respective variables
            String inputMake  = UserInput.getInputText("Enter make: ");
            int inputSize     = UserInput.getInputInt("Enter size (inches): ");
            String inputType  = UserInput.getInputText("Enter type: ");
            boolean input3D   = UserInput.getInputBoolean("Is this TV 3D capable?");
            double inputPrice = UserInput.getInputDouble("Enter price: ");

            // New phone instance with newly gathered user input
            TV tv = new TV(inputMake, inputSize, inputType, input3D, inputPrice);

            // Add phone to product database
            database.add(tv);

        // Keep looping until the user types 'exit'
        } while (UserInput.getExitStatus());
    }





    /****** OPTION 2 - SEARCH BY PRODUCT ID ********
     *
     * Search product database by ID
     ***********************************************/
    public static void searchProducts() {
        // Check if there are currently any products created
        if (database.getProducts().size() == 0) {
            // Print error message
            Print.error("There are currently no products");

            // Return if there are no products
            return;
        }

        // Do once then check while condition
        do {
            // ListMenu
            Print.header("Searching Product by ID");

            // Get all user input
            int inputID  = UserInput.getInputInt("Enter Product ID: ");

            // New phone instance
            Product product = database.find(inputID);

            // Print the details of the product
            printDetailedProduct(product);

            // If no product was found
            if (product == null)
                Print.error("A product was not found for the ID: " + inputID);

            // Keep looping until the user types 'exit'
        } while (UserInput.getExitStatus());
    }


    public static void printDetailedProduct(Product product) {
        // Check if instance of Phone
        if (product instanceof Phone) {
            // Cast product to phone
            Phone phone = (Phone) product;

            // Call phone print
            phone.print();
        }

        // Check if instance of TV
        if (product instanceof TV) {
            // Cast product to TV
            TV tv = (TV) product;

            // Call tv print
            tv.print();
        }
    }





    /****** OPTION 3 - DISPLAY ALL PRODUCTS ********
     *
     * Print out all products' with their details
     ***********************************************/
    public static void displayAllProducts() {
        // Check if there are actually currently any products
        if (database.getProducts().size() == 0) {
            // Print error message and return the function
            Print.error("There are currently no products.");
            return;
        }

        // Iterate through the database
        for (Product product : database.getProducts())
            printDetailedProduct(product);
    }





    /****** OPTION 4 - ORDER PRODUCTS **************
     *
     * Start
     ***********************************************/
    public static void orderProducts() {

        // Check if there are currently any products created
        if (database.getProducts().size() == 0) {
            // Print error message
            Print.error("There are currently no products to order");

            // Return if there are no orders
            return;
        }

        // Print header
        Print.header("Ordering Product");

        // Customer address variable
        String inputCustomerAddr = "";

        // Get customer name
        String inputCustomerName = UserInput.getInputText("Enter customer name: ");

        // If customer already exists, don't ask for address again
        if (!customerExists(inputCustomerName))
            inputCustomerAddr = UserInput.getInputText("Enter address: ");


        // Get customer object if one exists, if not, create a new one
        Customer customer = getCustomerForName(inputCustomerName);

        // Set the address of the customer
        customer.setAddress(inputCustomerAddr);

        // Add the order for a given customer
        addOrderForCustomer(customer);
    }

    /**
     * Ask user for a valid product ID
     * @return Product with matching ID
     */
    public static Product getValidProductID() {
        // Get a valid product ID from the customer
        do {
            // Get a product ID from the user
            int inputProductID = UserInput.getInputInt("Enter product ID: ");

            // Set product equal to the result of the find function
            Product product = database.find(inputProductID);

            // Print an error if there was no product found
            if (product == null)
                Print.error("No product found for the ID: " + inputProductID);
            else
                return product;

        // Keep iterating until a valid product ID is returned
        } while (true);
    }

    /**
     * Search for customer by given name
     * @param name Customer name the user entered
     * @return Either new Customer or existing one
     */
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

    /**
     * Add an order to a Customer instance
     * @param customer the Customer we want to add the order to
     */
    public static void addOrderForCustomer(Customer customer) {
        // New Order
        Order order = new Order();

        // Execute once, then check the while condition
        do {
            // Ask for valid product ID
            Product product = getValidProductID();

            // Get the quantity
            int inputQuantity = UserInput.getInputInt("Enter quantity: ");

            // Add the product and quantity to order
            order.add(product, inputQuantity);

            // Print order summary after every product ordered
            Print.println(Colour.cyan("=> You ordered: " + inputQuantity + " \u00D7 " + product.getDescription()));
        // Check if user wants to exit
        } while (UserInput.getExitStatus());

        // Add order to customer
        customer.addOrder(order);
    }





    /****** OPTION 5 - DISPLAY ORDERS FOR CUSTOMER *
     *
     * Display order(s), if any, for a given Customer
     ***********************************************/
    public static void displayOrdersForCustomer() {
        // Check if there are currently any products created
        if (customers.size() == 0) {
            // Print error message
            Print.error("There are currently no customers");

            // Return if there are no customers
            return;
        }

        // Print header
        Print.header("Ordering Product");

        // Declare boolean for whether customer exists
        boolean customerExists;

        // Run once then check while condition
        do {
            // Run once then check while condition
            do {
                // Get customer name
                String inputCustomerName = UserInput.getInputText("Enter customer name: ");

                // Check if customer exists
                customerExists = customerExists(inputCustomerName);

                // If customer exists print order details for that customer name
                if (customerExists)
                    printOrdersForCustomer(getCustomerForName(inputCustomerName));
                else
                    // Print error message
                    Print.error("The customer " + inputCustomerName + " does not exist.");
            // Keep going until a valid customer is found
            } while (!customerExists);
        // Check if user wants to exit
        } while (UserInput.getExitStatus());
    }

    /**
     * Check if a customer exists by a given name
     * @param name Customer name we are checking for
     * @return true if customer exists, false if not
     */
    public static boolean customerExists(String name) {
        // Iterate through all existing customers
        for (Customer customer : customers)
            // Check if current customer is equal to user input customer
            if (customer.getName().equalsIgnoreCase(name))
                // Return true if a match is found
                return true;

        // Return false if the customer was not found
        return false;
    }

    /**
     * Print out the orders for a customer
     * @param customer The customer we are displaying the orders for
     */
    public static void printOrdersForCustomer(Customer customer) {
        // Check if customer has any orders
        if (customer.getOrders().size() > 0) {
            // Print header for orders
            Print.header("Orders for " + customer.getName());

            // Order number variable
            int orderNum = 1;

            // Print details of each order
            for (Order order : customer.getOrders()) {
                // Print order header
                Print.header("Order #" + orderNum);

                // Print order
                order.printProductsInOrder();

                // Increase order number count
                orderNum++;
            }
        } else
            // Print error message
            Print.error("This customer hasn't got any orders, yet.");
    }





    /****** START MENU ******************************
     *
     * Run the user menu
     ************************************************/
    public static void menu() {
        // New List Menu
        ListMenu menu = new ListMenu();

        // Set menu header
        menu.setHeader("Inventory / Shopping Application");

        // Add items to menu
        menu.addItem("Create a product");
        menu.addItem("Search for a product by its ID");
        menu.addItem("Display all products");
        menu.addItem("Order products");
        menu.addItem("Display orders for customer");
        menu.addItem("Quit");

        // Integer for user option choice
        int userChoice = 0;

        // Keeps displaying the menu until the user exits
        while (userChoice != menu.getNumberItems()) {
            // Print menu
            menu.print();

            // Get the user's chosen option number within menu range
            userChoice = UserInput.getIntInRange(1, menu.getNumberItems());

            // Execute method related to chosen option
            chosenOption(userChoice);

            // Print a blank line every time an option has finished
            System.out.println();
        }
    }

    /**
     * Based on a user's input, decide which option to run
     */
    public static void chosenOption(int userChoice) {
        // Switch between menu options
        switch (userChoice) {
            // 1 - User chose to create a product
            case 1:
                createProduct();
                break;
            // 2 - User chose to search for a product by its ID
            case 2:
                searchProducts();
                break;
            // 3 - User chose to display all products which have been created
            case 3:
                displayAllProducts();
                break;
            // 4 - User chose to order product(s) for a customer
            case 4:
                orderProducts();
                break;
            // 5 - User chose to display all orders for a given customer
            case 5:
                displayOrdersForCustomer();
                break;
            // 6 - User chose to exit the application
            case 6:
                // 6.1 - Print bye message
                Print.println(Colour.cyan("Goodbye.", true));
                break;
        }
    }
}