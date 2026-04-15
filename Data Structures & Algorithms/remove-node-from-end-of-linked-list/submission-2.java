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
    public static int findLen (ListNode temp){
        int count = 0;
        while (temp!=null){
            temp = temp.next;
            count++;
        }
        
        return count;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null){
            return null;
        }
        if (head.next==null && n==1){
            return null;
        }

        int len = findLen (head);
        int find = len-n;
        int curr = 0;
        
        ListNode temp = head;
        if (find==0){
            return temp.next;
        }
        while (find-1!=curr){
            temp = temp.next;
            curr++;
        }

        temp.next = temp.next.next;

        return head;

    }
}
