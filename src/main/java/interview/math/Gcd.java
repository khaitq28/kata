package interview.math;

public class Gcd {

    public static void main(String[] args) {

        System.out.println("gcd(48,18) = " + gcd(48, 18));

        System.out.println("gcd(7,10) = " + gcd(7, 10));

        System.out.println("lcm(22,15) = " + lcm(22, 15));
    }

    private static int gcd(int a, int b) {
        //gcd(48,18) = 6
        // 30,18   12,18    6,12  =>6
        int min = Math.min(a,b);
        int max = Math.max(a,b);
        if (max % min == 0) return min;
        return gcd(max - min, min);
    }

    //least common multiple
    // (12,15) = 60
    private static int lcm(int a,int b) {
        int m = Math.max(a,b);
        for (int i = m; i < a * b; i+= m)
            if (i % Math.min(a,b) == 0) return i;
        return a * b;
    }
}
