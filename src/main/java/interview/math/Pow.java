package interview.math;

public class Pow {

    public static void main(String[] args) {

        System.out.println("pow(2,10) = " + pow(2, 10));
        System.out.println("pow(3,4) = " + pow(3, 4));
        System.out.println("pow(2,-2) = " + pow(3, -1));

        System.out.println("powRecursive(2,12) = " + powRecursive(2, 12));
        System.out.println("powRecursive(2,7) = " + powRecursive(2, 7));
    }

    /**
     * pow(2, 10) = 1024
     * pow(2, -2) = 0.25
     */
    private static double pow(int n, int k) {
        boolean revers = k < 0;
        double ret = 1;
        for (int i = 0; i < Math.abs(k); i++) {
            ret = ret * n;
        }
        return revers ? 1 / ret: ret;
    }


    /**
     * 2^10 = 2 ^ 5 ^ 2 = 2* 2^2   ^ 2
     */
    private static int powRecursive(int n, int k) {
        if (k == 1) return n;
        int subPow = powRecursive(n, k/2);
        if (k %2 == 1) {
            return n * subPow * subPow;
        }
        return subPow * subPow;
    }
}
