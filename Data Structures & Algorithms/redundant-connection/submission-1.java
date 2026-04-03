class Solution {

    Map<Integer, List<Integer>> graph = new HashMap<>();

    public int[] findRedundantConnection(int[][] edges) {

        for (int i = 1; i <= edges.length; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {

            Set<Integer> visited = new HashSet<>();

            if (dfs(edge[0], edge[1], visited)) {
                return edge;
            }

            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        return new int[0];
    }

    private boolean dfs(int src, int target, Set<Integer> visited) {

        if (src == target) return true;

        visited.add(src);

        for (int nei : graph.get(src)) {

            if (visited.contains(nei)) continue;

            if (dfs(nei, target, visited)) {
                return true;
            }
        }

        return false;
    }
}