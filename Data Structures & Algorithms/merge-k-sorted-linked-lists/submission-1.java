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
    public static void insertValuesIntoPriorityQueue(ListNode[] lists, PriorityQueue<Integer> pq) {
        for (int i = 0; i < lists.length; i++) {
            ListNode lst = lists[i];
            while (lst != null) {
                pq.add(lst.val);
                lst = lst.next;
            }
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        insertValuesIntoPriorityQueue(lists, pq);

        ListNode dummyHead = new ListNode(-1);
        ListNode head = dummyHead;
        while (pq.size() > 0) {
            int val = pq.remove();
            ListNode newNode = new ListNode(val);
            dummyHead.next = newNode;
            dummyHead = dummyHead.next;
        }

        return head.next;
    }
}
