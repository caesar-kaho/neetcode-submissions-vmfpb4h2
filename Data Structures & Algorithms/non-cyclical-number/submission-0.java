class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> visited = new HashSet<>();
        return dfs(n, visited);
    }

    private boolean dfs(int n, HashSet<Integer> visited) {
        if(visited.contains(n)) {
            return false;
        }
        int ans = 0;
            if(n == 1) {
                return true;
            }
                int[] digits = String.valueOf(n)
                     .chars()
                     .map(Character::getNumericValue)
                     .toArray();
                for (int digit: digits) {
                    ans += digit * digit;
                }
                visited.add(n);

        return dfs(ans, visited);
    }
}
