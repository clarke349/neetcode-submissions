class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();

        // Sort Intervals in ascending order
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        result.add(intervals[0]);
        for (int[] interval : intervals) {
            int[] lastInterval = result.get(result.size() - 1);

            // if intervals overlap, merge them
            if (lastInterval[1] >= interval[0]) {
                lastInterval[1] = Math.max(lastInterval[1], interval[1]);
            } else {
                result.add(interval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
