package bk;

public class Prime {


    public static void main(String[] args) {

        System.out.println("countPrime(10) = " + countPrime(10));
        System.out.println("countPrime(20) = " + countPrime(20));
        System.out.println("isPrime(27) = " + isPrime(27));
        System.out.println("isPrime(111) = " + isPrime(111));

    }

    public static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) {
                System.out.println("i = " + i);
                return false;
            }
        return true;
    }

    // how many prime <= n
    public static int countPrime(int n){
        int ret = 0;
        int m = (int)(Math.sqrt(n));
        boolean [] check = new boolean[n+1];   // 0 -> 100
        for (int i = 1; i < m; i++) {
            int j = i;
            while ( (i+1) * (j+1) <= n) {
                check[ (i+1) * (j + 1)] = true;
                j++;
            }
        }
        for (int i = 2 ; i <= n; i++) {
            if (!check[i]) {
                ret ++;
            }
        }
        return ret;
    }
}
