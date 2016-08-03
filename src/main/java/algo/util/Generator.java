package algo.util;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
public class Generator {

    private Random rand = new Random();

    public Integer[] generateInput(Integer size) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i=0; i<size; i++) {
            arrayList.add(rand.nextInt());
        }

        return arrayList.toArray(new Integer[arrayList.size()]);
    }
}
