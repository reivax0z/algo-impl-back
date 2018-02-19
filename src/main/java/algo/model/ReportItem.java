package algo.model;

import io.swagger.annotations.ApiModel;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

import java.util.ArrayList;

@ApiModel
@DynamoDBDocument
public class ReportItem {

    private String algoName;
    private long avgTime;

    private ArrayList<Item> timePerIteration = new ArrayList<>();
    private ArrayList<Item> timePerSample = new ArrayList<>();

    @DynamoDBAttribute(attributeName = "AlgoName")
    public String getAlgoName() {
        return algoName;
    }

    public void setAlgoName(String algoName) {
        this.algoName = algoName;
    }

    @DynamoDBAttribute(attributeName = "AvgTime")
    public long getAvgTime() {
        return avgTime;
    }

    public void setAvgTime(long avgTime) {
        this.avgTime = avgTime;
    }

    @DynamoDBAttribute(attributeName = "TimePerIteration")
    public ArrayList<Item> getTimePerIteration() {
        return timePerIteration;
    }

    public void setTimePerIteration(ArrayList<Item> timePerIteration) {
        this.timePerIteration = timePerIteration;
    }

    @DynamoDBAttribute(attributeName = "TimePerSample")
    public ArrayList<Item> getTimePerSample() {
        return timePerSample;
    }

    public void setTimePerSample(ArrayList<Item> timePerSample) {
        this.timePerSample = timePerSample;
    }
}
