import java.util.*;

public class fractionalKnapsac {
    public static void main(String args[]) {
        int value[] = { 60, 100, 120 };
        int weight[] = { 10, 20, 30 };
        int W = 50;
        double ratio[][] = new double[value.length][2];
        // 0th col-> index
        // 1th col->ratio
        for (int i = 0; i < value.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = value[i] / (double) weight[i];// typeCatsing bcz ratio is Double type
        }
        // Now sorting
        // this is asceding Order
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));// sorting the Array According to the ratio
        int capacity = W;
        int finalValue = 0;
        for (int i = ratio.length - 1; i >= 0; i--) {
            int indx = (int) ratio[i][0];
            if (capacity >= weight[indx]) {
                finalValue += value[indx];
                capacity -= weight[indx];
            } else {// fraction of weight is including
                finalValue += ratio[i][1] * capacity;
                capacity = 0;
                break;
            }
        }
        System.out.println("Tha Value is " + finalValue);
    }

}
