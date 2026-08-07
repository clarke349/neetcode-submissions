class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int l = 0, r = 1;
        while (l < prices.length && r < prices.length){
            int buy = prices[l];
            int sell = prices[r];
            if (sell < buy) {
                l = r;
            }
            r++;
            maxProfit = Math.max(maxProfit, sell - buy);
        }

        return maxProfit;
    }
}
