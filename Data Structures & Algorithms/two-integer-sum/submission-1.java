class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] output = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++){
            int diff = target - nums[i];

            if (map.containsKey(diff)) {
                int index = map.get(diff);
                output[0] = Math.min(i, index);
                output[1] = Math.max(i, index);
            }
        }

        return output;
    }
}
