class Solution {
    public int[][] merge(int[][] intervals) {
        // Sort intervals in ascending order based starting interval
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] last = result.get(result.size() - 1); // the last interval added
            int[] current = intervals[i]; // current interval in our traversal

            // Merge if there is overlap
            if (current[0] <= last[1]) {
                last[0] = Math.min(current[0], last[0]);
                last[1] = Math.max(current[1], last[1]);
            } else {
                // Otherwise, append to list
                result.add(current);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
