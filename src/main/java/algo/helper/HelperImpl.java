package algo.helper;

import algo.util.Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelperImpl extends AbstractHelper {
    @Autowired
    private Generator generator;

    @Override
    protected Integer[] getInput(Integer size) {
        return generator.generateInput(size);
    }
}
