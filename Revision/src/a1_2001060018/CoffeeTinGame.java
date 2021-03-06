package src.a1_2001060018;

import java.util.Arrays;

public class CoffeeTinGame {
    // constant value for green bean
    private static final char GREEN = 'G';
    // constant value for blue bean
    private static final char BLUE = 'B';
    // constant for removed beans
    private static final char REMOVED = '-';

    /**
     * the main procedure
     */
    public static void main(String[] args) {
        // initialize somme beans
        char[] beans = { GREEN, BLUE, BLUE, GREEN, GREEN };

        // count number of greens
        int greens = 0;
        for (char b : beans) {
            if (b == GREEN) {
                greens++;
            }
        }
        // the expected last bean
        final char last = (greens % 2 == 1) ? GREEN : BLUE;
        // p0 = green parity /\
        // (p0 = 1 -> last=GREEN) /\ (p0 = 0 -> last = BLUE)

        // print the content of tin before the game
        System.out.printf("Tin before : %s %n", Arrays.toString(beans));

        // perform the game
        char lastBean = tinGame(beans);
        // lastBean = last \/ lastBean != last

        // print the content of tin and last bean
        System.out.printf("Tin after : %s %n", Arrays.toString(beans));

        // check if last bean as expected and print
        if (lastBean == last) {
            System.out.printf("Last bean: %c", lastBean);
        } else {
            System.out.printf("Oops, wrong last bean: %c (expected: %c) %n", lastBean, last);
        }
    }

    /**
     * Takes out any two beans randomly
     * 
     * @requirement: tin is not null /\ tin.length > 0
     * @modifies tin
     * @effects: repeatedly remove two beans from tin
     *           create an array to store two beans
     *           that are taken out from tin
     *           takes out two beans randomly
     */
    private static int[] takeTwo(char[] tin) {
        int[] b = new int[2];
        int count = tin.length;
        // takes one bean randomly
        // until length of tin >= 2 and this bean is not removed
        do {
            b[0] = (int) (Math.random() * count);
        } while (count >= 2 && tin[b[0]] == REMOVED);
        // takes the next bean randomly
        // until length of tin >= 2 and this bean is not remove
        // and this bean is different the first bean
        do {
            b[1] = (int) (Math.random() * count);
        } while (count >= 2 && tin[b[1]] == REMOVED && b[0] == b[1]);

        return b;
    }

    /**
     * determine the color of the last bean
     * 
     * @requirement: tin is not null /\ tin.length > 0
     * @effects:
     *           {@link #takeTwo()} after taking out two beans
     *           if they are the same color
     *           throw them both away
     *           put a Blue Mountain bean back in
     *           else
     *           throw away the blue one
     *           put the green one back
     *           until the bean in the tin = 1
     */
    private static char[] updateTin(char[] tin) {
        int b1, b2;
        // count is assigned to the length of tin
        int count = tin.length;
        /**
         * check condition: if two beans are the same color
         * throw both away
         * put Blue bean back
         * otherwise
         * put Green bean back
         */
        while (count >= 2) {
            int[] a = takeTwo(tin);
            // remove beans in tin
            b1 = tin[a[0]];
            tin[a[0]] = REMOVED;
            b2 = tin[a[1]];
            tin[a[1]] = REMOVED;
            if (b1 == b2) {
                // put blue in tin
                tin[a[0]] = BLUE;
            } else {
                // put green in tin
                tin[a[0]] = GREEN;
            }

            // reduce the length of tin
            count = count - 1;
        }
        // return the bean in the tin
        return tin;
    }

    /**
     * perform the coffee tin game
     * 
     * @requirement: tin is not null /\ tin.length > 0
     * @effects:
     *           return color of the lastBean
     */
    private static char tinGame(char[] tin) {
        // invoke updateTin()
        char[] a = updateTin(tin);
        // initialize the last bean is removed
        char lastBean = REMOVED;
        int l = tin.length;

        for (int i = 0; i < l; i++) {
            if (a[i] != REMOVED) {
                // a[i] is not remove
                // lastBean is a[i]
                lastBean = a[i];
                break;
            }
        }
        // return color of the lastBean
        return lastBean;
    }
}