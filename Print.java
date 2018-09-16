public class Print {

    /**
     * Println
     * @param text
     */
    public static void println(String text) {
        System.out.println("\t"+text);
    }

    /**
     * Println without text
     */
    public static void println() {
        System.out.println();
    }

    /**
     * Print
     * @param text
     */
    public static void print(String text) {
        System.out.print(text);
    }

    /**
     * Error message
     * @param text
     */
    public static void error(String text) {
        System.out.println(Colour.red("Error: " + text));
    }

    /**
     * Header/Title
     * @param text
     */
    public static void header(String text) {
        System.out.println("\n" + Colour.green(text + generateSeparator(text), true));
    }

    /**
     * WORKER METHOD: Generates an exact-fit line separator
     * @param text the text we need a separator for
     * @return the separator
     */
    private static String generateSeparator(String text) {
        // Result variable
        String separator = "\n";

        // Add dash ('-') to string for every char in text
        for (int i = 0; i < text.length(); i++)
            separator += '-';

        // Return separator
        return separator;
    }
}
