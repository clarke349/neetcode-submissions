class Solution {
    Map<Integer, List<Integer>> courseMap = new HashMap<>();
    Set<Integer> visiting = new HashSet<>();
    Set<Integer> processed = new HashSet<>();
    List<Integer> output = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Build graph mapping each course to its prerequisites
        for (int i = 0; i < numCourses; i++) {
            courseMap.put(i, new ArrayList<>());
        }
        for (int[] prereq : prerequisites) {
            courseMap.get(prereq[0]).add(prereq[1]);
        }

        // Run DFS on each course
        for (int c = 0; c < numCourses; c++) {
            if (!dfs(c)) {
                return new int[0];
            }
        }

        int[] result = new int[output.size()];
        for (int i = 0; i < output.size(); i++) {
            result[i] = output.get(i);
        }
        return result;
    }

    private boolean dfs(int course) {
        if (visiting.contains(course)) return false;
        if (processed.contains(course)) return true;

        visiting.add(course);
        for (int c : courseMap.get(course)) {
            if (!dfs(c)) {
                return false;
            }
        }
        visiting.remove(course);
        processed.add(course);
        output.add(course);

        return true;
    }
}
