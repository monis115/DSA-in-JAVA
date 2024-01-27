
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class maxchainLengthProblem {

    public static void main(String args[]) {
        int Pair[][] = { { 5, 24 },
                { 39, 60 },
                { 5, 28 },
                { 27, 40 },
                { 50, 90 }

        };
        // here we have created a class pair which is used to store the Pair in
        // ArrayList or LinkedList or Queue Of Type pair
        class pair {
            int first;
            int Second;

            pair(int i, int j) {
                first = i;
                Second = j;
            }
        }
        ArrayList<pair> list = new ArrayList<>();
        // Sorting According to the SecondElement
        Arrays.sort(Pair, Comparator.comparingDouble(o -> o[1]));// Ascending Order
        int count = 0;
        int LastEnd = Pair[0][1];
        list.add(new pair(Pair[0][0], Pair[0][1]));
        count++;
        for (int i = 0; i < Pair.length; i++) {
            if (Pair[i][0] >= LastEnd) {
                count++;
                LastEnd = Pair[i][1];
                list.add(new pair(Pair[i][0], Pair[i][1]));
            }

        }
        System.out.println(count);

        for (int i = 0; i < list.size(); i++) {
            pair p = list.get(i);
            System.out.println(p.first + " " + p.Second);
        }

    }
}
