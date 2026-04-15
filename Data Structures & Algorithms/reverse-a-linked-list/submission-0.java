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
    public ListNode reverseList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode dummyNode = new ListNode(-1);
        ListNode dummyHead = dummyNode;
        if (head==null){
            return null;
        }
        if (head.next==null){
            return head;
        }

        
        while (head!=null){
            list.add(head.val);
            head = head.next;
        }

        int x = list.size()-1;
        while (x>=0){
          ListNode currentNode = new ListNode(list.get(x));
          dummyNode.next = currentNode;
          dummyNode = dummyNode.next;
          x--;
        }


        return dummyHead.next;

    }
}