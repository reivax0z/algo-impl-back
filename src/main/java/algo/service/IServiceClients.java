package algo.service;

import algo.client.IClientList;
import algo.model.Report;

public interface IServiceClients {

    Report serve(Integer iteration, IClientList clients, Integer size);
}
