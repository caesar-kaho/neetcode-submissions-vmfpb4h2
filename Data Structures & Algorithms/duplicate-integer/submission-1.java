class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> map = new HashSet<>();
        for (int num : nums) map.add(num);
        if(map.size() < nums.length) {
            return true;
        }

        return false;
    }
}