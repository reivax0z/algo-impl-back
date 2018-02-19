package algo.model;

import io.swagger.annotations.ApiModel;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@ApiModel
@DynamoDBDocument
public class Item {
    private Integer iteration;
    private Long timeSpent;

    @DynamoDBAttribute(attributeName = "Iteration")
    public Integer getIteration() {
        return iteration;
    }

    public void setIteration(Integer iteration) {
        this.iteration = iteration;
    }

    @DynamoDBAttribute(attributeName = "TimeSpent")
    public Long getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(Long timeSpent) {
        this.timeSpent = timeSpent;
    }
}
