class Solution {
    public int longestConsecutive(int[] nums) {
        // handle empty arrray
        if (nums.length == 0) return 0;
        // sort
        Arrays.sort(nums);

        int longestStreak = 1;
        int currentStreak = 1;

        for (int i = 1; i < nums.length; i ++) {
            // skip duplicate
            if (nums[i - 1] == nums[i]) continue; 

            if (nums[i - 1] + 1 == nums[i]) {
                currentStreak++;
            }else {
                longestStreak = Math.max(longestStreak, currentStreak);
                // Start new streak
                currentStreak = 1;
            }
        }

        return Math.max(longestStreak, currentStreak);
    }
}
