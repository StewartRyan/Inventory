import java.util.ArrayList;

/**
 * @author Ryan Stewart
 * @version 1.0
 *
 * This is a final class ListMenu.
 *
 *
 * Non-static features:
 * - Set header
 * - Add menu item
 * - Get total number of items there are in the menu
 * - Run the menu
 */
public final class ListMenu {
    // Attributes
    private String header;
    private ArrayList<String> menuItems;
    private int numberItems;

    /**
     * Constructor
     */
    public ListMenu() {
        this.menuItems = new ArrayList<>();
        this.header = "";
        this.numberItems = 0;
    }

    /**
     * Setter: Header
     * @param header header with separator
     */
    public void setHeader(String header) {
      //  this.header = header + generateSeparator(header);
        this.header = header;
    }

    /**
     * Add menu item to the menu
     * @param menuItem the item we want to add
     */
    public void addItem(String menuItem) {
        this.menuItems.add(menuItem);
        this.numberItems++;
    }

    /**
     * Getter: numberItems
     * @return numberItems
     */
    public int getNumberItems() {
        return numberItems;
    }

    /**
     * Run the menu
     */
    public void print() {
        // Print header
        Print.header(this.header);

        // Print each menu item iteratively
        for (int i = 0; i < this.menuItems.size(); i++)
            Print.println(Colour.green((i+1) + ". ") + this.menuItems.get(i));

        // Print blank line
        Print.println();
    }
}