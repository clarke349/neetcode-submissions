class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            int num = nums[m];
            if (num == target) return m;
            if (num > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return -1;
    }
}
