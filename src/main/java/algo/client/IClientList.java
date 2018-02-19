package algo.client;

import algo.model.ClientType;

import java.util.List;

public interface IClientList {

    String getType();
    List<IClient> getClients();
}
