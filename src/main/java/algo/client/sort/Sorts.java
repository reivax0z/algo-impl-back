package algo.client.sort;

import algo.client.IClient;
import algo.client.IClientList;
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
