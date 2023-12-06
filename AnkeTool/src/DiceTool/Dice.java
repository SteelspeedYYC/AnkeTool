package DiceTool;
import java.util.Random;
import java.util.ArrayList;
import TextBase.Texts;
/********************************************************************
*# This is class for most general dice instance
*# In each instance, 5 dices with random seeds included
*# History for instance is checkable
*********************************************************************/

public class Dice implements DiceTool{
    private ArrayList<Random> dices;
    private int diceLim;
    private int currentDiceIndex;
    private ArrayList<Long> seedList;

    /*
    Construction for Dice, no arg needed.
     */
    public Dice() {
        this.diceLim = 0;
        this.seedList = new ArrayList<Long>();
        this.dices = new ArrayList<Random>();
        Random seedGenerator = new Random();
        for (int i = 0; i < 5; i++) {
            Long seed = seedGenerator.nextLong();
            this.seedList.add(seed);
            this.dices.add(new Random(seed));
        }
        this.currentDiceIndex = 0;
    }

    //Set a new limit for dice
    public void diceLimSetter(int newLimit) {
        if (newLimit <= 0) {
            throw new IllegalArgumentException("Bound Error Message");  //import textbase for later dev
        }
        else {
            this.diceLim = newLimit;
        }
    }

    //Set a new index for dice should be used (for switching dice)
    public void currentDiceIndexSetter(int newIndex) {
        if (newIndex < 0 || newIndex > 5) {
            throw new IllegalArgumentException("Bound Error Message");  //import textbase for later dev
        }
        else {
            this.currentDiceIndex = newIndex;
        }
    }

    //Get seeds list
    public ArrayList seedsGetter() {
        return this.seedList;
    }

    //Get Dices list
    public ArrayList dicesGetter() {
        return this.dices;
    }

    //Get Dice (obj)
    public Random diceGetter(int i) {
        return this.dices.get(i);
    }

    //Get current limit for dice
    public int diceLimGetter() {
        return this.diceLim;
    }

    @Override
    public int roll() {
        int r = this.diceGetter(this.currentDiceIndex).nextInt() + 1;
        return r;
    }

    @Override
    public int roll(int lim) {
        this.diceLimSetter(lim);
        int r = this.diceGetter(this.currentDiceIndex).nextInt(this.diceLim) + 1;
        return r;
    }

    @Override
    public void showDice() {
        System.out.println("Dices objects address: " + this.dicesGetter());
        System.out.println("Seeds used: " + this.seedsGetter());
        System.out.println("Current dice is dice" + this.currentDiceIndex + ": "
                + this.diceGetter(this.currentDiceIndex));  //import textbase for later dev
    }
}
