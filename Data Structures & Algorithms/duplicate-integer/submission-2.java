class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> duplicate = new HashSet<>();
        for (int num : nums) {
            duplicate.add(num);
        }
        return duplicate.size() != nums.length;
    }
}