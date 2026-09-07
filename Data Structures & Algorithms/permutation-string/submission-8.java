class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        Map<Character, Integer> m1 = new HashMap<>();
        for(int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            m1.put(c, m1.getOrDefault(c, 0) + 1);
        }

        int l = 0, r = s1.length() - 1;
        while(r < s2.length()) {
            // record character frequencies of characters in window
            Map<Character, Integer> m2 = new HashMap<>();
            for(int i = l; i <= r; i++) {
                char c = s2.charAt(i);
                m2.put(c, m2.getOrDefault(c, 0) + 1);
            }

            if (m1.equals(m2)) {
                return true;
            }

            // slide window to the right by one character in order to check
            // for permutations throughout the string.
            l++;
            r++;
        }

        return false;
    }
}
