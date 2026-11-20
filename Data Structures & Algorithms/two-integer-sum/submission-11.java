class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int targetDiff = target - nums[i];
            Integer targetIdx = map.get(targetDiff);
            if (targetIdx != null && targetIdx != i) {
                int[] result = new int[2];
                result[0] = Math.min(i, targetIdx);
                result[1] = Math.max(i, targetIdx);
                return result;
            }
        }

        return new int[0];
    }
}
