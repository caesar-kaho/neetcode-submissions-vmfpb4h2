class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];
        int prod = 1;
        int zeroCount = 0;

        for (int i = 0; i < length ; i ++) {
            if (nums[i] == 0) {
                zeroCount++;
            }else {
                prod *= nums[i];
            }
        }

        if (zeroCount > 1) {
            return new int[length];
        }

            for (int i = 0; i < length; i ++) {
               if (zeroCount > 0) {
                ans[i] = (nums[i] == 0) ? prod : 0;
               }else {
                ans[i] = prod / nums[i];
               }
            }

        return ans;
    }
}  
