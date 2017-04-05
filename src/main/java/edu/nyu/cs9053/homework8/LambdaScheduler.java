package edu.nyu.cs9053.homework8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;

/**
 * Created by emily on 4/2/17.
 */
public class LambdaScheduler {

    public static List<Job> sortEndTime(List<Job> needToSort) {
        Collections.sort(needToSort, new Comparator<Job>() {
            @Override public int compare(Job o1, Job o2) {
                return (o1.getEndTime() != o2.getEndTime()) ?
                        (o1.getEndTime().compareTo(o2.getEndTime())) : (o1.getStartTime().compareTo(o2.getStartTime()));
            }
        });
        return needToSort;
    }

    public static List<Job> getMaxPossibleSize(List<Job> needToProcess) {
        List<Job> jobListNeedToWork = new ArrayList<>(10);
        jobListNeedToWork.add(needToProcess.get(0));

        Long preEnd = needToProcess.get(0).getEndTime();

        for (int i = 1; i < needToProcess.size() ; i++ ){
            if (needToProcess.get(i).getStartTime().compareTo(preEnd) < 0) {
                preEnd = preEnd.compareTo(needToProcess.get(i).getEndTime()) < 0 ? preEnd : needToProcess.get(i).getEndTime();
            } else {
                preEnd = needToProcess.get(i).getEndTime();
                jobListNeedToWork.add(needToProcess.get(i));
            }
        }

        return jobListNeedToWork;

    }

}
