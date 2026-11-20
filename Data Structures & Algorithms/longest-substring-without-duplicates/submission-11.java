class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        int result = 0;
        int l = 0, r = 0;
        Set<Character> seen = new HashSet<>();
        while (r < s.length()) {
            while (seen.contains(s.charAt(r))) {
                seen.remove(s.charAt(l));
                l++;
            }
            seen.add(s.charAt(r));
            result = Math.max(result, r - l + 1);
            r++;
        }
        
        return result;
    }
}
