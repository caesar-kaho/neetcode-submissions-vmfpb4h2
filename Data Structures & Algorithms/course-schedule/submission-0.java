class Solution {
    Map<Integer, List<Integer>> preMap = new HashMap<>();
    Set<Integer> visit = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }
        for (int[] prereq : prerequisites) {
            preMap.get(prereq[0]).add(prereq[1]);
        }

        for (int c = 0; c < numCourses; c ++) {
            if (!dfs(c)) {
                return false;
            }
        }

        return true;

    }

    private boolean dfs(int crs) {
        if (visit.contains(crs)) {
            return false;
        }

        if (preMap.get(crs).isEmpty()) {
            return true;
        }

        visit.add(crs);
        for (int pre: preMap.get(crs)) {
            if (!dfs(pre)) {
                return false;
            }
        }
        visit.remove(crs);
        preMap.put(crs, new ArrayList<>());
        return true;
    }
}
