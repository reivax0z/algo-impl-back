package algo.helper;

import algo.client.IClient;
import algo.model.Item;
import algo.service.IServiceClient;

public abstract class AbstractHelper {

    public Item help(IServiceClient serviceClient,
                     IClient client,
                     Integer size,
                     Integer value) {
        long timeSpent = serviceClient.serve(
                client,
                getInput(size));

        return generateItem(value, timeSpent);
    }

    private Item generateItem(Integer iteration, Long timeSpent) {
        Item item = new Item();
        item.setIteration(iteration);
        item.setTimeSpent(timeSpent);
        return item;
    }

    protected abstract Integer[] getInput(Integer size);
}
