package RomanToInteger;

import java.util.HashMap;

public class Main {

    private static int romanToInt(String s) {
        HashMap<String, Integer> translateTable = new HashMap<>();
        translateTable.put("I", 1);
        translateTable.put("V", 5);
        translateTable.put("X", 10);
        translateTable.put("L", 50);
        translateTable.put("C", 100);
        translateTable.put("D", 500);
        translateTable.put("M", 1000);
        translateTable.put("IV", 4);
        translateTable.put("IX", 9);
        translateTable.put("XL", 40);
        translateTable.put("XC", 90);
        translateTable.put("CD", 400);
        translateTable.put("CM", 900);

        char[] chars = s.toCharArray();
        int sum = 0;
        for (int i = 0; i <= chars.length - 1; i++) {
            if (i == chars.length - 1) {
                sum += translateTable.get(String.valueOf(chars[i]));
            } else if (translateTable.get(
                    String.valueOf(chars[i]) + chars[i + 1]
            ) != null) {
                sum += translateTable.get(String.valueOf(chars[i]) + chars[i + 1]);
                i++;
            } else {
                sum += translateTable.get(String.valueOf(chars[i]));
            }
        }

        return sum;
    }


    public static void main(String[] argc) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }
}
