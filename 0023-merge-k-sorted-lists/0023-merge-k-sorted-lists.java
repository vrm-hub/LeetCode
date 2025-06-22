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
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode curr = head;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
                curr = curr.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
                curr = curr.next;
            }
        }

        if(l1 != null) {
            curr.next = l1;
            l1 = l1.next;
            curr = curr.next;
        }

        if(l2 != null) {
            curr.next = l2;
            l2 = l2.next;
            curr = curr.next;
        }

        return head.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = lists.length == 0 ? null : lists[0];

        for(int i = 1; i < lists.length; i++) {
            res = merge(res, lists[i]);
        }

        return res;
    }
}