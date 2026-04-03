class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<int[]> freq = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: count.entrySet()) {
            freq.add(new int[]{entry.getValue(), entry.getKey()});
        }

        freq.sort((a,b) -> b[0] - a[0]);

        int[] ans = new int[k];

        for (int i = 0; i < k; i ++) {
            ans[i] = freq.get(i)[1];
        }

        return ans;
    }
}
