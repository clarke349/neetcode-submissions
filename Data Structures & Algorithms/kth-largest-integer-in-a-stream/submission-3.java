class KthLargest {

    Queue<Integer> minHeap;
    int k;

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);
        }
        this.k = k;
    }
    
    public int add(int val) {
        minHeap.add(val);
        while (minHeap.size() > this.k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
