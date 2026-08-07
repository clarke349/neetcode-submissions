class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 1, maxCount = 0;
        Set<Character> set = new HashSet<>();
        if (s.length() > 0) {
            maxCount++;
            int currentCount = 1;
            set.add(s.charAt(i));
            while (i < s.length() && j < s.length()) {
                if (set.contains(s.charAt(j))){
                    currentCount = 0;
                    i++;
                    j = i;
                    set.clear();
                }
                set.add(s.charAt(j));
                currentCount++;
                maxCount = Math.max(maxCount, currentCount);
                j++;
            }
        }

        return maxCount;
    }
}
