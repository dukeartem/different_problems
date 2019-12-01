package permutations;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    /*
    new int[]{1, 2, 3} -> [[1, 2, 3], [2, 1, 3], [3, 1, 2]]
    new int[]{1, 2} -> [[1, 2], [2, 1]]
    new int[]{1} -> [[1]]
     */
    private static List<List<Integer>> permuteAdditional(ArrayList<Integer> numsList) {
        List<List<Integer>> accum = new ArrayList<>();

        if (numsList.size() == 1) {
            accum.add(new ArrayList<>(numsList));
            return accum;
        }

        for (int j = 0; j < numsList.size(); j++) {

            int tmpInt = numsList.get(0);
            numsList.set(0, numsList.get(j));
            numsList.set(j, tmpInt);

            accum.add(new ArrayList<>(numsList)); //базовый вариант [1, 2, 3]
            //вариант с откусанным значением
            //accum.add(new ArrayList<>(numsList.get(0))); //[1] тут лежит значение к которому мы должны приплюсовать варианты
            //пермутации с 1 по последний эллемент
            List<List<Integer>> otherPart = permuteAdditional(  //[2, 3], [2], [3]
                    new ArrayList<>(numsList.subList(1, numsList.size()))
            );

            for (List<Integer> part: otherPart) {
                part.add(numsList.get(0));
                accum.add(part);
            }

        }
        return accum;
    }

    private static List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        for (int num : nums) {
            integerArrayList.add(num);
        }
        return permuteAdditional(integerArrayList).stream().distinct().collect(Collectors.toList());
    }


    public static void main(String[] argc) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(permute(nums));
        int[] numstwo = new int[]{1, 2};
        System.out.println(permute(numstwo));
        int[] numsone = new int[]{1};
        System.out.println(permute(numsone));
//        int[] numsfour = new int[]{1,2,3,4};
//        System.out.println(permute(numsfour));
    }
}
