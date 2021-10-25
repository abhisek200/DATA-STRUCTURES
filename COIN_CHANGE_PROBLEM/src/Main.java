import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int []coinValues={1,2,5,10,20,50,100,1000};
        int totalAmount=2035;
        System.out.println("Coins Available: "+ Arrays.toString(coinValues));
        System.out.println("Target amount: "+totalAmount);
        CoinChangeProblem.coinChangeProblem(coinValues,totalAmount);
    }
}
