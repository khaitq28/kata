package interview.math;

import java.util.HashMap;
import java.util.Map;

public class Random {

    public static void main(String[] args) {


        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            int v = random(10);
            m.put(v, m.getOrDefault(v,0) + 1);
        }

        System.out.println("m = " + m);

    }
    private static long v = System.nanoTime();

    private static int random(int a) {
        v = v * 3117 + 119737213;
        return (int)(Math.abs(v % a));
    }
}
