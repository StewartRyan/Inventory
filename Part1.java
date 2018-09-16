public class Part1 {
    public static void main(String[] args) {
        // PRODUCT DATABASE INSTANCE
        ProductDB database = new ProductDB();

        /**
         * CREATE A FEW PRODUCTS
         */
        Print.header("PART 1: CREATE A FEW PRODUCTS");

        // Create some products
        Phone p  = new Phone("Apple", "iPhone X", 256, 999.99);
        Phone p1 = new Phone("Samsung", "Galaxy S8", 128, 649.99);
        TV    t  = new TV("LG", 55, "LED", true, 2000);
        TV    t1 = new TV("Sony", 60, "OLED", false, 2999);

        // Add these products to the database
        database.add(p);
        database.add(p1);
        database.add(t);
        database.add(t1);

        /**
         * SEARCH FOR PRODUCT BY PRODUCT ID
         */
        Print.header("PART 2: SEARCH FOR PRODUCT BY PRODUCT ID");

        // Find a product with the ID '2'
        Product productByID = database.find(1);

        // Try to print product info
        try {
            productByID.print();
        } catch (Exception e) {
            System.out.println("Oops. There was no product found for that ID");
        }


        /**
         * LIST ALL PRODUCTS
         */
        Print.header("PART 3: LIST ALL AVAILABLE PRODUCTS");

        // Print all the products in the database
        for (int i = 0; i < database.getProducts().size(); i++) {
            // Create product for each iteration
            Product product = database.getProducts().get(i);

            // Print detailed product description
            Part3.printDetailedProduct(product);
        }


        /**
         * ORDER PRODUCTS
         */
        Print.header("PART 4: ORDER PRODUCTS FOR A NAMED CUSTOMER");

        // Create a new customer called mary
        Customer Mary = new Customer("Mary");

        // CREATE A NEW ORDER
        Order o1 = new Order();

        // ADD PRODUCTS TO THE NEW ORDER
        o1.add(p,12); // ordered 12 iphone 6 products
        o1.add(p1,1); //ordered 1 Galaxy 8

        // CREATE A NEW ORDER
        Order o2 = new Order();

        // ADD PRODUCTS TO THE NEW ORDER
        o2.add(p1,6); //ordered 1 Galaxy 8
        o2.add(t, 13); // ordered 45 LG products

        // ADD ORDER TO MARY THE CUSTOMER
        Mary.addOrder(o1);
        Mary.addOrder(o2);

        /**
         *  DISPLAY ALL OF MARY'S ORDERS
         */
        Print.header("PART 5: DISPLAY ALL ORDERS FOR NAMED CUSTOMER");

        // PRINT ORDERS FOR MARY
        Part3.printOrdersForCustomer(Mary);
    }

}
