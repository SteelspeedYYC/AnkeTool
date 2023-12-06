package DiceTool;

/**
 * This is the interface for all type of dice tools
 * Child must include rolling, # of dice display, and history display
 */

public interface DiceTool {
    /*
    Roll the dice (testing with no bound), and give result
     */
    public int roll();
    /*
    Roll the dice with a given limit, and give result
     */
    public int roll(int lim);
    /*
    Show the dice information
     */
    public void showDice();

}
