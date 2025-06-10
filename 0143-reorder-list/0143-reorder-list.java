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
    public void reorderList(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode secondList = slow.next;
        ListNode prev = slow.next = null;
        while(secondList != null) {
            ListNode temp = secondList.next;
            secondList.next = prev;
            prev = secondList;
            secondList = temp;
        }

        ListNode firstList = head;
        secondList = prev;

        while(secondList != null) {
            ListNode tmp1 = firstList.next;
            ListNode tmp2 = secondList.next;
            firstList.next = secondList;
            secondList.next = tmp1;
            firstList = tmp1;
            secondList = tmp2;
        }
    }
}
