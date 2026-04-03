class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();

        for (String s: strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedS = new String(charArray);

            ans.putIfAbsent(sortedS, new ArrayList<>());
            ans.get(sortedS).add(s);
        }

        return new ArrayList<>(ans.values());
    }
}
