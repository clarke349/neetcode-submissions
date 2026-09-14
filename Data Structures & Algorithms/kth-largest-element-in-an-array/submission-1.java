class Solution {
    public int findKthLargest(int[] nums, int k) {
        int result = nums[0];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
        }

        int i = 0;
        while (!maxHeap.isEmpty() && i < k) {
            result = maxHeap.poll();
            i++;
        }

        return result;
    }
}
