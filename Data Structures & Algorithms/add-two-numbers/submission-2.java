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
        ListNode nn = new ListNode (-1);
        ListNode nnHead = nn;
        int carry = 0;
        while (l1!=null && l2!=null){
            int sum = l1.val+l2.val+carry;
            carry = 0;
            if (sum>=10){
                carry = sum/10;
                sum = sum%10;
                ListNode newNode = new ListNode(sum);
                nn.next = newNode;

            }
            else{
                ListNode newNode = new ListNode(sum);
                nn.next = newNode;
            }
            l1 = l1.next;
            l2 = l2.next;
            nn = nn.next;
        }

        while (l1!=null){
            int sum = l1.val+carry;
            carry = 0;
            if (sum>=10){
                carry = sum/10;
                sum = sum%10;
                ListNode newNode = new ListNode(sum);
                nn.next = newNode;
            }
            else{
                ListNode newNode = new ListNode(sum);
                nn.next = newNode;
            }
            l1 = l1.next;
            nn = nn.next;
        }

        while (l2!=null){
            int sum = l2.val+carry;
            carry = 0;
            if (sum>=10){
                carry = sum/10;
                sum = sum%10;
                ListNode newNode = new ListNode(sum);
                nn.next = newNode;
            }
            else{
                ListNode newNode = new ListNode(sum);
                nn.next = newNode;
            }
            l2 = l2.next;
             nn = nn.next;
        }

        if (carry>0){
            ListNode newNode = new ListNode(carry);
            nn.next = newNode;
            nn = nn.next;
        }
 

        return nnHead.next;
    }
}
