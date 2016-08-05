package algo.model;

import io.swagger.annotations.ApiModel;

import java.util.ArrayList;
import java.util.List;

@ApiModel
public class ReportItem {

    private String algoName;
    private long avgTime;

    private List<Item> timePerIteration = new ArrayList<>();

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

    public List<Item> getTimePerIteration() {
        return timePerIteration;
    }

    public void setTimePerIteration(List<Item> timePerIteration) {
        this.timePerIteration = timePerIteration;
    }
}
