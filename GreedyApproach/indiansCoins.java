import java.util.*;

public class indiansCoins {
    public static void main(String args[]) {
        Integer Coins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };
        Arrays.sort(Coins, Comparator.reverseOrder());/// lamda function to reverse Order
        int coinsTot = 0;
        int amount = 590;
        ArrayList<Integer> listNotes = new ArrayList<>();
        for (int i = 0; i < Coins.length; i++) {
            if (Coins[i] <= amount) {
                while (Coins[i] <= amount) {
                    coinsTot++;
                    amount -= Coins[i];
                    listNotes.add(Coins[i]);
                }
            }
        }
        System.out.println("Total Notes " + coinsTot);
        for (int i = 0; i < listNotes.size(); i++) {
            System.out.print(listNotes.get(i) + " ");
        }

    }

}
