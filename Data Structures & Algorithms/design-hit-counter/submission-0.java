class HitCounter {

    TreeMap<Integer, Integer> treeMap;

    public HitCounter() {
        treeMap = new TreeMap<>();
    }
    
    public void hit(int timestamp) {
        treeMap.put(timestamp, treeMap.getOrDefault(timestamp, 0) + 1);
    }
    
    public int getHits(int timestamp) {
        int totalHits = 0;
        SortedMap<Integer, Integer> subMap = treeMap.subMap(timestamp - 300, false, timestamp, true); // (t - 300, t]
        for (Map.Entry<Integer, Integer> entry : subMap.entrySet()) {
            totalHits += entry.getValue();
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
