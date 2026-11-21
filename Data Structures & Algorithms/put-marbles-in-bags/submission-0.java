class Solution {
    public long putMarbles(int[] weights, int k) {
        if (k == 1) return 0L; // only one bag, no choices to make

        // 1. Create an array of all adjacent pair sums
        int n = weights.length;
        List<Integer> splits = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            splits.add(weights[i] + weights[i + 1]);
        }

        // 2. sort the array
        Collections.sort(splits);

        // 3. Sum the smallest 'k-1' values for the minimum score.
        // 4. Sum the largest 'k-1' values for the maximum score.
        int m = k - 1;
        long minScore = 0;
        long maxScore = 0;
        for (int i = 0; i < m; i++) {
            minScore += splits.get(i);
        }
        for(int i = splits.size() - m; i < splits.size(); i++) {
            maxScore += splits.get(i);
        }

        // 5. Return the difference
        return maxScore - minScore;
    }
}