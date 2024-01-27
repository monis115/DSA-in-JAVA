
import java.util.*;

public class activitySelection {
    public static void main(String args[]) {

        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 };// end time Sorted Baisi

        // if end time is not sorted
        int activities[][] = new int[start.length][3];
        for (int i = 0; i < start.length; i++) {
            // here we are storing the Value in 2D array which has 3 Cols
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];

        }
        // lamda Function-> short function of a predefined Function
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));// sorting asceding ORder
        int count = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        count = 1;
        ans.add(activities[0][0]);
        int lastEnd = activities[0][2];
        for (int i = 0; i < end.length; i++) {
            if (activities[i][1] >= lastEnd) {
                count++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }
        System.out.println("Max Activity" + count);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }

    }

}