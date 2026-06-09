package interview.math;

public class DivideInteger {

    public static void main(String[] args) {
        System.out.println("divide(10,4) = " + divide(10, 4));
        System.out.println("divide(25,4) = " + divide(25, 4));
        System.out.println("divide(32,4) = " + divide(32, 4));
    }

    private static int divide(int a, int b) {
        int ret = 0;
        while (a >= b) {
            ret ++;
            a -=b;
        }
        return ret;
    }
}
