/**
 * Phone -> extends -> Product
 */
public final class Phone extends Product {
    private String make;
    private String model;
    private int storage;

    /**
     * Phone constructor
     * @param make Phone make
     * @param model Phone model
     * @param storage Phone storage in GBs
     * @param price Phone price in €
     */
    public Phone(String make, String model, int storage, double price) {
        super("Phone", model, price);
        this.make    = make;
        this.model   = model;
        this.storage = storage;
    }

    /**
     * Getter: Make
     * @return make
     */
    public String getMake() {
        return make;
    }

    /**
     * Getter: Model
     * @return model
     */
    public String getModel() {
        return model;
    }

    /**
     * Getter: Storage
     * @return storage
     */
    public int getStorage() {
        return storage;
    }

    /**
     * Setter: Make
     * @param make make
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * Setter: Model
     * @param model model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Setter: Storage
     * @param storage storage
     */
    public void setStorage(int storage) {
        this.storage = storage;
    }

    /**
     * Overridden toString()
     * @return
     */
    public String toString() {
        return "Brand: " + this.make + "\n" +
                "Model: " + this.model + "\n" +
                "Storage: " + this.storage + "GB";
    }

    /**
     * Overridden print()
     */
    public void print() {
        super.print();

        System.out.println(this.toString());
    }
}
