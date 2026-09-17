class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int result = nums[0];

        while (l <= r) {
            // If the current window is already sorted, update the result
            // with the leftmost element and stop.
            if (nums[l] < nums[r]) {
                return Math.min(result, nums[l]);
            }

            int mid = l + (r - l) / 2;
            result = Math.min(result, nums[mid]);
            if (nums[mid] >= nums[l]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }
}
