package RemoveDuplicateFromArray;

public class Main {

    private static int removeDuplicates(int[] nums) {
        int seek = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[seek] != nums[i]) {
                seek++;
                nums[seek] = nums[i];
            }
        }

        return seek+1;
    }

    public static void main(String[] argc) {

        System.out.println(removeDuplicates(new int[]{1,1,2})); // -> 2 (it's new length without duplicate)
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4})); //-> 5

    }
}
