package interview.math;

import java.util.ArrayList;
import java.util.List;

public class Gcd {

    public static void main(String[] args) {

        System.out.println("gcd(48,18) = " + gcd(48, 18));
        System.out.println("gcd(7,10) = " + gcd(7, 10));
        System.out.println("gcd(18,60) = " + gcd(18, 60));

        System.out.println("lcm(6,9) = " + lcm(6, 9));

        System.out.println(primeFactor(45));

        System.out.println("gcdV2(18,48) = " + gcdV2(48, 18));
    }


    private static int gcdV2(int a, int b) {
        return b == 0 ? a : gcdV2(b, a % b);
    }

    private static int gcd(int a, int b) {
        //gcd(48,18) = 6
        // 30,18   12,18    6,12  =>6

        /**
         *    a = dx  = kb + r
         *    b = dy
         *
         *    r = a - kb = dx - k d y  = d (x - ky) => r % d == 0
         */

        if (b == 0) return a;
        return gcd(b, a % b);
    }

    //least common multiple
    // (12,15) = 60
    private static int lcm(int a,int b) {
//        int m = Math.max(a,b);
//        for (int i = m; i < a * b; i+= m)
//            if (i % Math.min(a,b) == 0) return i;
//        return a * b;

        /**
         * a = m^x
         * b = m^y
         *
         * gcd = m ^(min x,y)
         * lcm = m ^ (max x y)
         * => a .b = m ^ (x+y)    =   m ^ (min (x,y) + max(x,y) = m ^ (x + y)
         */
        return a * b / gcd(a,b);
    }

    // 6
    private static List<Integer> primeFactor(int n) {
        List<Integer> ret = new ArrayList<>();
        int k = 2;
        while (n > 1) {
            while (n % k == 0) {
                ret.add(k);
                n = n / k;
            }
            k++;
        }
        return ret;
    }
}
