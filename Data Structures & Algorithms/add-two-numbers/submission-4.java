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
        int sum = 0;
        int carry = 0;
        ListNode nn = new ListNode(-1);
        ListNode temp = nn;
        ListNode tempHead = nn;
        while (l1 != null && l2 != null) {
            int x = l1.val;
            int y = l2.val;
            if (x + y + carry < 10) {
                ListNode newNode = new ListNode(x + y + carry);
                temp.next = newNode;
                temp = temp.next;
                carry = 0;
            } else {
                ListNode newNode = new ListNode((x + y + carry) % 10);
                temp.next = newNode;
                temp = temp.next;
                carry = (x + y + carry) / 10;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int s = l1.val + carry; // <-- handle carry
            temp.next = new ListNode(s % 10);
            carry = s / 10;
            temp = temp.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int s = l2.val + carry;
            temp.next = new ListNode(s % 10);
            carry = s / 10;
            temp = temp.next;
            l2 = l2.next;
        }

        if (carry > 0) {
            ListNode newNode = new ListNode(carry);
            temp.next = newNode;
            temp = temp.next;
        }

        return tempHead.next;
    }
}