class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> visited = new HashSet<>();
        return dfs(n, visited);
    }

    private boolean dfs(int n, HashSet<Integer> visited) {
        if(n == 1) {
            return true;
        }

        if(visited.contains(n)) {
            return false;
        }
        visited.add(n);

        int ans = 0;
        int[] digits = String.valueOf(n)
            .chars()
            .map(Character::getNumericValue)
            .toArray();

        for (int digit: digits) {
            ans += digit * digit;
        }
        
        return dfs(ans, visited);
    }
}
