class HitCounter {
    // Two parallel arrays with one slot per second of the 300-second window.
    // Slot i holds the data for any timestamp where timestamp % 300 == i.
    //   times[i] = which actual second this slot currently holds
    //   hits[i]  = how many hits happened during that second
    // Because the window is only 300 seconds, two timestamps that share a slot
    // (like 5 and 305) can never both be in the window at once. So each slot
    // only needs to remember the most recent second that landed in it.
    private final int[] times;
    private final int[] hits;

    public HitCounter() {
        times = new int[300];
        hits = new int[300];
    }
    
    public void hit(int timestamp) {
        int i = timestamp % 300; // the slot this timestamp maps to
        
        // The slot may still hold an old second from a previous lap around the
        // buffer (e.g. second 5 when we're now at 305). That data is at least
        // 300 seconds old, so it's expired: overwrite the slot and reset its count.
        if (times[i] != timestamp) {
            times[i] = timestamp;
            hits[i] = 0;
        }

        // Count this hit. Multiple hits in the same second share one slot,
        // so memory stays fixed however heavy the traffic gets.
        hits[i]++;
    }
    
    public int getHits(int timestamp) {
        int totalHits = 0;

        // Check all 300 slots. A slot only counts if the second it holds is
        // inside the window (timestamp - 300, timestamp]:
        //   timestamp - times[i] < 300  means it happened less than 300 seconds ago.
        // Slots holding stale seconds (never overwritten because no hit came
        // in on their lap) fail this check and are skipped, so we never need
        // to clean them up.
        for (int i = 0; i < 300; i++) {
            int age = timestamp - times[i]; // how long ago those hits happened
            if (age < 300) { // still inside the 5-minute window
                totalHits += hits[i];
            }
        }

        return totalHits;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
