class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Double> minHeap = new PriorityQueue<>();
        int ROWS = points.length;
        double[][] distances = new double[ROWS][3];

        // Calculate distance from origin for each point
        // and map it to each point.
        for (int r = 0; r < ROWS; r++) {
            int x = points[r][0];
            int y = points[r][1];
            double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
            distances[r][0] = x;
            distances[r][1] = y;
            distances[r][2] = distance;
        }

        // Sort distances array in ascending order based on
        // the distances.
        Arrays.sort(distances, (row1, row2) -> Double.compare(row1[2], row2[2]));

        // Return the closest k points
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i][0] = (int) distances[i][0];
            result[i][1] = (int) distances[i][1];
        }
        return result;
    }
}
