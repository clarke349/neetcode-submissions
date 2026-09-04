class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        // record character frequencies for s
        for (int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            int newVal = sMap.getOrDefault(c, 0) + 1;
            sMap.put(c, newVal);
        }

        // record character freqiencies for t
        for (int i = 0 ; i < t.length(); i++){
            char c = t.charAt(i);
            int newVal = tMap.getOrDefault(c, 0) + 1;
            tMap.put(c, newVal);
        }

        return sMap.equals(tMap);
    }
}
