import java.util.*;

public class ActivitySelectionProblem {
    public static void main(String args[]) {
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 };
        int activities[][] = new int[start.length][3];
        // now are storing the Array in to arrray
        for (int i = 0; i < end.length; i++) {
            activities[i][0] = i;// this is index of Every start and End time
            activities[i][1] = start[i];// storing the Satrt time
            activities[i][2] = end[i];// Storing the End time

        }
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));// here we are sorting the 2D array According to
                                                                       // the end
        int count = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(activities[0][0]);// index of First Activity
        int lastEnd = activities[0][2];// this is the end time of First Acitvity
        count++;// we counted the First Acitvity
        for (int i = 0; i < end.length; i++) {
            if (activities[i][1] >= lastEnd) {
                count++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }
        System.out.println("The Total Activity is -> " + count);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
    }

}
