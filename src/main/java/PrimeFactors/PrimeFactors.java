package PrimeFactors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrimeFactors {

    public List<Integer> generate(int n) {

        if (n == 2) return Collections.singletonList(2);
        List<Integer> result = new ArrayList<>();
        int i = 2;
        while (n >= i) {
            while (n % i ==0) {
                n = n / i;
                result.add(i);
            }
            i++;
        }
        return result;
    }

}
