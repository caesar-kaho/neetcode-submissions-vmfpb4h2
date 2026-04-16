class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < s.length(); i ++) {
            lastIndex.put(s.charAt(i), i);
        }

        int size = 0, end = 0;
        for (int i = 0; i < s.length(); i ++) {
            size++;
            end = Math.max(end, lastIndex.get(s.charAt(i)));

            if (i == end) {
                res.add(size);
                size = 0;
            }
        }
        return res;
    }
}
