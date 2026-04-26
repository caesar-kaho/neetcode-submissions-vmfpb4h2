class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int begin = 1;
        for (int num : nums) {
            if (num > 0 && begin == num) {
                begin++;
            }
        }

        return begin;
    }
}