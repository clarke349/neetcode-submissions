class LRUCache {
    private static class Node {
        int key; // needed on eviction: tells us which key to remove from the map
        int val; // what get() returns
        Node prev, next; // doubly linked list can unink itself in O(1) time
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map = new HashMap<>();

    // real nodes sit between dummy nodes
    private final Node head = new Node(0, 0); // dummy: most recent used side
    private final Node tail = new Node(0, 0); // dummy: least recent used side
    

    public LRUCache(int capacity) {
        this.capacity = capacity;

        // start with empty list
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;
        remove(node);
        insertFront(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);

        // Case 1: key already exists -> update value, mark as most recent.
        // No eviction needed because the size doesn't change.
        if (node != null) {
            node.val = value;
            remove(node);
            insertFront(node);
            return;
        }

        // Case 2: new key and cache is full -> evict the least recently used.
        if (map.size() == capacity) {
            Node lru = tail.prev;   // the node right before tail is the oldest
            remove(lru);            // take it out of the list
            map.remove(lru.key);    // take it out of the map (this is why Node stores key)
        }

        // Case 3: add the new key as most recent.
        Node fresh = new Node(key, value);
        map.put(key, fresh);
        insertFront(fresh);
    }

    // Unlink a node from wherever it is in the list.
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Insert a node right after head (the most recent position).
    // Ordr matters: set new nodes position firts, then the neighn]bors.
    private void insertFront(Node node) {
        node.next = head.next; // new node points to old first node
        node.prev = head; // new node prev points back to head
        head.next.prev = node; // old node prev is now new node
        head.next = node; // head not points to most recently used/added node.
    }
}
