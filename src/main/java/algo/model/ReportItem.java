package algo.model;

import io.swagger.annotations.ApiModel;

import java.util.ArrayList;

@ApiModel
public class ReportItem {

    private String algoName;
    private long avgTime;

    private ArrayList<Item> timePerIteration = new ArrayList<>();

    public String getAlgoName() {
        return algoName;
    }

    public void setAlgoName(String algoName) {
        this.algoName = algoName;
    }

    public long getAvgTime() {
        return avgTime;
    }

    public void setAvgTime(long avgTime) {
        this.avgTime = avgTime;
    }

    public ArrayList<Item> getTimePerIteration() {
        return timePerIteration;
    }

    public void setTimePerIteration(ArrayList<Item> timePerIteration) {
        this.timePerIteration = timePerIteration;
    }
}
