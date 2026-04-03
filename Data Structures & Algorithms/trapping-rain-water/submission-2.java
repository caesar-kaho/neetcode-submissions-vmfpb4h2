class Solution {
    public int trap(int[] height) {
        int maxLeft = 0;
        int maxRight = 0;
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left < right) {
            maxLeft = Math.max(maxLeft, height[left]);
            maxRight = Math.max(maxRight, height[right]);
            int waterLevel = 0;

            if (maxLeft < maxRight){
                waterLevel = maxLeft - height[left];
                left++;
            }else {
                waterLevel = maxRight - height[right];
                right--;
            }

            if (waterLevel > 0) {
                res += waterLevel;
            }
        }

        return res;
    }
}
