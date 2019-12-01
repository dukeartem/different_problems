package BackTracking_Subsets;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    /* new int[]{1, 2, 3} ->
    [
      [1],
      [1, 2],
      [1, 2, 3],
      [1, 3],
      [2],
      [2, 3],
      [3],
      []
    ]
     */
    private static List<List<Integer>> permuteAdditional(List<Integer> numsList) {
        List<List<Integer>> accum = new ArrayList<>();

        if (numsList.size() == 1) {
            accum.add(new ArrayList<>());
            accum.add(numsList);
            return accum;
        }

        // добавляем полный набор данных
        accum.add(numsList);
        for (int i = 0; i < numsList.size(); i++) {
            // берём [i] эллемент, который потом иссключим из списка
            //accum.add(numsList.subList(i, i + 1));

            List<Integer> tmpList = new ArrayList<>(numsList);
            tmpList.remove(i);

            // оставшиеся данные отдаём в рекурсию
            accum.addAll(permuteAdditional(tmpList));
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
//        int[] numstwo = new int[]{1, 2};
//        System.out.println(permute(numstwo));
//        int[] numsone = new int[]{1};
//        System.out.println(permute(numsone));

        int[] numsfour = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 10, 0};

        Date startDate = new Date();
        permute(numsfour);
        Date end = new Date();
        long t = (end.getTime() - startDate.getTime()) / 1000;
        System.out.println("t = " + t + " seconds");

    }
}
