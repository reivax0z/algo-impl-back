package algo.model;

import io.swagger.annotations.ApiModel;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@ApiModel
public class Report {

    @Id
    private String id;

    private ClientType type;
    private int nbIterations;
    private int sampleSize;
    private List<ReportItem> reportItems = new ArrayList<>();

    public List<ReportItem> getReportItems() {
        return reportItems;
    }

    public void setReportItems(List<ReportItem> reportItems) {
        this.reportItems = reportItems;
    }

    public int getNbIterations() {
        return nbIterations;
    }

    public void setNbIterations(int nbIterations) {
        this.nbIterations = nbIterations;
    }

    public int getSampleSize() {
        return sampleSize;
    }

    public void setSampleSize(int sampleSize) {
        this.sampleSize = sampleSize;
    }

    public ClientType getType() {
        return type;
    }

    public void setType(ClientType type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
