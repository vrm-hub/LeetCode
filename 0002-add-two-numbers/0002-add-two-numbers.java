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
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0 ) {
            int val1, val2, val;
            if(l1 == null) {
                val1 = 0;
            } else {
                val1 = l1.val;
            }

            if(l2 == null) {
                val2 = 0;
            } else {
                val2 = l2.val;
            }

            val = val1 + val2 + carry;
            carry = val / 10;
            val = val % 10;

            curr.next = new ListNode(val);
            curr = curr.next;

            if(l1 == null) {
                l1 = null;
            } else {
                l1 = l1.next;
            }

            if(l2 == null) {
                l2 = null;
            } else {
                l2 = l2.next;
            }
        }

        return dummy.next;
    }
}