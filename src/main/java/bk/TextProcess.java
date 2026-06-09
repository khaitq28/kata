package bk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextProcess {


    public static void main(String[] args) {

        //algo 2 pointer

//        System.out.println("process(\"Bonjour, bonjour!! Test123 test.\") = " + process("Bonjour, bonjour!! Test123 test."));
//        System.out.println("process(\"Bonjour, je suis Laurent. Bonjour Laurent! Test123 test.\") = " + process("Bonjour, je suis Laurent. Bonjour Laurent! Test123 test."));
//        System.out.println(sqrt(2, 0.0001));

        System.out.println(leftRightDifference(new int[]{10, 4, 8, 3}));
    }

    public static int[] leftRightDifference(int[] arr) {
        /**
         l(i) = a(0) + ... a(i-1)
         r(j) = a(i+1) + .... a(n-1)
         l(i) - r(i) = a(0) + ... a(i-1) - a(i+1) - .... a(n-1)
         */
        int[] sum = new int[arr.length];
        int[] other = new int[arr.length];
        for (int i = 0; i < sum.length; i++) {
            sum[i] = arr[i] + (i == 0 ? 0: sum[i-1]);
        }
        for (int i = sum.length - 1; i >= 0; i--) {
            other[i] = arr[i] + (i == sum.length-1 ? 0: other[i+1]);
        }
        int[] ret = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            ret[i] = Math.abs( (i>0? sum[i-1]:0) - ( i+1 < arr.length ?  other[i+1]: 0) );
        }
        return ret;
    }

    private static double  sqrt(int n, double e) {
        double l = 1; double r = n;
        double ret = 0;
        while (l <= r && Math.abs(ret * ret - n) > e) {
            double m = l + (r -l)/2;
            double square = m * m;
            if (square > n) {
                r = m;
            } else {
                l = m;
                ret = m;
            }
        }
        return ret;
    }

    public static Map<String, Integer> fre(String s) {
        List<String> words = process(s);
        Map<String, Integer> freq = new HashMap<>();
        String mostLong = "";
        String mostFreq = "";
        int max  = 0;
        for (String word: words) {
            freq.put(word, freq.getOrDefault(word,0) + 1);
            if (word.length() > mostLong.length())
                mostLong = word;
            if (freq.get(word) > max) {
                max = freq.get(word);
                mostFreq = word;
            }
        }
        System.out.println("most Long = " + mostLong);
        System.out.println("most Freq = " + mostFreq);
        System.out.println(freq);
        return freq;
    }

    /**
     * Écrire un programme qui analyse une chaîne de caractères et extrait les informations suivantes :
     * le nombre total de mots ;
     * le mot le plus long ;
     * le mot le plus fréquent ;
     * le nombre d’occurrences de chaque mot.
     * Énoncé
     * On te donne une chaîne de caractères contenant :
     * des lettres ;
     * des chiffres ;
     * des espaces ;
     * des caractères spéciaux : ponctuation, tirets, virgules, points, etc.
     * Le programme doit extraire uniquement les mots composés de lettres.
     * Les chiffres et les caractères spéciaux doivent être considérés comme des séparateurs.
     * Le programme doit être insensible à la casse.
     *
     * "Bonjour, bonjour!! Test123 test."
     * doit être analysé comme :
     * bonjour
     * bonjour
     * test
     * test

     * Résultat attendu :
     * Nombre total de mots : 8
     * Mot le plus long : bonjour
     * Mot le plus fréquent : bonjour ou laurent ou test
     * Occurrences :
     * bonjour -> 2
     * je -> 1
     * suis -> 1
     * laurent -> 2
     * test -> 2
     */

    public static List<String> process(String s) {
        List<String> result = new ArrayList<>();
        char[] arr = s.toCharArray();
        int i = 0;
        while (i < arr.length) {
            while (i < arr.length && !Character.isAlphabetic(arr[i])) {
                i++;
            }
            if (i == arr.length) break;
            int j = i;
            while (Character.isAlphabetic(arr[j]))
                j++;
            result.add(s.substring(i,j).toLowerCase());
            i = j;
        }
        return result;
    }
}
