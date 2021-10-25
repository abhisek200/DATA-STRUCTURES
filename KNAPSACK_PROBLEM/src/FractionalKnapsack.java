import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FractionalKnapsack {
    static void knapSack(ArrayList<KnapsackItem> items, int capacity) {
        Comparator<KnapsackItem> comparator = new Comparator<KnapsackItem>() {
            @Override
            public int compare(KnapsackItem o1, KnapsackItem o2) {
                if (o2.getRatio() > o1.getRatio()) //descending sort
                    return 1;
                else
                    return -1;
            }
        };
        Collections.sort(items, comparator); //sort
        //algorithm
        int usedCapacity = 0;
        double totalValue = 0;

        for (KnapsackItem item : items) {
            if (usedCapacity + item.getWeight() <= capacity) {
                usedCapacity += item.getWeight(); //STORES WEIGHT USED
                System.out.println("Taken: " + item);
                totalValue += item.getValue();
            } else {                            //THIS WILL ALWAYS BE EXECUTED AT END OR LAST LOOP RUN
                int usedWeight = capacity - usedCapacity;
                double newValue = item.getRatio() * usedWeight; //NEW VALUE BASED ON CHANGED WEIGHT, SINCE RATIO REMAINS SAME
                System.out.println("Taken: item index= " + item.getIndex() + " ,obtained value= " + newValue + " ,Used Weight= " + usedWeight + " ,ratio= " + item.getRatio());
                usedCapacity += usedWeight;
                totalValue += newValue;
            }
            if (usedCapacity == capacity) break;
        }
        System.out.println("Total value obtained: " + totalValue);
    }
}

