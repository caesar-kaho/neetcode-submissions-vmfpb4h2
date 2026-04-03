class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, new ArrayList<>(), 0, 0);
        return res;
    }

    private void backtrack(int[] candidates, int target, List<Integer> curr, int total, int i) {
        if (total == target) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if (total > target || i == candidates.length) {
            return;
        }

        // include
        curr.add(candidates[i]);
        backtrack(candidates, target, curr, total + candidates[i], i + 1);
        curr.remove(curr.size() - 1);
        // exclude
        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i += 1;
        }
        backtrack(candidates, target, curr, total, i + 1);
    }
}
