package simulation.data;

/**

 This class contains constants used in the program.
 */
 public class CONSTANTS {
    /**
     * Default constructor.
     */
    public CONSTANTS(){}
 /**

 The target frames per second.
 */
public static final int FPS_TARGET = 15;
/**

 The ANSI escape sequence for resetting the text formatting.
 */
public static final String RESET = "\033[0m";
// Regular Colors
/**

 The ANSI escape sequence for black text.
 */
public static final String BLACK = "\033[0;30m";
/**

 The ANSI escape sequence for red text.
 */
public static final String RED = "\033[0;31m";
/**

 The ANSI escape sequence for green text.
 */
public static final String GREEN = "\033[0;32m";
/**

 The ANSI escape sequence for yellow text.
 */
public static final String YELLOW = "\033[0;33m";
/**

 The ANSI escape sequence for blue text.
 */
public static final String BLUE = "\033[0;34m";
/**

 The ANSI escape sequence for purple text.
 */
public static final String PURPLE = "\033[0;35m";
/**

 The ANSI escape sequence for cyan text.
 */
public static final String CYAN = "\033[0;36m";
/**

 The ANSI escape sequence for white text.
 */
public static final String WHITE = "\033[0;37m";
// Bold
/**

 The ANSI escape sequence for bold black text.
 */
public static final String BLACK_BOLD = "\033[1;30m";
/**

 The ANSI escape sequence for bold red text.
 */
public static final String RED_BOLD = "\033[1;31m";
/**

 The ANSI escape sequence for bold green text.
 */
public static final String GREEN_BOLD = "\033[1;32m";
/**

 The ANSI escape sequence for bold yellow text.
 */
public static final String YELLOW_BOLD = "\033[1;33m";
/**

 The ANSI escape sequence for bold blue text.
 */
public static final String BLUE_BOLD = "\033[1;34m";
/**

 The ANSI escape sequence for bold purple text.
 */
public static final String PURPLE_BOLD = "\033[1;35m";
/**

 The ANSI escape sequence for bold cyan text.
 */
public static final String CYAN_BOLD = "\033[1;36m";
/**

 The ANSI escape sequence for bold white text.
 */
public static final String WHITE_BOLD = "\033[1;37m";
// Underline
/**

 The ANSI escape sequence for underlined black text.
 */
public static final String BLACK_UNDERLINED = "\033[4;30m";
/**

 The ANSI escape sequence for underlined red text.
 */
public static final String RED_UNDERLINED = "\033[4;31m";
/**

 The ANSI escape sequence for underlined green text.
 */
public static final String GREEN_UNDERLINED = "\033[4;32m";
/**

 The ANSI escape sequence for underlined yellow text.
 */
public static final String YELLOW_UNDERLINED = "\033[4;33m";
/**

 The ANSI escape sequence for underlined blue text.
 */
public static final String BLUE_UNDERLINED = "\033[4;34m";
    /**

    The ANSI escape sequence for the color purple with underlining.
    */
    public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
    /**

     The ANSI escape sequence for the color cyan with underlining.
     */
    public static final String CYAN_UNDERLINED = "\033[4;36m"; // CYAN
    /**

     The ANSI escape sequence for the color white with underlining.
     */
    public static final String WHITE_UNDERLINED = "\033[4;37m"; // WHITE
// Background
    /**

     The ANSI escape sequence for black background.
     */
    public static final String BLACK_BACKGROUND = "\033[40m"; // BLACK
    /**

     The ANSI escape sequence for red background.
     */
    public static final String RED_BACKGROUND = "\033[41m"; // RED
    /**

     The ANSI escape sequence for green background.
     */
    public static final String GREEN_BACKGROUND = "\033[42m"; // GREEN
    /**

     The ANSI escape sequence for yellow background.
     */
    public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
    /**

     The ANSI escape sequence for blue background.
     */
    public static final String BLUE_BACKGROUND = "\033[44m"; // BLUE
    /**

     The ANSI escape sequence for purple background.
     */
    public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
    /**

     The ANSI escape sequence for cyan background.
     */
    public static final String CYAN_BACKGROUND = "\033[46m"; // CYAN
    /**

     The ANSI escape sequence for white background.
     */
    public static final String WHITE_BACKGROUND = "\033[47m"; // WHITE
// High Intensity
    /**

     The ANSI escape sequence for bright black text.
     */
    public static final String BLACK_BRIGHT = "\033[0;90m"; // BLACK
    /**

     The ANSI escape sequence for bright red text.
     */
    public static final String RED_BRIGHT = "\033[0;91m"; // RED
    /**

     The ANSI escape sequence for bright green text.
     */
    public static final String GREEN_BRIGHT = "\033[0;92m"; // GREEN
    /**

     The ANSI escape sequence for bright yellow text.
     */
    public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
    /**

     The ANSI escape sequence for bright blue text.
     */
    public static final String BLUE_BRIGHT = "\033[0;94m"; // BLUE
    /**

     The ANSI escape sequence for bright purple text.
     */
    public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
    /**

     The ANSI escape sequence for bright cyan text.
     */
    public static final String CYAN_BRIGHT = "\033[0;96m"; // CYAN
    /**

     The ANSI escape sequence for bright white text.
     */
    public static final String WHITE_BRIGHT = "\033[0;97m"; // WHITE
// Bold High Intensity
    /**

     The ANSI escape sequence for bold bright black text.
     */
    public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
    /**

     The ANSI escape sequence for bold bright red text.
     */
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
    /**

     The ANSI escape sequence for bold bright green text.
     */
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
    /**

     The ANSI escape sequence for bold bright yellow text.
     */
    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
    /**

     The ANSI escape sequence for bold bright blue text.
     */
    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m"; // BLUE
    /**

     The ANSI escape sequence for bold bright purple text.
     */
    public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
    /**

     The ANSI escape sequence for bold bright cyan text.
     */
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m"; // CYAN
    /**

     The ANSI escape sequence for bold bright white text.
     */
    public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE
// High Intensity backgrounds
    /**

     The ANSI escape sequence for bright black background.
     */
    public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
    /**

     The ANSI escape sequence for bright red background.
     */
    public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
    /**

     The ANSI escape sequence for bright green background.
     */
    public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
    /**

     The ANSI escape sequence for bright yellow background.
     */
    public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
    /**

     The ANSI escape sequence for bright blue background.
     */
    public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
    /**

     The ANSI escape sequence for bright purple background.
     */
    public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
    /**

     The ANSI escape sequence for bright cyan background.
     */
    public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m"; // CYAN
    /**

     The ANSI escape sequence for bright white background.
     */
    public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m"; // WHITE


}
