package org.codingdojo.yatzy2;

import org.codingdojo.YatzyCalculator;
import org.codingdojo.YatzyCategory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class Yatzy2 implements YatzyCalculator {
    static final List<Integer> DICE_VALUES = Arrays.asList(6, 5, 4, 3, 2, 1);


    @Override
    public List<String> validCategories() {
        return Stream.of(YatzyCategory.values()).map(Enum::toString).toList();
    }

    private int highestScoreOfFrequency(HashMap<Integer, Integer> diceFrequencies, int frequency) {
        for (int i : DICE_VALUES) {
            if (diceFrequencies.getOrDefault(i, Integer.MIN_VALUE) >= frequency) {
                return i * frequency;
            }
        }
        return 0;
    }

    private int sumItemsWithFrequency(HashMap<Integer, Integer> diceFrequencies, int value) {
        return  diceFrequencies.getOrDefault(value,0) * value;
    }
    @Override
    public int score(List<Integer> dice, String categoryName) {
        YatzyCategory category = YatzyCategory.valueOf(categoryName);

        // calculate dice frequencies
        HashMap<Integer, Integer> diceFrequencies = new HashMap<>();
        for (int die : dice) {
            diceFrequencies.put(die, diceFrequencies.getOrDefault(die,0) + 1);
        }

        // calculate the score
        int result;
        switch (category) {
            case CHANCE:
                // chance sums the dice
                result = dice.stream().mapToInt(Integer::intValue).sum();
                break;
            case YATZY:
                // score for yatzy if all dice are the same
                return (diceFrequencies.containsValue(5)) ? 50: 0;
            case ONES:
                // sum all the ones
                return sumItemsWithFrequency(diceFrequencies, 1);
            case TWOS:
                // sum all the twos
                return sumItemsWithFrequency(diceFrequencies, 2);
            case THREES:
                // sum all the threes
                return sumItemsWithFrequency(diceFrequencies, 3);
            case FOURS:
                // sum all the fours
                return sumItemsWithFrequency(diceFrequencies, 4);
            case FIVES:
                // sum all the fives
                return sumItemsWithFrequency(diceFrequencies, 5);
            case SIXES:
                // sum all the sixes
                return sumItemsWithFrequency(diceFrequencies, 6);
            case PAIR:
                // score pair if two dice are the same
                // score highest pair if there is more than one
                return highestScoreOfFrequency(diceFrequencies, 2);
            case THREE_OF_A_KIND:
                // score if three dice are the same
                return highestScoreOfFrequency(diceFrequencies, 3);
            case FOUR_OF_A_KIND:
                // score if four dice are the same
                return highestScoreOfFrequency(diceFrequencies, 4);

            case SMALL_STRAIGHT:
                // score if dice contains 1,2,3,4,5
                int smallStraightResult = 0;
                long count = 0L;
                for (Integer frequency : diceFrequencies.values()) {
                    if (frequency == 1) {
                        count++;
                    }
                }
                if (count == 5 && diceFrequencies.getOrDefault(6,0) == 0) {
                    for (Integer die : dice) {
                        smallStraightResult += die;
                    }
                }
                result = smallStraightResult;
                break;

            case LARGE_STRAIGHT:
                // score if dice contains 2,3,4,5,6
                int largeStraightResult = 0;
                long straightCount = 0L;
                for (Integer frequency : diceFrequencies.values()) {
                    if (frequency == 1) {
                        straightCount++;
                    }
                }
                if (straightCount == 5 && diceFrequencies.getOrDefault(1,0) == 0) {
                    for (Integer die : dice) {
                        largeStraightResult += die;
                    }
                }
                result = largeStraightResult;
                break;

            case TWO_PAIRS:

                // score if there are two pairs
                int twoPairResult = 0;
                long pairCount = 0L;
                for (Integer frequency : diceFrequencies.values()) {
                    if (frequency >= 2) {
                        pairCount++;
                    }
                }
                if (pairCount == 2) {
                    for (int i : DICE_VALUES) {
                        if (diceFrequencies.getOrDefault(i,0) >= 2) {
                            twoPairResult += i * 2;
                        }
                    }
                }
                result = twoPairResult;
                break;

            case FULL_HOUSE:

                // score if there is a pair as well as three of a kind
                int fullHouseResult = 0;
                if (diceFrequencies.containsValue(2) && diceFrequencies.containsValue(3)) {
                    for (Integer die : dice) {
                        fullHouseResult += die;
                    }
                }
                result = fullHouseResult;
                break;

            default:
                result = 0;
        }
        return result;
    }

}

