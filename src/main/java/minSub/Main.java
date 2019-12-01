package minSub;

public class Main {


    //минимальное возможное произведение пары эллементов послеовательности
    public static void main(String[] argc) {
        System.out.println(findMinPosled(new int[]{9, 4, 2, 5, 3}));
        System.out.println(findMinPosled(new int[]{9, 4}));
        System.out.println(findMinPosled(new int[]{-1, 9, 4, -1, 8}));
    }

    private static int findMinPosled(int[] posled) {
        if (posled.length < 2) {
            return -1;
        } else if (posled.length == 2) {
            return posled[0] + posled[1];
        }

        int res = posled[0] + posled[1];
        for (int i = 1; i < posled.length - 1; i++) {
            int sum = posled[i] + posled[i + 1];
            if (sum < res) {
                res = sum;
            }
        }

        return res;
    }
}
