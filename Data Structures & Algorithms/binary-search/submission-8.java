class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int num = nums[mid];

            if (num == target) {
                return mid;
            } else if (num < target){
                left = mid + 1; // Discard left half
            } else{
                right = mid - 1; // Discard right half
            }
        }
        return -1;
    }
}
