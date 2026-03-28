package interview.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * ALGO QUESTION 2 — Two Sum
 *
 * Given an array of integers and a target value,
 * return the indices of the two numbers that add up to the target.
 *
 * You may assume exactly one solution exists.
 * You may NOT use the same element twice.
 *
 * Examples:
 *   nums = [2, 7, 11, 15], target = 9  → [0, 1]  (2 + 7 = 9)
 *   nums = [3, 2, 4],      target = 6  → [1, 2]  (2 + 4 = 6)
 *   nums = [3, 3],         target = 6  → [0, 1]
 *
 * Constraints:
 *   - O(n) time complexity expected — brute force O(n²) will not pass
 *   - What data structure gets you to O(n)?
 */
public class AlgoQuestion2 {

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (map.containsKey(need)) {
                return new int[]{map.get(need), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(java.util.Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));  // [0, 1]
        System.out.println(java.util.Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));        // [1, 2]
        System.out.println(java.util.Arrays.toString(twoSum(new int[]{3, 3}, 6)));           // [0, 1]
    }
}
