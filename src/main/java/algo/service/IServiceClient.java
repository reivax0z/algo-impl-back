package algo.service;

import algo.client.IClient;

public interface IServiceClient {

    long serve(IClient client, Integer[] input);
}
