package algorithms.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ActivitySelection {

    public static void printMaxActivities(List<Activity> activities) {
        int i = 0;
        activities.sort(Comparator.comparing(Activity::getFinish));
        System.out.println("Sorted Activities: " + activities);
        System.out.println("Following activities are selected : n");

        System.out.println(activities.get(0));

        for (int j = 1; j < activities.size(); j ++) {
            if (activities.get(j).getStart() >= activities.get(i).getFinish()) {
                System.out.println(activities.get(j));
                 i = j;
            }
        }
    }

    public static void main(String[] args) {

        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity(5,9));
        activities.add(new Activity(1,2));
        activities.add(new Activity(3,4));
        activities.add(new Activity(0,6));
        activities.add(new Activity(5,7));
        activities.add(new Activity(8,9));

        printMaxActivities(activities);
    }
}
