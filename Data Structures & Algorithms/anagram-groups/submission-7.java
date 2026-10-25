class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];

            // Character frequency array for current String.
            // Words are anagrams if they have identical character
            // frequency arrays.
            int[] freq = new int[26];
            for (char c : s.toCharArray()) {
                freq[c - 'a']++;
            }

            String key = Arrays.toString(freq);
            groups.putIfAbsent(key, new ArrayList<>());
            groups.get(key).add(s);
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : groups.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }
}
