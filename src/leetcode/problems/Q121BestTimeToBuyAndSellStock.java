package leetcode.problems;

import java.util.Arrays;

public class Q121BestTimeToBuyAndSellStock implements Problem {

    /**
     * You are given an array prices where prices[i] is the price of a given stock on the ith day.
     * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
     **/

    private int[] prices;

    public Q121BestTimeToBuyAndSellStock() {
        this.prices = new int[] {7,1,5,3,6,4};
    }

    public Q121BestTimeToBuyAndSellStock(int[] prices) {
        this.prices = prices;
    }


    public int solve(){

        // solution O(n^2)
//        int largest = 0;
//        for (int i=0; i<prices.length; i++){
//            for (int j=i; j<prices.length; j++) {
//                int diff = prices[j]-prices[i];
//                if (diff > largest)
//                    largest = diff;
//            }
//        }
//        return largest;

        // solution O(n)
//        int lgDiff = 0;
//        int lgVal = Integer.MIN_VALUE;
//        for (int i=prices.length-1; i>=0; i--) {
//            if (prices[i] > lgVal)
//                lgVal=prices[i];
//            if (lgVal-prices[i] > lgDiff)
//                lgDiff = lgVal-prices[i];
//        }
//        return lgDiff;

        // solution (Attempt Kadane's Algo): if given difference instead of price
        // a = {1,7,4,11} => b = {0,6,-3,7}
        // b[0] = 0,
        // b[1..n] = b[i]-b[i-1]
        // max = a3-a0 = b1+b2+b3
        // hence, we can use kadane's algo
        int curSequence = 0;
        int maxSequence = 0;

        for (int i=1; i<prices.length; i++)
        {
            curSequence = Math.max(0, curSequence+prices[i]-prices[i-1]);
            maxSequence = Math.max(curSequence, maxSequence);
        }
        return maxSequence;
    }

    @Override
    public void printAnswer() {
        System.out.println("Inputs: " + Arrays.toString(prices));
        System.out.println("Answer: " + solve());
    }
}
