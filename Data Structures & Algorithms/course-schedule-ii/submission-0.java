class Solution {
    Map<Integer, List<Integer>> preMap = new HashMap<>();
    List<Integer> output = new ArrayList<>();
    Set<Integer> visit = new HashSet<>();
    Set<Integer> cycle = new HashSet<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        for (int i = 0; i < numCourses; i ++) {
            preMap.put(i, new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            preMap.get(pre[0]).add(pre[1]);
        }

        for (int course = 0; course < numCourses; course ++) {
            if (!dfs(course)) {
                return new int[0];
            }
        }

        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i ++) {
            result[i] = output.get(i);
        }

        return result;
    }

    private boolean dfs (int course) {

        if (cycle.contains(course)) {
            return false;
        }

        if (visit.contains(course)) {
            return true;
        }

        cycle.add(course);
        for (int pre: preMap.getOrDefault(course, Collections.emptyList())) {
            if (!dfs(pre)) {
                return false;
            }
        }
        cycle.remove(course);
        visit.add(course);
        output.add(course);
        return true;
    }
}
