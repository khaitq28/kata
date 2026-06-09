package interview.math;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println("fib(1) = " + fib(1));
        System.out.println("fib(2) = " + fib(2));
        System.out.println("fib(3) = " + fib(3));
        System.out.println("fib(5) = " + fib(5));
        System.out.println("fib(6) = " + fib(6));
        System.out.println("fib(10) = " + fib(10));

        System.out.println("fib2(10) = " + fib2(10));
        System.out.println("fib2(6) = " + fib2(6));

        System.out.println("factorial(5) = " + factorial(5));

    }
    private static int fib(int n) {
        if (n <= 1) return n;
        int f = 0;
        int s = 1;
        int cur = 0;
        for (int i = 2; i <= n; i++) {
            cur = f + s;
            f = s; s = cur;
        }
        return cur;
    }

    private static int fib2(int n) {
        if (n <= 1) return n;
        return fib2(n - 1) +fib2(n-2);
    }

    private static int factorial(int n) {
        //return n !
        int ret =1;
        for (int i = 1; i <= n; i++)
            ret *= i;
        return ret;
    }
}
