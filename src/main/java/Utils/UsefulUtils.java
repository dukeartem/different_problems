package Utils;

public class UsefulUtils {
    public static void printArray(int[] nums) {
        System.out.print("[");
        for (int n=0; n<nums.length; n++) {
            if (n == nums.length-1) {
                System.out.print(nums[n]);
            } else {
                System.out.print(nums[n] + ",");
            }
        }
        System.out.println("]");
    }
}
