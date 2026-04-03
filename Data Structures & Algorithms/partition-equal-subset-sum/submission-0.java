class Solution {
    public boolean canPartition(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int total = Arrays.stream(nums).sum();
        if (total % 2 != 0) {
            return false;
        }
        int target = total / 2;

        set.add(0);

        for (int num : nums) {
            Set<Integer> nextDp = new HashSet<>();
            for (int setNum : set) {
                if (setNum + num == target) {
                    return true;
                }

                nextDp.add(setNum + num);
                nextDp.add(setNum);
            } 

            set = nextDp;
        }


        return set.contains(target);
    }
}
