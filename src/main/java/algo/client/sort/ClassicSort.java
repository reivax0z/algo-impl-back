package algo.client.sort;

import algo.client.IClient;
import org.springframework.stereotype.Component;

@Component
public class ClassicSort implements IClient{

    @Override
    public String getName() {
        return "Classic Sort";
    }

    @Override
    public Integer[] compute(Integer[] input) {
        if (input == null || input.length < 2) {
            return input;
        }

        for (int i=0; i<input.length-2; i++) {
            for (int j=input.length-1; j>i; j--) {
                if (input[j] < input[i]) {
                    // swap over to keep proper order
                    int temp = input[i];
                    input[i] = input [j];
                    input[j] = temp;
                }
            }
        }

        return input;
    }
}
