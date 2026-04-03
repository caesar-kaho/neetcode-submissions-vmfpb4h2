class Solution {
    Set<Integer> visited = new HashSet<>();
    Map<Integer, List<Integer>> nodeMap = new HashMap<>();

    public boolean validTree(int n, int[][] edges) {

        for (int i = 0; i < n; i ++) {
            nodeMap.put(i, new ArrayList<>());
        }

        for (int[] edge: edges) {
            nodeMap.get(edge[0]).add(edge[1]);
            nodeMap.get(edge[1]).add(edge[0]);
        }

        if(!dfs(0, -1)) {
            return false;
        }

        return visited.size() == n;
    }

    private boolean dfs (int node, int parent) {
        if(visited.contains(node)) {
            return false;
        }

        visited.add(node);
        for (int nei: nodeMap.get(node)) {
            if(nei == parent) {
                continue;
            }

            if(!dfs(nei, node)) {
                return false;
            }
        }
        
        return true;
    }
}
