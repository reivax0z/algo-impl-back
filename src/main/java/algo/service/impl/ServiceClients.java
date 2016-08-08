package algo.service.impl;

import algo.client.IClient;
import algo.client.IClientList;
import algo.helper.HelperImpl;
import algo.model.Item;
import algo.model.Report;
import algo.model.ReportItem;
import algo.service.IServiceClient;
import algo.service.IServiceClients;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class ServiceClients implements IServiceClients {

    @Autowired
    private IServiceClient serviceClient;
    @Autowired
    private HelperImpl helper;

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
            int sample = size / iteration;

            for (int i = 0; i < iteration; i++) {
                Item timePerIterationItem = helper.help(
                        serviceClient,
                        client,
                        size,
                        i);
                reportItem.getTimePerIteration().add(timePerIterationItem);
                sum += timePerIterationItem.getTimeSpent();

                Item timePerSampleItem = helper.help(
                        serviceClient,
                        client,
                        sample,
                        sample);
                reportItem.getTimePerSample().add(timePerSampleItem);
                sample += (size / iteration);
            }

            reportItem.setAvgTime(sum / iteration);
            report.getReportItems().add(reportItem);
        }

        return report;
    }
}
