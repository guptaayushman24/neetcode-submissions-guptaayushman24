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
    public ListNode reverseList(ListNode tempHead) {
        ListNode prev = null;
        ListNode curr = tempHead;
        while (curr != null) {
            ListNode front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;
        }

        return prev;
    }
    public void reorderList(ListNode head) {
        if (head==null){
            return;
        }

        if (head.next==null){
            return;
        }
        // Reverse the list and store the head of the reversed list
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. cut into two lists, then reverse ONLY the second half
        ListNode secondHalf = slow.next;
        slow.next = null;
        ListNode prev = reverseList(secondHalf);
        ListNode prevNext = prev.next;

        ListNode temp = head;
        ListNode tempNext = temp.next;

        while (prev != null) {
            tempNext = temp.next;
            prevNext = prev.next;

            temp.next = prev;
            prev.next = tempNext;

            temp = tempNext;
            prev = prevNext;
        }
    }
}
