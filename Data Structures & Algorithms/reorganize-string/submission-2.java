class Solution {
    public String reorganizeString(String s) {
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }

        int maxCount = Arrays.stream(counts).max().getAsInt();
        if (maxCount > (s.length() + 1) / 2) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        while (result.length() < s.length()) {
            int maxIndex = findMaxIndex(counts);
            char maxChar = (char) (maxIndex + 'a');
            result.append(maxChar);
            counts[maxIndex]--;

            if (counts[maxIndex] == 0) {
                continue;
            }

            int tmp = counts[maxIndex];
            counts[maxIndex] = Integer.MIN_VALUE;
            int nextMaxIdx = findMaxIndex(counts);
            char nextMaxChar = (char) (nextMaxIdx + 'a');
            result.append(nextMaxChar);
            counts[maxIndex] = tmp;
            counts[nextMaxIdx]--;
        }
        return result.toString();
    }

    private int findMaxIndex(int[] counts) {
        int maxIndex = 0;
        for (int i = 1; i < counts.length; i++) {
            if (counts[i] > counts[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    } 
}