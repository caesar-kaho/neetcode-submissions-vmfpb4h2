class Solution {
    int[] memo;
    public int lengthOfLIS(int[] nums) {
        memo = new int[nums.length];

        int res = 1;

        for (int i = 0; i < nums.length; i ++) {
            res = Math.max(res, dfs(nums, i));
        }

        return res;
    }

    private int dfs(int[] nums, int i) {
        if (memo[i] != 0) {
            return memo[i];
        }

        int count = 1;

        for (int j = i + 1; j < nums.length; j ++) {
            if (nums[j] > nums[i]) {
               count = Math.max(count, 1 + dfs(nums, j));
            }
        }

        return memo[i] = count;
    }
}
