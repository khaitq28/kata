package interview.math;

public class Prime {


    public static void main(String[] args) {
//        System.out.println("isPrime(2) = " + isPrime(2));
//        System.out.println("isPrime(11) = " + isPrime(11));
//        System.out.println("isPrime(29) = " + isPrime(29));
//        System.out.println("isPrime(25) = " + isPrime(25));

        System.out.println("countPrime(10) = " + countPrime(10));
        System.out.println("countPrime(20) = " + countPrime(20));
        System.out.println("countPrime(100) = " + countPrime(100));
    }


    /**
     *  prime: 1,3,5,7,11,13
     *  if exist k > sqrt(n)    k*k = n
     *  ==>  k* k = n > n => false
     */
    private static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n% i == 0) return false;
        }
        return true;
    }

    /**
     * Count how many prime <= n
     *   1 2 3 4 5
     *   2
     *   3
     *   4
     *   5       25
     */
    private static int countPrime(int n) {
        int ret = 0;
        int m = (int) Math.sqrt(n);
        boolean[] check = new boolean[n+1];
        for (int i = 1; i < m; i++) {
            int j = i;
            while ((i+1) * (j+1) <= n) {
                check[(i+1) * (j+1)] = true;
                j++;
            }
        }
        for (int i = 2; i <= n; i++) {
            ret += (check[i] ? 0:1);
        }
        return ret;
    }
}
