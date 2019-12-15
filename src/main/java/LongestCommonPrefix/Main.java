package LongestCommonPrefix;

public class Main {

    private static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        int minimumLess = Integer.MAX_VALUE;
        for (int i=0; i<strs.length; i++) {
            if (strs[i].length() < minimumLess) {
                minimumLess = strs[i].length();
            }
        }

        boolean eq = true;
        for (int i=1; i<strs.length; i++) {
            if (!strs[i-1].equals(strs[i])) {
                eq = false;
            }
        }
        if (eq) {
            return strs[0];
        }

        int prefCount = 0;
        for (int i=0; i<minimumLess; i++) {
            eq = true;
            for (int j=1; j<strs.length; j++) {
                String str1 = strs[j-1];
                String str2 = strs[j];
                if (! str1.substring(0, i+1).equals(str2.substring(0, i+1))) {
                    eq = false;
                    break;
                }
            }
            if (eq) {
                prefCount++;
            } else {
                break;
            }
        }

        if (prefCount == 0) {
            return "";
        } else {
            return strs[0].substring(0, prefCount);
        }
    }

    public static void main(String[] args) {
        String[] t1 = new String[]{"aa", "a"};
        System.out.println(longestCommonPrefix(t1));

    }
}
