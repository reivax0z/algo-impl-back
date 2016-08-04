package algo.client;

import algo.model.ClientType;

import java.util.List;

public interface IClientList {

    ClientType getType();
    List<IClient> getClients();
}
