import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ActivitySection {

    public static void activitySelection(ArrayList<Activity> activityList) {
        Comparator<Activity> finishTime = new Comparator<Activity>() {
            @Override
            public int compare(Activity o1, Activity o2) {
                return o1.getFinishTime() - o2.getFinishTime(); //arranges in ascending order based on Finish Time
            }
        };
        Collections.sort(activityList, finishTime);                 //O(nlogn) TC
        Activity previousActivity = activityList.get(0);

        System.out.println("\nRecommend Schedule:\n" + activityList.get(0));
        for (int i = 1; i < activityList.size(); i++) {
            Activity activity = activityList.get(i);
            if (activity.getStartTime() >= previousActivity.getFinishTime()) {
                System.out.println(activity); //prints the overridden toString function
                previousActivity = activity;
            }
        }
    }
}
