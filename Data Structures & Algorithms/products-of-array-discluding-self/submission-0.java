class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];

        for (int i = 0 ; i < length; i ++) {
            int prod = 1;
            for (int j = 0; j < length; j ++) {
                if (i != j) {
                    prod *= nums[j];
                }
            }

            ans[i] = prod;
        }

        return ans;
    }
}  
