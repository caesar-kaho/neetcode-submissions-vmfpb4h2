class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int profit = 0;
        int n = prices.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                profit = prices[j] - prices[i];
                res = Math.max(res, profit);
            }
        }

        return res;
    }
}
