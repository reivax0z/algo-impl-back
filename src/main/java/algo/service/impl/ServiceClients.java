package algo.service.impl;

import algo.client.IClient;
import algo.client.IClientList;
import algo.model.Report;
import algo.model.ReportItem;
import algo.service.IServiceClient;
import algo.service.IServiceClients;
import algo.util.Generator;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class ServiceClients implements IServiceClients {

    @Autowired
    private Generator generator;
    @Autowired
    private IServiceClient serviceClient;

    @Override
    public Report serve(Integer iteration,
                        IClientList clients,
                        Integer size) {

        Report report = new Report();

        report.setNbIterations(iteration);
        report.setSampleSize(size);
        report.setType(clients.getType());

        for (IClient client: clients.getClients()) {

            ReportItem reportItem = new ReportItem();
            reportItem.setAlgoName(client.getName());

            long sum = 0;
            for (int i = 0; i < iteration; i++) {
                long timeSpent = serviceClient.serve(
                        client,
                        generator.generateInput(size));

                reportItem.getTimePerIteration().put(i, timeSpent);
                sum += timeSpent;
            }

            reportItem.setAvgTime(sum / iteration);
            report.getReportItems().add(reportItem);
        }

        return report;
    }
}
