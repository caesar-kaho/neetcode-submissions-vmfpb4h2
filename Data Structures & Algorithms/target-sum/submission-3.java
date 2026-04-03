class Solution {
    Map<String, Integer> cache;
    public int findTargetSumWays(int[] nums, int target) {
        
        cache = new HashMap<>();

        return dfs(nums, target, 0, 0);
    }


    private int dfs(int[] nums, int target, int sum, int i) {
        if (i == nums.length) {
            return sum == target ? 1 : 0;
        }

        String key = i + "-" + sum;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        int result = dfs(nums, target, sum + nums[i], i + 1) +  
                     dfs(nums, target, sum - nums[i], i + 1);   

        cache.put(key, result);

        return result;
    }
}
