package RotateArray;

import java.util.Arrays;

import static Utils.UsefulUtils.printArray;

public class Main {

    private static void rotate(int[] nums, int k) {

        for (int m = 0; m < k; m++) {
            int lastElement = nums[nums.length - 1];
            int firstElement = nums[0];


            for (int i = 0; i < nums.length; i++) {
                if (i == nums.length - 1) {
                    nums[0] = lastElement;
                    break;
                }
                int tmp = nums[i + 1];
                nums[i + 1] = firstElement;
                firstElement = tmp;
            }
        }
        printArray(nums);

    }

    private static void rotateTwo(int[] nums, int k) {
        int[] tail = Arrays.copyOfRange(nums, nums.length - k, nums.length);
        int[] head = Arrays.copyOfRange(nums, 0, nums.length - k);

        int i = 0;
        while (i < tail.length) {
            nums[i] = tail[i];
            i++;
        }

        int m = 0;
        while (m < head.length) {
            nums[m + i] = head[m];
            m++;
        }

        printArray(nums);
    }

    public static void main(String[] argc) {
        rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3); // [5,6,7,1,2,3,4]
        rotate(new int[]{-1, -100, 3, 99}, 2); // [3,99,-1,-100]

    }
}
