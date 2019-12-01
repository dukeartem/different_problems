package BackTracking_LetterCasePermutation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static List<String> mainPermutation(char[] charArr, int index) {
        List<String> accum = new ArrayList<>();

        for (int i = index; i < charArr.length; i++) {
            index++;

            if (Character.isDigit(charArr[i])) {
                accum.add(String.valueOf(charArr));
                continue;
            }

            char saveChar = charArr[i];
            charArr[i] = Character.toUpperCase(charArr[i]);
            accum.add(String.valueOf(charArr));
            accum.addAll(mainPermutation(charArr, index));

            charArr[i] = Character.toLowerCase(charArr[i]);
            accum.add(String.valueOf(charArr));
            accum.addAll(mainPermutation(charArr, index));

            charArr[i] = saveChar;
        }

        return accum;
    }

    private static List<String> letterCasePermutation(String S) {
        return mainPermutation(S.toCharArray(), 0).stream().distinct().collect(Collectors.toList());
    }

    public static void main(String[] argc) {
        String s1 = "a1b2";
        System.out.println(letterCasePermutation(s1));
//        String s2 = "3z4";
//        System.out.println(letterCasePermutation(s2));
//        String s3 = "12345";
//        System.out.println(letterCasePermutation(s3));
//        String s4 = "Jw";
//        System.out.println(letterCasePermutation(s4));


        Date startDate = new Date();
        String s5 = "XxIozBFY67bV";
        System.out.println(letterCasePermutation(s5));
        Date end = new Date();
        double t = (end.getTime() - startDate.getTime()) / 1000.0;
        System.out.println("t = " + t + " seconds");

    }
}
