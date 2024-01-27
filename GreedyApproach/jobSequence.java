import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class jobSequence {
    public static void main(String args[]) {
        int jobsInfo[][] = {
                { 4, 20 },
                { 1, 10 },
                { 1, 40 },
                { 1, 30 }
        };
        int jobs[][] = new int[jobsInfo.length][3];
        for (int i = 0; i < jobsInfo.length; i++) {
            jobs[i][0] = i;
            jobs[i][1] = jobsInfo[i][0];// deadline
            jobs[i][2] = jobsInfo[i][1];// profit
        }

        // Now Sorting the jobs according to the profit in ascednig Order
        Arrays.sort(jobs, Comparator.comparingDouble(o -> o[2]));
        int time = 0;
        ArrayList<Integer> sequence = new ArrayList<>();
        for (int i = jobs.length - 1; i >= 0; i--) {
            if (jobs[i][1] >= time) {
                sequence.add(jobs[i][0]);
                time++;
            }
        }
        for (int i = 0; i < sequence.size(); i++) {
            System.out.print(sequence.get(i) + " ");
        }

    }

}
