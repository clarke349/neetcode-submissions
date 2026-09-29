/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        // 1. Create a hash map oldToCopy, mapping each original node to its copied
        // node. Include null -> null for convenience.
        Map<Node, Node> oldToCopy = new HashMap<>();
        oldToCopy.put(null, null);

        // 2. First pass: iterate through the original list:
        // * Create a copy of each node.
        // * store mapping in oldToCopy
        Node current = head;
        while (current != null) {
            Node copy = new Node(current.val);
            oldToCopy.put(current, copy);
            current = current.next;
        }

        // 3. Second pass: iterate again
        // * Set copy.next using oldToCopy[original.next].
        // * Set copy.random using oldToCopy[original.random].
        current = head;
        while (current != null) {
            Node copy = oldToCopy.get(current);
            copy.next = oldToCopy.get(current.next);
            copy.random = oldToCopy.get(current.random);
            current = current.next;
        }

        return oldToCopy.get(head);
    }
}
