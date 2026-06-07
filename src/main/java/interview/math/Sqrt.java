package interview.math;

public class Sqrt {

    public static void main(String[] args) {
        System.out.println("proximateSqrt(10) = " + proximateSqrt(10));
        System.out.println("proximateSqrt(26) = " + proximateSqrt(26));
        System.out.println("proximateSqrt(37) = " + proximateSqrt(37));

        System.out.println("sqrt(0.225, 0.01) = " +  sqrt(0.45, 0.001));
        System.out.println("sqrt(29,0.0001) = " + sqrt(30, 0.0001));

        System.out.println("sqrt(15, 0.0001) = " + sqrt(15, 0.0001));
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
}
