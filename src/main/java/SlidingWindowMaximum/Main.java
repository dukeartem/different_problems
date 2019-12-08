package SlidingWindowMaximum;

import java.util.Arrays;

import static Utils.UsefulUtils.printArray;

public class Main {

    private static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[]{};
        }

        int[] res = new int[nums.length - k + 1];
        int resSeek = 0;

        for (int i = 0; i < nums.length - k + 1; i++) {
            res[resSeek] = Arrays.stream(Arrays.copyOfRange(nums, i, k + i)).max().getAsInt();
            resSeek++;
        }

        return res;
    }

    public static void main(String[] argc) {
        int[] o = maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3); //Output: [3,3,5,5,6,7]
        printArray(o);
        o = maxSlidingWindow(new int[]{}, 0); //Output: []
        printArray(o);
        o = maxSlidingWindow(new int[]{1}, 1); //Output: [1]
        printArray(o);

    }
}
