package missingNumbers;

import java.util.Arrays;

public class Main {

    private static int[] removeArrayElemment(int[] arr, int index) {
        int[] resArray = new int[arr.length - 1];
        int c = 0;
        for (int i = 0; i <= arr.length - 1; i++) {
            if (i == index) {
                continue;
            }
            resArray[c] = arr[i];
            c++;
        }

        return resArray;
    }

    private static int[] addArrayElemment(int[] arr, int ellement) {
        int[] resArray = new int[arr.length + 1];

        System.arraycopy(arr, 0, resArray, 0, arr.length - 1 + 1);
        resArray[resArray.length - 1] = ellement;

        return resArray;
    }

    private static int[] missingNumbers(int[] arr, int[] brr) {
        int[] falseFindArray = new int[0];

        for (int i = 0; i <= arr.length - 1; i++) {
            boolean falseFind = true;
            for (int j = 0; j <= brr.length - 1; j++) {
                if (arr[i] == brr[j]) {
                    brr = removeArrayElemment(brr, j);
                    falseFind = false;
                    break;
                }
            }
            if (falseFind) {
                falseFindArray = addArrayElemment(falseFindArray, arr[i]);
            }
        }
        for (int ell : falseFindArray) {
            brr = addArrayElemment(brr, ell);
        }
        Arrays.sort(brr);
        return Arrays.stream(brr).distinct().toArray();
    }


    public static void main(String[] args) {
        int[] arr = new int[]{203, 204, 205, 206, 207, 208, 203, 204, 205, 206};
        int[] brr = new int[]{203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204};
        for (int i : missingNumbers(arr, brr)) {
            System.out.println(i);
        }
    }
}