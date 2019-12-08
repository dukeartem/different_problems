package ArrayIntersectionII;

import java.util.Arrays;
import java.util.HashMap;

public class Main {

//    private static int[] intersect(int[] nums1, int[] nums2) {
//
//        if(nums1.length > nums2.length){
//            return intersect(nums2, nums1);
//        }
//        HashMap<Integer, Integer> m = new HashMap<>();
//        for(int n : nums1){
//            m.put(n, m.getOrDefault(n, 0)+1);
//        }
//        int k =0;
//        for(int n: nums2){
//            int cnt =m.getOrDefault(n, 0);
//            if(cnt > 0){
//                nums1[k++] = n;
//                m.put(n, cnt-1);
//            }
//        }
//
//        return Arrays.copyOfRange(nums1, 0, k);
//    }

    private static int[] intersect(int[] nums1, int[] nums2) {

        //nums1 must be bigger than nums2
        if (nums1.length < nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }

        boolean[] map = new boolean[nums1.length];
        int intersectionCount = 0;

        for (int i = 0; i < nums2.length; i++) {
            for (int j = 0; j < nums1.length; j++) {
                if ((nums2[i] == nums1[j]) && (!map[j])) {
                    map[j] = true;
                    intersectionCount++;
                    break;
                }
            }
        }

        int[] res = new int[intersectionCount];
        int position = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i]) {
                res[position] = nums1[i];
                position++;
            }
        }

        return res;
    }

    public static void main(String[] argc) {
        intersect(new int[]{1, 2, 2, 1}, new int[]{3, 2, 2}); //[2, 2]
        intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}); //[4, 9]
        intersect(new int[]{1, 2, 2, 1, 3, 3}, new int[]{4, 4, 2, 2}); //[2, 2]
    }

}
