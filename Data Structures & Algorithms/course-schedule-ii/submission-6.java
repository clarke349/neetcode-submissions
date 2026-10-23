class Solution {
    private Map<Integer, List<Integer>> courseMap = new HashMap<>();
    private Set<Integer> visited = new HashSet<>(); // tracks cycles

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Build graph where each course points to its prerequisites
        for (int i = 0; i < numCourses; i++) {
            courseMap.put(i, new ArrayList<>());
        }
        for (int[] prereq : prerequisites) {
            courseMap.get(prereq[0]).add(prereq[1]);
        }

        // For each course, run DFS
        List<Integer> output = new ArrayList<>();
        Set<Integer> processed = new HashSet<>(); // tracks fully processed courses
        for (int c = 0; c < numCourses; c++) {
            if (!dfs(c, processed, output)) {
                return new int[0];
            }
        }

        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = output.get(i);
        }
        return result;
    }

    private boolean dfs(int course, Set<Integer> processed, List<Integer> output) {
        if (visited.contains(course))
            return false;
        if (processed.contains(course))
            return true;

        visited.add(course);
        for (int prereq : courseMap.get(course)) {
            if (!dfs(prereq, processed, output)) {
                return false;
            }
        }
        visited.remove(course);
        output.add(course);
        processed.add(course);

        return true;
    }
}
