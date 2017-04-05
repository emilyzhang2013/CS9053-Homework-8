package edu.nyu.cs9053.homework8;

import java.util.*;
import java.lang.*;

/**
 * Created by emily on 4/3/17.
 */
public class LambdaWeightedScheduler {

    public static List<Job> sortEndTime(List<Job> needToSort) {
        Collections.sort(needToSort, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return (o1.getEndTime() != o2.getEndTime() ?
                        o1.getEndTime().compareTo(o2.getEndTime()) : o1.getStartTime().compareTo(o2.getStartTime()));
            }
        });
        return needToSort;
    }

    public static List<Job> processJobList(List<Job> needToProcess) {
        // Store the optimized cost when regard the current tuple as optimized solution.
        Map<Job, Double> optimizedCost = new TreeMap<>(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return (o1.getEndTime() != o2.getEndTime() ?
                        o2.getEndTime().compareTo(o1.getEndTime()) : o2.getStartTime().compareTo(o1.getStartTime()));
            }
        });
        if (needToProcess == null || needToProcess.isEmpty()){
            return null;
        }
        optimizedCost.put(needToProcess.get(0), needToProcess.get(0).getCost());
        double maxCost = needToProcess.get(0).getCost();

        List<Job> result = new LinkedList<>();
        // Store the optimized path reflect to the current tuple of optimizedCost.
        Map<Job, List<Job>> optimizedPath = new HashMap<>();

        for (Job oneJob: needToProcess) {
            // Store the optimized path of this job.
            List<Job> schedule = new LinkedList<>();
            // Store the maximum cost when the current job is regarded a part of result.
            double maxLocalCost = 0d;
            double cost = oneJob.getCost();
            for (Map.Entry<Job, Double> entry : optimizedCost.entrySet()) {
                if (oneJob.getStartTime() >= entry.getKey().getEndTime()){
                    cost = entry.getValue() + oneJob.getCost();
                    // Update current path and result when find a maximum price.
                    if (cost >= maxLocalCost && cost >= maxCost) {
                        maxLocalCost = cost;
                        maxCost = cost;
                        schedule = new LinkedList<>(optimizedPath.get(entry.getKey()));
                        result = schedule;
                    }
                }
                // Choose the path which can get maximum local cost
                if (cost >= maxLocalCost) {
                    schedule.add(oneJob);
                    optimizedPath.put(oneJob, schedule);
                    result = schedule;
                }
            }
            optimizedCost.put(oneJob, maxLocalCost);
        }
        return result;
    }
}
