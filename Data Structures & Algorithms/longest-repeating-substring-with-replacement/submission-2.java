class Solution {
    public int characterReplacement(String s, int k) {
        int result = 0;
        int l = 0;
        Map<Character, Integer> freq = new HashMap<>();

        for (int r = 0 ; r < s.length(); r++) {
            freq.put(s.charAt(r), freq.getOrDefault(s.charAt(r), 0) + 1);

            // Ensure that the current window is valid before we update the result.
            int windowLength = r - l + 1; // window length
            int mostFreqChar = Collections.max(freq.values()); // most frequent character count
            while(windowLength - mostFreqChar > k) {
                freq.put(s.charAt(l), freq.getOrDefault(s.charAt(l), 0) - 1);
                l++;
                windowLength = r - l + 1;
                mostFreqChar = Collections.max(freq.values());
            }

            result = Math.max(result, windowLength);
        }
        return result;
    }
}
