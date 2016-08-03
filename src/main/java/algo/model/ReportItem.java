package algo.model;

import io.swagger.annotations.ApiModel;

import java.util.HashMap;
import java.util.Map;

@ApiModel
public class ReportItem {

    private String algoName;
    private long avgTime;
    private Map<Integer, Long> timePerIteration = new HashMap<>();

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

    public Map<Integer, Long> getTimePerIteration() {
        return timePerIteration;
    }

    public void setTimePerIteration(Map<Integer, Long> timePerIteration) {
        this.timePerIteration = timePerIteration;
    }
}
