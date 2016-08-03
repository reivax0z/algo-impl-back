package algo.service;

import algo.client.IClient;
import algo.model.Report;

import java.util.List;

public interface IService {

    Report serve(Integer iteration, List<IClient> clients, Integer size);
}
