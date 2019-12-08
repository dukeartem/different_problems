package BestTimeToBuyAndSell;

import java.util.Arrays;

public class Main {

    private static int maxProfit(int[] prices) {
        int profit = 0;

        if (prices.length <= 1) {
            return profit;
        }

        int buyPrice = prices[0]; //1
        int max = 0;

        profit = Math.max(profit, prices[1] - buyPrice); //profit //5-1=4, 3-1=2, 6-1=5, 4-1=3 => 5
        max = Math.max(max, maxProfit(Arrays.copyOfRange(prices, 1, prices.length))); //profit from other part of array

        return profit + max;
    }

    public static void main(String[] argc) {

        /*Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3. */
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4})); // 7
        /*Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.*/
        System.out.println(maxProfit(new int[]{1,2,3,4,5})); // 4
        /*In this case, no transaction is done, i.e. max profit = 0.*/
        System.out.println(maxProfit(new int[]{7,6,4,3,1})); // 0
    }
}
