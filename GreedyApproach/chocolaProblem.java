import java.util.*;

public class chocolaProblem {

    public static void main(String args[]) {

        Integer costVer[] = { 2, 1, 3, 1, 4 };
        Integer costHor[] = { 4, 1, 2 };
        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());
        int h = 0, v = 0;
        int vp = 1, hp = 1;
        int totCost = 0;
        while (h < costHor.length && v < costVer.length) {
            // vertical Cost < Horizontal Cost
            if (costVer[v] <= costHor[h]) {// horizontal cut
                totCost += costHor[h] * vp;
                hp++;
                h++;
            } else {// vertical Cut
                totCost += costVer[v] * hp;
                v++;
                vp++;

            }

        }
        while (v < costVer.length) {
            totCost += costVer[v] * hp;
            v++;
            vp++;
        }
        while (h < costHor.length) {
            totCost += costHor[h] * vp;
            hp++;
            h++;
        }
        System.out.println("Min Cost " + totCost);
    }
}
