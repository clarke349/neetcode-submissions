/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 1. find the size (number of nodes) in the list.
        int size = 0;
        ListNode current = head;
        while (current != null) {
            size++;
            current = current.next;
        }

        // 2. the nth node from the end of the list is equivalent to
        // the [size - n]th node from the beginning. So when traversing
        // our list, we can get to our target node by traversing
        // [size - n] times from the beginning.
        ListNode target = head;
        ListNode prev = null;
        int k = 0;
        while (target != null && k < (size - n)) {
            prev = target;
            target = target.next;
            k++;
        }

        // 3. Now that we have the target node, we remove it. To do this, we must keep track of the
        // previous node and store a reference to the next node. After this, we make the previous
        // node point to the reference of the next node, and make the current node point to null.
        if (prev != null) {
            prev.next = target.next;
            target.next = null;
        } else {
            // prev is only null if we are removing the first node.
            head = head.next;
        }

        return head;
    }
}
