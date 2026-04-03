class Solution {

    public int findTargetSumWays(int[] nums, int target) {
        
        return dfs(nums, target, 0, 0);
    }


    private int dfs(int[] nums, int target, int sum, int i) {
        if (i == nums.length) {
            return sum == target ? 1 : 0;
        }

        return dfs(nums, target, sum + nums[i], i + 1) + dfs(nums, target, sum - nums[i], i + 1);
    }
}
