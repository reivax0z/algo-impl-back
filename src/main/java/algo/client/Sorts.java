package algo.client;

import algo.client.IClient;
import algo.client.IClientList;
import algo.client.sort.BubbleSort;
import algo.client.sort.ClassicSort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class Sorts implements IClientList {

    @Autowired
    private ClassicSort classicSort;
    @Autowired
    private BubbleSort bubbleSort;

    @Override
    public List<IClient> getClients() {
        return Arrays.asList(classicSort, bubbleSort);
    }
}
