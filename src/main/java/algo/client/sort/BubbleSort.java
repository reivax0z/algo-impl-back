package algo.client.sort;

import algo.client.IClient;
import org.springframework.stereotype.Component;

@Component
public class BubbleSort implements IClient {

    @Override
    public String getName() {
        return "Bubble Sort";
    }

    @Override
    public Integer[] compute(Integer[] input) {

        boolean sorted = false;

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < input.length - 2; i++) {
                if (input[i + 1] < input[i]) {
                    // swap over to keep proper order
                    int temp = input[i];
                    input[i] = input[i + 1];
                    input[i + 1] = temp;
                    sorted = false;
                }
            }
        }

        return input;
    }
}
