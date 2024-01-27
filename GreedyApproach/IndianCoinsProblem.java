import java.util.Arrays;
import java.util.Comparator;

public class IndianCoinsProblem {
    public static void main(String args[]) {
        Integer notes[] = { 2000, 200, 500, 100, 50, 20, 10, 5, 2, 1 };
        int amount = 798;
        int count = 0;
        Arrays.sort(notes, Comparator.reverseOrder());
        for (int i = 0; i < notes.length; i++) {
            if (amount >= notes[i]) {
                while (notes[i] <= amount) {
                    count++;
                    System.out.println(notes[i]);
                    amount -= notes[i];
                }
            }
        }
        System.out.println(count);

    }

}
