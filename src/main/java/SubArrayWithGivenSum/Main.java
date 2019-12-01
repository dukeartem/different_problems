package SubArrayWithGivenSum;

import java.util.*;

public class Main {

    public static void main(String[] argc) {

        /*
        Example:
            Input:
                2
                5 12
                1 2 3 7 5
                10 15
                1 2 3 4 5 6 7 8 9 10
            Output:
                2 4
                1 5
         */
        int[] intsOne = new int[]{1, 2, 3, 7, 5};
        int needSumOne = 12;
        System.out.println(findArrayWithGivenSum(intsOne, needSumOne, 0));

        int[] intsTwo = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int needSumTwo = 15;
        System.out.println(findArrayWithGivenSum(intsTwo, needSumTwo, 0));
    }

    private static List<Integer> findArrayWithGivenSum(int[] intsOne, int needSum, int deep) {
        List<Integer> resPosition = new ArrayList<>();
        deep++;

        //{1, 2, 3, 7, 5} and 12
        /*
        1
        1+2=3 < 12
        1+2+3=6 < 12
        1+2+3+7=13 > 12 -> break

        2+3=5 < 12
        2+3+7 = 12 -> return [1,3] -> [2, 4]
         */
        int foundSum = 0;
        for (int i = 0; i < intsOne.length; i++) {
            foundSum += intsOne[i];

            if (foundSum == needSum) {
                resPosition.clear();
                resPosition.add(deep);
                resPosition.add(i+deep);
                return resPosition;
            }

            if (i + 1 < intsOne.length) {
                resPosition.addAll(findArrayWithGivenSum(
                        Arrays.copyOfRange(intsOne, i + 1, intsOne.length),
                        needSum, deep));
            }

            if (foundSum > needSum) {
                break;
            }

        }

        if (resPosition.size() < 2) {
            resPosition.add(-1);
            return resPosition;
        }
        return resPosition.subList(0 , 2);
    }

}
