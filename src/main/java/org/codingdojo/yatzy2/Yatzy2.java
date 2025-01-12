package org.codingdojo.yatzy2;

import org.codingdojo.YatzyCalculator;
import org.codingdojo.YatzyCategory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Yatzy2 implements YatzyCalculator {
    static final List<Integer> DICE_VALUES = Arrays.asList(6, 5, 4, 3, 2, 1);


    @Override
    public List<String> validCategories() {
        return Arrays.stream(YatzyCategory.values()).map(Enum::toString).collect(Collectors.toList());
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
                return diceFrequencies.get(1);
            case TWOS:
                // sum all the twos
                return diceFrequencies.get(2) * 2;
            case THREES:
                // sum all the threes
                return diceFrequencies.get(3) * 3;
            case FOURS:
                // sum all the fours
                return diceFrequencies.get(4) * 4;
            case FIVES:
                // sum all the fives
                return diceFrequencies.get(5) * 5;
            case SIXES:
                // sum all the sixes
                return diceFrequencies.get(6) * 6;
            case PAIR:
                // score pair if two dice are the same
                // score highest pair if there is more than one
                for (int i : DICE_VALUES) {
                    if (diceFrequencies.get(i) >= 2) {
                        return  i * 2;
                    }
                }
                return 0;

            case THREE_OF_A_KIND:
                // score if three dice are the same
                for (int i : DICE_VALUES) {
                    if (diceFrequencies.get(i) >= 3) {
                        return i * 3;
                    }
                }
                return 0;

            case FOUR_OF_A_KIND:
                // score if four dice are the same
                for (int i : DICE_VALUES) {
                    if (diceFrequencies.get(i) >= 4) {
                        return i * 4;
                    }
                }
                return 0;

            case SMALL_STRAIGHT:
                // score if dice contains 1,2,3,4,5
                int smallStraightResult = 0;
                long count = 0L;
                for (Integer frequency : diceFrequencies.values()) {
                    if (frequency == 1) {
                        count++;
                    }
                }
                if (count == 5 && diceFrequencies.get(6) == 0) {
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
                if (straightCount == 5 && diceFrequencies.get(1) == 0) {
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
                        if (diceFrequencies.get(i) >= 2) {
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

