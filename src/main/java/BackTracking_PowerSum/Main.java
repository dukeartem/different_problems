package BackTracking_PowerSum;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int max = 1;
        int X = 10;
        int N = 2;
        ArrayList<Integer> simple = new ArrayList<>();

        for (int i = 1; i < X; i++) {
            if (Math.pow(i, N) > X) {
                break;
            }
            max = i;
            simple.add(i);
        }

        ArrayList<ArrayList<Integer>> permutationArr = new ArrayList<>();
        permutationArr.add(simple);

        System.out.println("max = " + max + " simpleArr = " + permutationArr.toString());

        System.out.println(recurce(10, 2, 1));
//        recurce(X, N, max, 1, 0, "");
//        for (int counter = 1; counter <= max; counter++) {
//            if (recurce(X, N, max, counter, 0, "", 0) == 1) {
//                System.out.println("got it X=" + X + " N=" + N + " max=" + max + " counter=" + counter);
//            } else {
//                System.out.println("return 0");
//            }
//        }

    }


    private static int recurce(int X, int N, int num) {
        if (Math.pow(num, N) < X) {
            return recurce(X, N, num + 1) + recurce(X - (int) Math.pow(num, N), N, num + 1);
        } else if ((int) Math.pow(num, N) == X) {
            return 1;
        } else {
            return 0;
        }
    }

}
