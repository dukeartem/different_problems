package ArrayPlusOne;

import static Utils.UsefulUtils.printArray;

public class Main {

    private static int[] plusOne(int[] digits) {
        int dec = 0;

        for (int i = digits.length - 1; i >= 0; i--) {
            //for other ellement(1,2,9->1,3,0)
            if ((i == 0) && (digits[i] + 1 > 9)) {
                digits[i] = 0;
                //crete array +1 size
                int[] tmpArray = digits;
                digits = new int[digits.length + 1];
                digits[0] = 1;
                for (int j = 0; j < tmpArray.length; j++) {
                    digits[j + 1] = tmpArray[j];
                }
                //for last ellement(1,2,3->1,2,3)
            } else if ((i == digits.length - 1) && (digits[i] + 1 > 9)) {
                dec = 1;
                digits[i] = 0;
                //for first ellement(9,9,9->1,0,0,0)
            } else {
                if (digits[i] + dec > 9) {
                    dec = 1;
                    digits[i] = 0;
                } else {
                    digits[i] += 1;
                    break;
                }
            }
        }

        printArray(digits);
        return digits;
    }

    public static void main(String[] args) {
        plusOne(new int[]{1, 2, 3});
        plusOne(new int[]{4, 3, 2, 1});
        plusOne(new int[]{9, 9, 9});
        plusOne(new int[]{8, 9, 9});
        plusOne(new int[]{9});
        plusOne(new int[]{1, 9});
    }
}
