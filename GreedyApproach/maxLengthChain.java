import java.util.*;;

public class maxLengthChain {
    public static void main(String args[]) {
        int Pairs[][] = { { 5, 24 },
                { 39, 60 },
                { 5, 28 },
                { 27, 40 },
                { 50, 90 }
        };
        Arrays.sort(Pairs, Comparator.comparingDouble(o -> o[1]));// this is lamda function
        int chainLength = 1;
        int endChain = Pairs[0][1];
        for (int i = 1; i < Pairs.length; i++) {
            if (Pairs[i][0] > endChain) {
                chainLength++;
                endChain = Pairs[i][1];
            }

        }
        System.out.println("The Total Length is Of Possible Chain is -> " + chainLength);

    }

}
