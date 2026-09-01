class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < stones.length; i++) {
            maxHeap.add(stones[i]);
        }

        while (maxHeap.size() > 1) {
            int x = maxHeap.poll(); // stone 1
            int y = maxHeap.poll(); // stone 2
            int diff = x - y; // smash stones

            if (diff > 0) {
                maxHeap.add(diff);
            }
        }

        if (maxHeap.isEmpty()) {
            return 0;
        }
        
        return maxHeap.peek();
    }
}
