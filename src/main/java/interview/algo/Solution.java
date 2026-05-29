package interview.algo;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {120,21};
        System.out.println(s.minMirrorPairDistance(arr));
    }

    public int minMirrorPairDistance(int[] arr) {

        Map<Integer, Integer> m = new HashMap<>();
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int c = arr[i];
            int re = revers(c);
            if (m.containsKey(re)) {
                ret = Math.min(ret, i - m.get(re));
            }
            m.put(c, i);
        }
        return ret;
    }

    int revers(int i) {
        return Integer.valueOf(new StringBuilder(i+"").reverse().toString());
    }
}