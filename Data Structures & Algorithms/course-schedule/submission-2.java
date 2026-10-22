class Solution {
    // Map each course to its prerequisites
    private Map<Integer, List<Integer>> map = new HashMap<>();

    // Store all courses along the current DFS path
    private Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] prereq : prerequisites) {
            map.get(prereq[0]).add(prereq[1]);
        }

        for (int c = 0; c < numCourses; c++) {
            if (!dfs(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int course) {
        if (visited.contains(course)) {
            // Cycle detected
            return false;
        }
        if (map.get(course).isEmpty()) {
            return true;
        }

        visited.add(course);
        for (int prerequisite : map.get(course)) {
            if (!dfs(prerequisite)) {
                return false;
            }
        }
        visited.remove(course);
        map.put(course, new ArrayList<>());
        return true;
    }
}
