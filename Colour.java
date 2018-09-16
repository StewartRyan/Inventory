public final class Colour {
    // Turn colours on or off (true is on)
    private static final boolean status = true;

    // All ANSI colour codes
    private static final String RESET = "\u001B[0m";
    private static final String BLACK = "\u001B[30m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";
    private static final String WHITE = "\u001B[37m";

    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
    public static final String WHITE_BOLD = "\033[1;37m";  // WHITE


    // COLOURS
    public static String black(String text) {
        return status ? BLACK + text + RESET : text;
    }

    public static String red(String text) {
        return status ? RED + text + RESET : text;
    }

    public static String green(String text) {
        return status ? GREEN + text + RESET : text;
    }

    public static String yellow(String text) {
        return status ? YELLOW + text + RESET : text;
    }

    public static String blue(String text) {
        return status ? BLUE + text + RESET : text;
    }

    public static String purple(String text) {
        return status ? PURPLE + text + RESET : text;
    }

    public static String cyan(String text) {
        return status ? CYAN + text + RESET : text;
    }

    public static String white(String text) {
        return status ? WHITE + text + RESET : text;
    }


    // BOLD COLOURS
    public static String black(String text, boolean bold) {
        return status ? BLACK_BOLD + text + RESET : text;
    }

    public static String red(String text, boolean bold) {
        return status ? RED_BOLD + text + RESET : text;
    }

    public static String green(String text, boolean bold) {
        return status ? GREEN_BOLD + text + RESET : text;
    }

    public static String yellow(String text, boolean bold) {
        return status ? YELLOW_BOLD + text + RESET : text;
    }

    public static String blue(String text, boolean bold) {
        return status ? BLUE_BOLD + text + RESET : text;
    }

    public static String purple(String text, boolean bold) {
        return status ? PURPLE_BOLD + text + RESET : text;
    }

    public static String cyan(String text, boolean bold) {
        return status ? CYAN_BOLD + text + RESET : text;
    }

    public static String white(String text, boolean bold) {
        return status ? WHITE_BOLD + text + RESET : text;
    }


}
