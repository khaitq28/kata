package interview.math;

public class Sqrt {

    public static void main(String[] args) {
        System.out.println("proximateSqrt(10) = " + proximateSqrt(10));
        System.out.println("proximateSqrt(26) = " + proximateSqrt(26));
        System.out.println("proximateSqrt(37) = " + proximateSqrt(37));

        System.out.println("sqrt(0.45, 0.01) = " +  sqrt(0.45, 0.001));
        System.out.println("sqrt(30,0.0001) = " + sqrt(30, 0.0001));
        System.out.println("sqrt(15, 0.0001) = " + sqrt(15, 0.0001));

        System.out.println("cubeRoot(1000) = " + cubeRoot(1000));
        System.out.println("cubeRoot(900) = " + cubeRoot(900));
    }

    private static double sqrt(double x, double eclipse) {
        double l = 0, r = Math.max(x,1), ret = 0;
        while (Math.abs(x - ret * ret) >= eclipse) {
            double mid = l + (r - l)/2;
            double square = mid * mid;
            if (square > x) {
                r = mid;
            } else {
                ret = mid;
                l = mid;
            }
        }
        return ret;
    }

    private static int proximateSqrt(int x) {
        if (x <= 1) return x;
        int l = 1; int r = x; int ret = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int square  = mid * mid;
            if (square == x)  return mid;
            if (square > x) {
                r = mid-1;
            } else {
                ret = mid;
                l = mid+1;
            }
        }
        return ret;
    }

    private static double cubeRoot(double d) {
        // 1000 => 10
        double ret = 1;
        int l = 1; int r = (int)d;
        while (l <= r) {
            int m = l + (r - l)/2;
            if (m * m * m == d) return m;
            if (m * m * m < d) {
                ret = m;
                l = m + 1;
            } else {
                r = m -1;
            }
        }
        return ret;
    }
}
