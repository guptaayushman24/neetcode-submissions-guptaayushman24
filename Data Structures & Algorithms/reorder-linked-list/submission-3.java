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
        List<ListNode> list1 = new ArrayList<>();
        List<ListNode> list2 = new ArrayList<>();
        List<ListNode> list = new ArrayList<>();

        ListNode temp = head;
        ListNode newTemp = head;
        ListNode prevHead = new ListNode(-1);
        ListNode newHead = prevHead;
        while (temp != null) {
            list1.add(temp);
            temp = temp.next;
        }

        for (int i = list1.size() - 1; i >= 0; i--) {
            list2.add(list1.get(i));
        }

        int size = list1.size();
        int len = size / 2;

        for (int i = 0; i < len; i++) {
            ListNode x = list1.get(i);
            ListNode y = list2.get(i);

            prevHead.next = x;
            prevHead = prevHead.next;
            prevHead.next = y;
            prevHead = prevHead.next;
        }

        if (size % 2 != 0) { // odd length: middle node goes last
            prevHead.next = list1.get(len);
            prevHead = prevHead.next;
        }

        prevHead.next = null;

        head = newHead.next;
    }
}
