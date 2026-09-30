class LRUCache {

    int capacity;
    Map<Integer, Integer> cache;
    Deque<Integer> keyStack;

    public LRUCache(int capacity) {
        this.capacity = capacity;
         cache = new HashMap<>();
         keyStack = new ArrayDeque<>();
    }
    
    public int get(int key) {
        int result = -1;
        if (cache.containsKey(key)) {
            keyStack.remove(key);
            keyStack.push(key);
            result = cache.get(key);
        }
        return result;
    }
    
    public void put(int key, int value) {
        if (cache.size() == capacity && !cache.containsKey(key)) {
            // Adding the key-value pair will mke the size of
            // the cache exceed capacity. Therefore we must remove
            // the LRU key.
            int keytoRemove = keyStack.pollLast(); // retrieve bottom of stack
            cache.remove(keytoRemove);
        }
        keyStack.remove(key);
        keyStack.push(key);
        cache.put(key, value);
    }
}
