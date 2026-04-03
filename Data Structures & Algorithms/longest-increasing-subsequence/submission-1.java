class Solution {
    int res;
    public int lengthOfLIS(int[] nums) {
        res = 1;

        for (int i = 0; i < nums.length; i ++) {
            dfs(nums, i, 1);
        }

        return res;
    }

    private void dfs(int[] nums, int i, int count) {
        if (i == nums.length) {
            return;
        }

        res = Math.max(res, count);

        for (int j = i + 1; j < nums.length; j ++) {
            if (nums[j] > nums[i]) {
                dfs(nums, j, count + 1);
            }
        }
    }
}
