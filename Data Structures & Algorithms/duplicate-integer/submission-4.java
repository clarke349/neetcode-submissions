class Solution {
    public boolean hasDuplicate(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int currVal = nums[i];

            // check if the current value has already been seen
            // during our traversla of the array.
            if (set.contains(currVal)) {
                return true;
            }
            set.add(currVal);
        }
        return false;
    }
}