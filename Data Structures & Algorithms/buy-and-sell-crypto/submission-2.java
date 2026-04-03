class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0; // Not possible to make a profit.
        }

        int left = 0; // Pointer for the buying day
        int right = 1; // Pointer for the selling day
        int maxProfit = 0;

        while (right < prices.length) {
            // Is it a profitable transaction?
            if (prices[left] < prices[right]) {
                int currentProfit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, currentProfit);
            } else {
                // We found a new, lower price to buy at.
                // This is a better buying opportunity, so move our buy pointer here.
                left = right;
            }
            
            // Always move the sell pointer to explore the next day.
            right++;
        }

        return maxProfit;
    }
}