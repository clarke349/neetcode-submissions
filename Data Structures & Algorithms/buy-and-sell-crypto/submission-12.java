class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int l = 0, r = 1;
        while (r < prices.length) {
            int buy = prices[l];
            int sell = prices[r];
            int profit = sell - buy;
            max = Math.max(max, profit);

            if (sell < buy) {
                l = r;
            }
            r++;
        }
        return max;
    }
}
