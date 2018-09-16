public final class TV extends Product {
    // Attributes
    private String make;
    private int size;
    private String type;
    private boolean is3DCapable;

    /**
     * TV Constructor
     * @param make make
     * @param size size
     * @param type type
     * @param is3DCapable 3D capability
     * @param price price
     */
    public TV(String make, int size, String type, boolean is3DCapable, double price) {
        super("TV", make, price);
        this.make = make;
        this.size = size;
        this.type = type;
        this.is3DCapable = is3DCapable;
    }

    /**
     * Getter: make
     * @return make
     */
    public String getMake() {
        return make;
    }

    /**
     * Getter: size
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * Getter: type
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Getter: is3DCapable
     * @return is3DCapable
     */
    public boolean is3DCapable() {
        return is3DCapable;
    }

    /**
     * Setter: make
     * @param make make
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * Setter: size
     * @param size size
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Setter: Type
     * @param type type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Setter: is3DCapable
     * @param is3DCapable is3DCapable
     */
    public void setIs3DCapable(boolean is3DCapable) {
        this.is3DCapable = is3DCapable;
    }

    /**
     * Overridden toString()
     * @return new toString
     */
    public String toString() {
        return  "Brand: " + this.make + "\n" +
                "Size: " + this.size + "\"\n" +
                "Type: " + this.type + "\n" +
                "3D support: " + (this.is3DCapable ? "Yes":"No");
    }

    /**
     *  Overridden print()
     */
    public void print() {
        super.print();

        System.out.println(this.toString());
    }
 }
