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
    public static int findLenOfList(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }

        return len;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n == 1) {
            return null;
        }

        ListNode temp = head;
        int len = findLenOfList(head);

        if (len == n) {
            return head.next;
        }
        int nodeToBeDeleted = len - n;

        while (nodeToBeDeleted > 1) {
            temp = temp.next;
            nodeToBeDeleted--;
        }

        temp.next = temp.next.next;

        return head;
    }
}
