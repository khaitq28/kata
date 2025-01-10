package org.codingdojo.yatzy1;

import java.util.Arrays;

import static java.util.Arrays.stream;

public class Yatzy1 {

    public static int chance(int... dice) {
        return stream(dice).sum();
    }

    public static int yatzy(int... positions) {
        stream(positions).filter(p -> p <= 0).findAny().ifPresent(p -> {
            throw new IllegalArgumentException("Dice value must be greater than 0");
        });
        int max = stream(positions).max().orElse(0);
        int[] counts = new int[max];
        for (int position : positions) {
            int index = position-1;
            counts[index]++;
        }
        return Arrays.stream(counts).filter(p -> p == 5).findAny().isEmpty() ? 0 : 50;
    }

    public static int ones(int...dices) {
        return filterAndSum(1, dices);
    }

    public static int twos(int... dices) {
        return filterAndSum(2, dices);
    }

    private static int filterAndSum(int value, int... dices) {
        return (int) (stream(dices).filter(dice -> dice == value).count() * value);
    }

    public static int threes(int... dices) {
        return filterAndSum(3, dices);
    }

    protected int[] dice;
    public Yatzy1() {}
    public Yatzy1(int... arr) {
        dice = new int[arr.length];
        int j = 0;
        for(int i: arr) {
            dice[j++] = i;
        }
    }

    public int fours() {
        return filterAndSum(4, dice);
    }

    public int fives() {
        return filterAndSum(5, dice);
    }

    public int sixes() {
        return filterAndSum(6, dice);
    }

    public int score_pair(int... args) {
        int[] counts = new int[6];
        for (int arg : args) {
            int index = arg-1;
            counts[index]++;
        }
        for (int i = counts.length -1; i >= 0; i--)
            if (counts[i] >= 2)
                return (i+1)*2;
        return 0;
    }

    public static int two_pair(int... args)
    {
        int[] counts = new int[6];
        for (int arg : args) {
            int index = arg-1;
            counts[index]++;
        }
        int n = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1)
            if (counts[6-i-1] >= 2) {
                n++;
                score += (6-i);
            }        
        if (n == 2)
            return score * 2;
        else
            return 0;
    }

    public static int four_of_a_kind(int _1, int _2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[6];
        tallies[_1-1]++;
        tallies[_2-1]++;
        tallies[d3-1]++;
        tallies[d4-1]++;
        tallies[d5-1]++;
        for (int i = 0; i < 6; i++)
            if (tallies[i] >= 4)
                return (i+1) * 4;
        return 0;
    }

    public static int three_of_a_kind(int d1, int d2, int d3, int d4, int d5)
    {
        int[] t;
        t = new int[6];
        t[d1-1]++;
        t[d2-1]++;
        t[d3-1]++;
        t[d4-1]++;
        t[d5-1]++;
        for (int i = 0; i < 6; i++)
            if (t[i] >= 3)
                return (i+1) * 3;
        return 0;
    }


    public static int smallStraight(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;
        if (tallies[0] == 1 &&
            tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1)
            return 15;
        return 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;
        if (tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1
            && tallies[5] == 1)
            return 20;
        return 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;




        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i+1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i+1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }
}



