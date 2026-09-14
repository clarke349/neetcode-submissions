class Solution {
    public int leastInterval(char[] tasks, int n) {
        // 1. Count how many times each task appears
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }

        // 2. Build a max-heap where each entry is "remaining count" of a task (the higher the
        // count, the higher its priority).
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int cnt : count) {
            if (cnt > 0) {
                maxHeap.add(cnt);
            }
        }

        // 3. Create an empty queue (FIFO) to store pairs: (remaining_count_after_running,
        // next_available_time).
        int time = 0;
        Queue<int[]> q = new ArrayDeque<>();

        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            time++;

            // If the heap is NOT empty, pop the task with the largest remaining count, and run it
            // once (remaining_count -= 1). If the remaining_count > 0, push (remaining_count, time
            // + n) into the cooldown queue (it can be used again after n units).
            //
            // We want to also check the front of the cooldown queue. While the task at the front
            // has next_available_time == time,
            // remove it from the queue and push its remaining_count back into the max-heap.
            if (maxHeap.isEmpty()) {
                time = q.peek()[1];
            } else {
                int cnt = maxHeap.poll() - 1;
                if (cnt > 0) {
                    q.add(new int[]{cnt, time + n});
                }
            }

            if (!q.isEmpty() && q.peek()[1] == time) {
                maxHeap.add(q.poll()[0]);
            }
        }

        return time;
    }
}
