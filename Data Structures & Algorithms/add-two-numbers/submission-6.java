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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();

        ListNode p0 = result; // pointer to traverse result;
        ListNode p1 = l1; // pointer to traverse l1
        ListNode p2 = l2; // pointer to traverse l2

        int remainder = 0; // keeps track of remainder / carryover after integr addition.
        while (p1 != null && p2 != null) {
            // caluclate new digit for our node
            int num1 = p1.val;
            int num2 = p2.val;
            int newDigit = num1 + num2 + remainder;
            remainder = 0;
            if (newDigit > 9) {
                newDigit -= 10;
                remainder = 1;
            }

            p0.val = newDigit;
            if (p1.next != null || p2.next != null || remainder > 0) {
                p0.next = new ListNode();
            }

            p0 = p0.next;
            p1 = p1.next;
            p2 = p2.next;
        }

        while (p1 != null) {
            int newDigit = p1.val + remainder;
            remainder = 0;
            if (newDigit > 9) {
                newDigit -= 10;
                remainder = 1;
            }

            p0.val = newDigit;
            if (p1.next != null) {
                p0.next = new ListNode();
            } else if (p1.next == null && remainder > 0) {
                p0.next = new ListNode(remainder);
                remainder = 0;
            }
            p1 = p1.next;
            p0 = p0.next;
        }

        while (p2 != null) {
            int newDigit = p2.val + remainder;
            remainder = 0;
            if (newDigit > 9) {
                newDigit -= 10;
                remainder = 1;
            }

            p0.val = newDigit;
            if (p2.next != null) {
                p0.next = new ListNode();
            } else if (p2.next == null && remainder > 0) {
                p0.next = new ListNode(remainder);
                remainder = 0;
            }
            p2 = p2.next;
            p0 = p0.next;
        }

        if (remainder > 0) {
            p0.val = remainder;
        }

        return result;
    }
}
