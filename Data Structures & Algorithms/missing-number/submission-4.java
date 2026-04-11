class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int n = nums.length;
        for (int i = 0; i <= n; i ++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return -1;
    }
}
