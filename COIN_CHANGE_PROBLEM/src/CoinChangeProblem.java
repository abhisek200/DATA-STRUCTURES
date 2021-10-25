import java.util.ArrayList;
import java.util.Arrays;

public class CoinChangeProblem {

    public static void coinChangeProblem(int[] coins, int totalAmount) {
        Arrays.sort(coins); //ascending order sort                          //O(NlogN)
        int index = coins.length - 1; //last element index
        while (true) {
            int coinValue = coins[index];
            index--;
            int maxAmount = (totalAmount / coinValue) * coinValue; //no of coins * value
            if (maxAmount > 0) {
                System.out.println("Coin value: " + coinValue + " taken count: " + (totalAmount / coinValue));
                totalAmount = totalAmount - maxAmount;
            }
            if (totalAmount == 0)
                break;
        }

    }
}
