class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < stones.length; i++) {
            maxHeap.add(stones[i]);
        }

        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();
            int newStone = stone1 - stone2;

            if (newStone > 0) {
                maxHeap.add(newStone);
            }
        }

        if (maxHeap.isEmpty()) {
            return 0;
        }

        return maxHeap.poll();
    }
}
