package edu.nyu.cs9053.homework8;

/**
 * Created by emily on 4/2/17.
 */
public class Job {
    private Long startTime;
    private Long endTime;
    private int label;
    private double cost;

    protected Job(Long startTime,Long endTime,int label, double cost){
        this.startTime = startTime;
        this.endTime = endTime;
        this.label = label;
        this.cost = cost;
    }

    public Long getStartTime(){
        return startTime;
    }

    public Long getEndTime(){
        return endTime;
    }

    public int getLabel(){
        return label;
    }

    public double getCost(){
        return cost;
    }


}
