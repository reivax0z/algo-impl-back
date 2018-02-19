package algo.client;

import algo.client.sort.BubbleSort;
import algo.client.sort.ClassicSort;
import algo.model.ClientType;
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
    public String getType() {
        return "SORT";
    }

    @Override
    public List<IClient> getClients() {
        return Arrays.asList(classicSort, bubbleSort);
    }
}
