class Solution {
    private Map<Integer, List<Integer>> courseMap = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Build graph where each course points to its prerequisites
        for (int i = 0; i < numCourses; i++) {
            courseMap.put(i, new ArrayList<>());
        }
        for (int[] prereq : prerequisites) {
            courseMap.get(prereq[0]).add(prereq[1]);
        }

        // For each course, run DFS
        for (int c = 0; c < numCourses; c++) {
            if (!dfs(c)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int course) {
        if (visited.contains(course)) return false;
        if (courseMap.get(course).isEmpty()) return true;
        
        visited.add(course);
        for (int prereq : courseMap.get(course)) {
            if (!dfs(prereq)) {
                return false;
            }
        }
        visited.remove(course);
        courseMap.put(course, new ArrayList<>());

        return true;
    }
}
