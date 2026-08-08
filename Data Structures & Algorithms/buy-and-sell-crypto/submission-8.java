class Solution {
    public int maxProfit(int[] prices) {
        int l = 0, r = 1, maxProfit = 0;
        
        while (r < prices.length) {
            int buy = prices[l];
            int sell = prices[r];
            int profit = sell - buy;
            if (prices[r] < buy) {
                l = r;
            }
            maxProfit = Math.max(profit, maxProfit);
            r++;
        }

        return maxProfit;
    }
}
