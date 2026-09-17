class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int result = nums[0];

        // A rotated sorted array has one special property:
        // one part is always sorted, and the other part contains the rotation (and the minimum
        // element).
        //
        // If the left half is sorted, then the minimum cannot be there, so we search the right
        // half.
        //
        // If the right half is sorted, then the minimum must be in the left half (or at the
        // midpoint).
        while (l <= r) {
            // If the current window is already sorted, update the result
            // with the leftmost element and stop.
            if (nums[l] < nums[r]) {
                return Math.min(result, nums[l]);
            }

            int mid = l + (r - l) / 2;
            result = Math.min(result, nums[mid]);
            // If the left half is sorted, move search to the right half; otherwise,
            // search the left half.
            if (nums[mid] >= nums[l]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }
}
