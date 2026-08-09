class Solution {
    Map<String, List<String>> map = new HashMap<>();

    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            builder.append(strs.get(i));
        }
        String key = builder.toString();
        map.put(key, strs);

        return key;
    }

    public List<String> decode(String str) {
        return map.get(str);
    }
}
