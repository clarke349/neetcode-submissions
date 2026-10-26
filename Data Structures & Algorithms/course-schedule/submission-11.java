class Solution {
    private Map<Integer, List<Integer>> courseMap = new HashMap<>();
    private Set<Integer> visiting = new HashSet<>();
    private Set<Integer> processed = new HashSet<>(); // tracks fully processed courses

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
        if (visiting.contains(course)) return false; // cycle detected
        if (processed.contains(course)) return true;

        visiting.add(course);
        for (int c : courseMap.get(course)) {
            if (!dfs(c)) {
                return false;
            }
        }
        visiting.remove(course);
        processed.add(course);

        return true;
    }
}
