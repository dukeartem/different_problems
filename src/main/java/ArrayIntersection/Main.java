package ArrayIntersection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Main {


    private static int[] intersect(int[] nums1, int[] nums2) {
        HashSet<Integer> nums1HashSet = Arrays.stream(nums1).boxed().collect(Collectors.toCollection(HashSet::new));
        HashSet<Integer> nums2HashSet = Arrays.stream(nums2).boxed().collect(Collectors.toCollection(HashSet::new));

        if (nums1HashSet.size() < nums2HashSet.size()) {
            HashSet<Integer> tmpHashSet = nums2HashSet;
            nums2HashSet = nums1HashSet;
            nums1HashSet = tmpHashSet;
        }

        ArrayList<Integer> res = new ArrayList<>();

        for (Integer e : nums2HashSet) {
            if (nums1HashSet.contains(e)) {
                res.add(e);
            }
        }

        return res.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] argc) {
        intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2}); //[2]
        intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}); //[9, 4]
    }


}
