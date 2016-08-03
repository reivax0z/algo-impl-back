package algo.service.impl;

import algo.client.IClient;
import algo.model.Report;
import algo.model.ReportItem;
import algo.service.IService;
import algo.util.Generator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service implements IService {

    @Autowired
    private Generator generator;

    @Override
    public Report serve(Integer iteration,
                        List<IClient> clients,
                        Integer size) {
        Report report = new Report();
        report.setNbIterations(iteration);
        report.setSampleSize(size);

        for (IClient client: clients) {

            ReportItem reportItem = new ReportItem();
            reportItem.setAlgoName(client.getName());

            long sum = 0;
            for (int i = 0; i < iteration; i++) {
                long timeSpent = callAndComputeTimeSpent(client, size);
                reportItem.getTimePerIteration().put(i, timeSpent);
                sum += timeSpent;
            }

            reportItem.setAvgTime(sum / iteration);
            report.getReportItems().add(reportItem);
        }

        return report;
    }

    private long callAndComputeTimeSpent(IClient client, Integer size) {

        Integer[] input = generator.generateInput(size);

        long before = System.currentTimeMillis();

        client.compute(input);

        long after = System.currentTimeMillis();

        return after - before;
    }
}
