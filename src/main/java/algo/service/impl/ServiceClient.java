package algo.service.impl;

import algo.client.IClient;
import algo.service.IServiceClient;
import org.springframework.stereotype.Service;

@Service
public class ServiceClient implements IServiceClient{

    @Override
    public long serve(IClient client, Integer[] input) {
        long before = System.currentTimeMillis();

        client.compute(input);

        long after = System.currentTimeMillis();

        return after - before;
    }
}
