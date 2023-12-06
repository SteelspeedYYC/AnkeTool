package DiceTool;

public class test {
    public static void main(String[] args) {
        Dice testdice = new Dice();
        System.out.println("1D6 = " + testdice.roll(6));
        //testdice.showDice();
        for (int i = 1; i < 20; i++) {
            System.out.println("1D" + i + " = " + testdice.roll(i));
        }
    }
}
