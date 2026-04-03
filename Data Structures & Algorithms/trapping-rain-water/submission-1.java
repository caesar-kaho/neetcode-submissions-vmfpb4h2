class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int n = height.length;
        int res = 0;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        // 1. Calculate the maximum height from the left for each position
        maxLeft[0] = height[0];
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
        }

        // 2. Calculate the maximum height from the right for each position
        maxRight[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(height[i], maxRight[i + 1]);
        }
        
        // 3. Calculate the trapped water at each position
        for (int i = 0; i < n; i++) {
            // The water level is the minimum of the left and right walls
            int waterLevel = Math.min(maxLeft[i], maxRight[i]);
            // The trapped water is the water level minus the bar's height
            res += waterLevel - height[i];
        }

        return res;
    }
}