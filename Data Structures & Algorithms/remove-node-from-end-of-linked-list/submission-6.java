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
    public static int findLenOfList(ListNode temp) {
        int x = 0;
        while (temp != null) {
            temp = temp.next;
            x++;
        }

        return x;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n == 1) {
            return null;
        }
        ListNode temp = head;
        int len = findLenOfList(temp);

        int nodeToBeDeleted = len - n;

        if (len == n) {
            return head.next;
        }
        int x = 0;
        while (x != nodeToBeDeleted - 1) {
            temp = temp.next;
            x++;
        }

        temp.next = temp.next.next;

        return head;
    }
}
