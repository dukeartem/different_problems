package reverseInt;

public class Main {
    private static int reverse(int x) {
        if (x == 0) {
           return 0;
        }

        char[] charX = String.valueOf(Math.abs(x)).toCharArray();

        int negative = 1;
        int endPosition = charX.length - 1;
        if (x<0) {
            negative = -1;
        }

        for(int i=0; i<=endPosition/2; i++) {
            char tmp = charX[i];
            charX[i] = charX[charX.length - i - 1];
            charX[charX.length - i - 1] = tmp;
        }

        try {
            return Integer.parseInt(String.valueOf(charX)) * negative;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

//    private static int reverse(int x) {
//        long n=x;
//        long newX=0;
//        while(n!=0){
//            long q=n/10;
//            long r=n%10;
//            n=q;
//            newX=newX*10+r;
//
//        }
//        if(newX<Integer.MIN_VALUE || newX>Integer.MAX_VALUE){
//            return 0;
//        }
//        return (int) newX;
//    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
        System.out.println(reverse(123));  // 321
        System.out.println(reverse(-123)); // -321
        System.out.println(reverse(120));  // 21
    }
}
