class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 1)
            return 0;

        int l = 0, r = 1;
        int longest = 1;
        int count = 1;
        Set<Character> seen = new HashSet<>();
        seen.add(s.charAt(0));
        while (r < s.length()) {
            char c = s.charAt(r);
            if (seen.contains(c)) {
                count = 0;
                seen.clear();
                l++;
                r = l;
            }
            count++;
            seen.add(s.charAt(r));
            r++;
            longest = Math.max(count, longest);
        }

        return longest;
    }
}
