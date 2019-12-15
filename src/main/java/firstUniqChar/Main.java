package firstUniqChar;

import java.util.HashMap;

public class Main {
    private static int firstUniqChar(String s) {
        if (s.length() == 0) {
            return -1;
        }
        if (s.length() == 1) {
            return 0;
        }
        char[] charArray = s.toCharArray();
        HashMap<Character, Integer> charCountMap = new HashMap<>();

        for (int i = 0; i < charArray.length; i++) {
            charCountMap.put(
                    charArray[i],
                    charCountMap.getOrDefault(charArray[i], 0) + 1
            );
        }

        for (int i = 0; i < charArray.length; i++) {
            if (charCountMap.get(charArray[i]) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));      // 0
        System.out.println(firstUniqChar("loveleetcode"));  // 2
        System.out.println(firstUniqChar("z"));             // 0
        System.out.println(firstUniqChar("cc"));            // -1
    }
}
