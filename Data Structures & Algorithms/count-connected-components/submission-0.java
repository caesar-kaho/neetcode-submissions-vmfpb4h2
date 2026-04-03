class Solution {
    Map<Integer, List<Integer>> nodeMap = new HashMap<>();

    public int countComponents(int n, int[][] edges) {
        boolean[] visit = new boolean[n];

        for (int i = 0; i < n; i ++) {
            nodeMap.put(i, new ArrayList<>());
        }

        for (int[] edge: edges) {
            nodeMap.get(edge[0]).add(edge[1]);
            nodeMap.get(edge[1]).add(edge[0]);
        }
        
        int res = 0;
        for (int node = 0; node < n; node ++) {
            if (!visit[node]) {
                dfs(visit, node);
                res++;
            }
        }

        return res;
    }

    private void dfs(boolean[] visit, int node) {
        visit[node] = true;

        for(int nei: nodeMap.get(node)) {
            if (!visit[nei]) {
                dfs(visit, nei);
            }
        }
    }
}
