package algo;

import java.util.HashSet;
import java.util.Set;

public class SumSquare {


    public static void main(String[] args) {

        SumSquare sq = new SumSquare();

        System.out.println(sq.isOk(2147483600));
    }

    Set<Integer> set =new HashSet<>();

    private boolean isSum(int c) {
        for (int i = 1; i < Math.sqrt(c); i++) {
            set.add(i * i);
        }
        for (int i :set) {
            if (set.contains((c-i))) return true;
        }
        return false;
    }
    // 2 147 483 600
    private boolean isOk(int c) {
        int i =0; int j = (int) Math.sqrt(c);
        while (i <= j) {
            long v = (long) i * i + (long) j * j;
            if (v == c ) return true;
            if (v < c) i++;
            else j--;
        }
        return false;
    }
    int c ;

}


