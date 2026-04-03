class Solution {
    public int rob(int[] nums) {
        int[] a1 = Arrays.copyOfRange(nums, 1, nums.length);
        int[] a2 = Arrays.copyOfRange(nums, 0, nums.length - 1);

        if(nums.length == 1) return nums[0];
        
        return Math.max(dfs(a1), dfs(a2));
    }

    private int dfs(int[] nums) {
        int rob1 = 0, rob2 = 0;
        for (int num: nums) {
            int temp = Math.max(rob1 + num, rob2);
            rob1 = rob2;
            rob2 = temp;
        }

        return rob2;
    }

}
