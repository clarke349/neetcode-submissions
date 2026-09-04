class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] output = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff) && i != map.get(diff)) {
                output[0] = i;
                output[1] = map.get(diff);

                // we have found the pair, so there is no reason to keep traversing
                break;
            }
        }
        return output;
    }
}
