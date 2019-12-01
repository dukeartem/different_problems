package BalancedStrings;

public class Main {


    private static int balancedStringSplit(String s) {
        StringBuilder accum = new StringBuilder();
        int count = 0;
        int countR = 0;
        int countL = 0;
        boolean firstTime = true;

        for (char c : s.toCharArray()) {
            String cs = String.valueOf(c);

            if (firstTime) {
                accum.append(cs);
                if (cs.equals("R")) {
                    countR++;
                } else {
                    countL++;
                }
                firstTime = false;
                continue;
            }

            if (cs.equals("R")) { // RR
                if (countR == countL) {
                    count++;
                    countL = 0;
                    System.out.println(accum);
                    accum = new StringBuilder("R");
                    countR = 1;
                } else {
                    accum.append(cs);
                    countR++;
                }
            } else if (cs.equals("L")) { // LL
                if (countR == countL) {
                    count++;
                    countR = 0;
                    System.out.println(accum);
                    accum = new StringBuilder("L");
                    countL = 1;
                } else {
                    accum.append(cs);
                    countL++;
                }
            }
        }

        if (countL == countR) {
            System.out.println(accum);
            count++;
        }

        return count;
    }


    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLRRLLRLRL"));
        System.out.println(balancedStringSplit("RLLLLRRRLR"));
        System.out.println(balancedStringSplit("LLLLRRRR"));
    }

}
