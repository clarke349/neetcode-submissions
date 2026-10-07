class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> result = new ArrayList<>();
        int i = 0;

        // Intervals completely before newInterval. These do not overlap, so we can add them
        // directly to the result.
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Intervals that overlap with newInterval. While there is overlap, we merge them by
        // expanding newInterval.
        // new start = minimum of starts
        // new end = maximum of ends
        while (i < n && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        result.add(newInterval);

        // Intervals completely after the merged newInterval.
        // These also do not overlap, so we add them directly.
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
