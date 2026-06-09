package interview.math;

public class ReverseInteger {


    public static void main(String[] args) {
        System.out.println("reverse(10245) = " + reverse(10245));
        System.out.println("reverse(563) = " + reverse(563));
    }


    private static int reverse(int i) {
        int ret = 0;
        // 123
        while (i > 0) {
            int r = i % 10;
            i = i /10;
            ret = ret * 10 + r;
        }
        return ret;
    }
}
