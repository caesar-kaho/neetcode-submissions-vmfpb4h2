class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // A boolean array to keep track of which numbers have been used in the current path.
        boolean[] used = new boolean[nums.length];
        
        dfs(nums, new ArrayList<>(), res, used);
        
        return res;
    }

    private void dfs(int[] nums, List<Integer> currentPermutation, List<List<Integer>> res, boolean[] used) {
        // Base Case: If the current permutation is the same size as the input array,
        // we have a complete permutation.
        if (currentPermutation.size() == nums.length) {
            // Add a *copy* of the permutation to the results.
            res.add(new ArrayList<>(currentPermutation));
            return;
        }

        // Iterate through ALL numbers for every position.
        for (int i = 0; i < nums.length; i++) {
            // If the number at index 'i' has already been used in this path, skip it.
            if (used[i]) {
                continue;
            }

            // CHOOSE: Add the number to our current path and mark it as used.
            currentPermutation.add(nums[i]);
            used[i] = true;

            // EXPLORE: Recursively call dfs to build the rest of the permutation.
            dfs(nums, currentPermutation, res, used);

            // UN-CHOOSE (Backtrack): Remove the number and un-mark it as used
            // so it can be used in different positions in other permutations.
            currentPermutation.remove(currentPermutation.size() - 1);
            used[i] = false;
        }
    }
}