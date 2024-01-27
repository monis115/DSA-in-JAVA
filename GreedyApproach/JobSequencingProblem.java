import java.util.ArrayList;
import java.util.*;

public class JobSequencingProblem {
    static class job {
        int deadline;
        int profit;
        int id;// 0(A),1(B),2(C)......

        // constructor
        public job(int d, int p, int id) {
            this.deadline = d;
            this.profit = p;
            this.id = id;
        }
    }

    public static void main(String args[]) {
        int jobsInfo[][] = { { 4, 20 },
                { 1, 10 },
                { 1, 40 },
                { 1, 30 }

        };
        ArrayList<job> jobs = new ArrayList<>();

        for (int i = 0; i < jobsInfo.length; i++) {
            jobs.add(new job(jobsInfo[i][0], jobsInfo[i][1], i));
        }
        // this is way to sort the Object
        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);// descending Sorted
        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;
        for (int i = 0; i < jobs.size(); i++) {
            job curr = jobs.get(i);
            if (curr.deadline > time) {
                time++;
                seq.add(curr.id);
            }

        }
        System.out.println("Max Jobs " + seq.size());
        for (int i = 0; i < seq.size(); i++) {
            System.out.print(seq.get(i) + " ");
        }

    }
}
