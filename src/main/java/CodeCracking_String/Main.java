package CodeCracking_String;

import java.util.HashMap;

public class Main {

    // Given two strings, write a method to decide if one is a permutation of the other.
    private static boolean checkIfIsPermutation(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();

        for (int i = 0; i < s1Chars.length; i++) {
            for (int j = 0; j < s2Chars.length; j++) {
                if (s1Chars[i] == s2Chars[j]) {
                    s2Chars[j] = '\000';
                    break;
                }
            }
        }

        for (int i = 0; i < s2Chars.length; i++) {
            if (s2Chars[i] != '\000') {
                return false;
            }
        }

        return true;
    }
    private static void mainPermutation() {
        System.out.println(checkIfIsPermutation("abc", "cba"));   //true
        System.out.println(checkIfIsPermutation("abcd", "cba"));  //false
        System.out.println(checkIfIsPermutation("bcd", "cba"));   //false
        System.out.println(checkIfIsPermutation("aabb", "bbaa")); //true
        System.out.println(checkIfIsPermutation("aa", "aa"));     //true
        System.out.println(checkIfIsPermutation("abab", "baba")); //true
        System.out.println(checkIfIsPermutation("bb", "bc"));     //false
        System.out.println(checkIfIsPermutation("bc", "bb"));     //false
        System.out.println(checkIfIsPermutation("bcbcb", "bbccb"));     //true
    }

    // Given a string, write a function to check if it is a permutation of a palindrome.
    private static boolean checkIfIsPermutationAndPalindrome(String s1) {

        if (s1.length() < 2) {
            return false;
        }

        char[] s1CharArr = s1.toCharArray();
        HashMap<Character, Integer> charCountMap = new HashMap<>();

        for (int i = 0; i < s1CharArr.length; i++) {
            char lowerCapital = Character.toLowerCase(s1CharArr[i]);

            if (Character.isAlphabetic(lowerCapital)) {

                if (charCountMap.containsKey(lowerCapital)) {
                    charCountMap.put(lowerCapital, charCountMap.get(lowerCapital) + 1);
                } else {
                    charCountMap.put(lowerCapital, 1);
                }
            }
        }

        int oddCount = 0;
        for (Character c: charCountMap.keySet()) {
            if (charCountMap.get(c) % 2 != 0) {
                oddCount++;
            }
        }

        return oddCount <= 1;
    }
    private static void mainPermutationAndPalindrome() {
        System.out.println(checkIfIsPermutationAndPalindrome("Tact Coa"));      //True
        System.out.println(checkIfIsPermutationAndPalindrome("tactcoapapa"));   //True
        System.out.println(checkIfIsPermutationAndPalindrome("abbcba"));        //False
        System.out.println(checkIfIsPermutationAndPalindrome("abbba"));         //True
        System.out.println(checkIfIsPermutationAndPalindrome("abcba"));         //True
        System.out.println(checkIfIsPermutationAndPalindrome("abbac"));         //True
        System.out.println(checkIfIsPermutationAndPalindrome("dbbac"));         //False
    }

    public static void main(String[] argc) {
        mainPermutation();
        System.out.println("==================================");
        mainPermutationAndPalindrome();


    }

}
