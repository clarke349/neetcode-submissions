class Solution {
    public int[][] merge(int[][] intervals) {
        // Sort intervals in ascending order by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        int n = intervals.length;
        int i = 0;

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            int[] lastAddedInterval = result.get(result.size() - 1);
            int lastEnd = lastAddedInterval[1];

            // If interval overlap with last added interval, merge / extend the intervals
            if (start <= lastEnd) {
                lastAddedInterval[1] = Math.max(lastAddedInterval[1], end);
            } else {
                result.add(interval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
