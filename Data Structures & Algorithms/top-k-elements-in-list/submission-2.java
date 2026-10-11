class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] output = new int[k];
        Map<Integer, Integer> map = new HashMap<>();

        // 1. Create map where each key is an integer
        // found in nums[] and the values are the
        // frequency of that integer.
        for (int i = 0; i < nums.length ; i++){
            int key = nums[i];
            if (map.containsKey(key)) {
                int newValue = map.get(key) + 1;
                map.put(key, newValue);
            } else {
                map.put(key, 1);
            }
        }

        // 2. Scan map k times to find the k most frequent elements.
        // Once we find the max of the current scan, we remove the
        // map entry before we start a new scan to find the next max.
        for (int i = 0; i < k ; i++) {
            int max = Integer.MIN_VALUE;
            int maxKey = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()){
                int key = entry.getKey();
                int value = entry.getValue();
                if (value > max) {
                    max = value;
                    maxKey = key;
                }
            }
            map.remove(maxKey);
            output[i] = maxKey;
        }

        return output;
        
    }
}
