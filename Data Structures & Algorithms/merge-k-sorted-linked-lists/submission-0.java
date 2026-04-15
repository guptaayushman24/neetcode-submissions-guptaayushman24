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
    public void storeValueInPriorityQueue (ListNode x,PriorityQueue<Integer> pq){
        while (x!=null){
            pq.add(x.val);
            x = x.next;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ListNode dummyHead = new ListNode(-1);
        ListNode newNode = dummyHead;

        for (ListNode x:lists){
            storeValueInPriorityQueue(x,pq);
            // Iterate on the x which is list in the (storeValueInPriorityQueue) function
        }
        while (pq.size()>0){
            ListNode nn = new ListNode(pq.remove());
            dummyHead.next = nn;
            dummyHead = dummyHead.next;
        }

        return newNode.next;
    }
}
