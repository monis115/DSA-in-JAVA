import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class jobSequencing {

    public static void main(String args[]) {
        class pair {
            int profit;
            int deadline;
            int id;

            pair(int i, int j, int k) {
                profit = i;
                deadline = j;
                id = k;
            }
        }
        int jobInfo[][] = {
                { 1, 40 },
                { 1, 30 },
                { 4, 20 },
                { 1, 10 }
        };
        // sorting the object

        ArrayList<pair> list = new ArrayList<>();
        for (int i = 0; i < jobInfo.length; i++) {
            list.add(new pair(jobInfo[i][1], jobInfo[i][0], i));
        }
        Collections.sort(list, (obj1, obj2) -> obj2.profit - obj1.profit);
        int time = 0;
        ArrayList<Integer> seq = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            pair curr = list.get(i);
            if (curr.deadline > time) {
                time++;
                seq.add(curr.id);
            }

        }
        for (int i = 0; i < seq.size(); i++) {
            System.out.print(seq.get(i) + " ");
        }
    }

}
