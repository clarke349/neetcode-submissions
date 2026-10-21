class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int j = i + 1;

            // tracks nummber of days after ith day before a warmer temp appears
            int count = 0; 

            while (j < n) {
                count++;
                if (temperatures[j] > temperatures[i]) {
                    break;
                }
                j++;

                // Did not find a warmer day, so set count to zero
                if ((j == n) && temperatures[n - 1] <= temperatures[i]) {
                    count = 0;
                }
            }
            result[i] = count;
        }

        return result;
    }
}
