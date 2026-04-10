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
        while (n > 0) {
            int digit = n % 10;
            ans += digit * digit;
            n /= 10;
        }

        return dfs(ans, visited);
    }
}
