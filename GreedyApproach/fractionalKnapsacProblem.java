import java.util.Arrays;
import java.util.Comparator;

public class fractionalKnapsacProblem {

    public static void main(String args[]) {
        int value[] = { 60, 100, 120 };
        int weight[] = { 10, 20, 30 };
        int W = 50;
        int capacity = W;
        int totvalue = 0;
        double ratio[][] = new double[value.length][2];
        for (int i = 0; i < value.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = value[i] / (double) weight[i];// type Casting
        }
        // sorting the ratio
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
        // Arrays.sort(ratio,Comparator.comparingDouble(o->o[1]));
        for (int i = ratio.length - 1; i >= 0; i--) {
            int index = (int) ratio[i][0];// typeCasting
            if (capacity >= weight[index]) {
                totvalue += value[index];

                capacity -= weight[index];
            } else {
                totvalue += ratio[i][1] * capacity;

                capacity = 0;
                break;
            }
        }
        System.out.println("The Max Profit will be ->" + totvalue);

    }
}
