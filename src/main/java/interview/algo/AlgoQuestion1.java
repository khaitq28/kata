package interview.algo;

/**
 * ALGO QUESTION 1 — First Non-Repeating Character
 *
 * Given a string, find the first character that does not repeat.
 * Return the character. If all characters repeat, return '#'.
 *
 * Examples:
 *   "aabbcde"  → 'c'
 *   "aabb"     → '#'
 *   "abcabc"   → '#'
 *   "swiss"    → 'w'
 *
 * Constraints:
 *   - String contains only lowercase letters
 *   - O(n) time complexity expected
 *   - O(1) space — there are only 26 possible characters
 */
public class AlgoQuestion1 {

    public static char firstNonRepeating(String s) {

        int[] arr = new int[26];
        for (char c: s.toCharArray()) {
            arr[c - 'a'] ++;
        }
        for (char c: s.toCharArray()) {
            if (arr[c - 'a'] == 1) {
                return c;
            }
        }
        return '#';
    }

    public static void main(String[] args) {
        System.out.println(firstNonRepeating("aabbcde")); // c
        System.out.println(firstNonRepeating("aabbxf"));    // x
        System.out.println(firstNonRepeating("abcabc"));  // #
        System.out.println(firstNonRepeating("swiss"));   // w
    }
}
